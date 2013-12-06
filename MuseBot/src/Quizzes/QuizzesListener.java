package Quizzes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//THIS CLASS IS THE ACTION LISTENER FOR THE DIFFERENT QUIZZES
public class QuizzesListener implements ActionListener {
	
	Quiz1 q1;
	List<Question> qlist;
	//counter is used to keep track of where the user is at in the program
	int counter;
	Nav_Panel nav;
	String[] answers;
	DisplayQuestion dis;
	
	//constructor and initialize everything
	public QuizzesListener(List<Question> qlist, Quiz1 q1, Nav_Panel nav) {
		this.q1 = q1;
		this.qlist = qlist;
		this.nav = nav;
		counter = 0;
		answers = new String[qlist.size()];
		for(int i = 0; i < qlist.size(); i++)
				answers[i] = "";
	}
	
	//enable or disable next, previous, and start buttons based on where the user is at in the quiz
	public void handleButtons() {
		if(counter == 0) {
			nav.getStart().setEnabled(false);
			nav.getNext().setEnabled(true);
			nav.getSubmit().setEnabled(true);
		}
		if(counter < 1)
			nav.getPrevious().setEnabled(false);
		if(counter < qlist.size())
			nav.getNext().setEnabled(true);
		if(counter >= 1)
			nav.getPrevious().setEnabled(true);
		if(counter == qlist.size()-1)
			nav.getNext().setEnabled(false);
		
	}
	//display a new question in the quiz
	public void displayNewQuestion() {
		dis = new DisplayQuestion(qlist.get(counter));
		q1.setDisplay(dis);
		
		//IF THE USER HAS ALREADY ENTERED ANSWERS FOR THIS QUESTION THEN SET THE FIELDS TO THEIR ANSWER
		if(qlist.get(counter).getType().equals("multiple choice")) {
			for(int i = 0; i < 4; i++)
				dis.getRadioButton()[i].addActionListener(this);
			if(!answers[counter].equals("")) {
				for(int i = 0; i < 4; i++) {
					if(dis.getRadioButton()[i].getActionCommand().equals(answers[counter]))
						dis.getRadioButton()[i].setSelected(true);
				}
			}
		}
		//IF THE USER HAS ALREADY ENTERED ANSWERS FOR THIS QUESTION THEN SET THE FIELDS TO THEIR ANSWER
		else if(qlist.get(counter).getType().equals("identify 4 notes")) {
			String[] s = answers[counter].split(",");
			for(int i = 0; i < s.length; i++) {
				dis.getFields()[i].setText(s[i]);
			}
		}
		//IF THE USER HAS ALREADY ENTERED ANSWERS FOR THIS QUESTION THEN SET THE FIELDS TO THEIR ANSWER
		else if(qlist.get(counter).getType().equals("identify 4 durations") || qlist.get(counter).getType().equals("identify 4 beats") 
				|| qlist.get(counter).getType().equals("identify 4 rests")) {
			String[] s = answers[counter].split(",");
			JComboBox[] combos = dis.getCombos();
			for(int i = 0; i < s.length; i++) {
				for(int j = 0; j < combos[i].getItemCount(); j++)
					if(combos[i].getItemAt(j).equals(s[i]))
						combos[i].setSelectedIndex(j);
			}
		}
			
	}
	//SAVE THE ANSWERS THE USER HAS PROVIDED
	public void handleSheetAnswers() {
		if(qlist.get(counter).getType().equals("identify 4 notes")) {
			JTextField[] field = dis.getFields();
			answers[counter] = "";
			for(int i = 0; i < 4; i++) {
				answers[counter] += field[i].getText() + ",";
			}
		}
		else if(qlist.get(counter).getType().equals("identify 4 durations") || qlist.get(counter).getType().equals("identify 4 beats")
				|| qlist.get(counter).getType().equals("identify 4 rests")) {
			JComboBox[] combos = dis.getCombos();
			answers[counter] = "";
			for(int i = 0; i < 4; i++) {
				answers[counter] += combos[i].getSelectedItem() + ",";
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		//WHEN THE USER PRESSES A BUTTON
		if(source instanceof JButton) {
			JButton src = (JButton) source;
			if(src.getActionCommand().equals("Start")) {
				displayNewQuestion();
				handleButtons();
			}
			//display the previous question
			else if(src.getActionCommand().equals("Previous")) {
				if(!qlist.get(counter).getType().equals("multiple choice")) {
					handleSheetAnswers();
				}
				counter--;
				handleButtons();
				displayNewQuestion();
			}
			//display the next question
			else if(src.getActionCommand().equals("Next")) {
				if(!qlist.get(counter).getType().equals("multiple choice")) {
					handleSheetAnswers();
				}
				counter++;
				handleButtons();
				displayNewQuestion();
			}
			//tally up score and show the results
			else if(src.getActionCommand().equals("Submit")) {
				if(!qlist.get(counter).getType().equals("multiple choice")) {
					handleSheetAnswers();
				}
				double right = 0;
				double total = 0;
				//go through the submitted answers and the actual answers
				//if they get it right increment right
				for(int i = 0; i < answers.length; i++) {
					if(answers[i].contains(",")) {
						String[] foo = answers[i].split(",");
						for(int j = 0; j < 4; j++) {
							System.out.println(foo[j] + "\t\t" + qlist.get(i).getAnswer(j));
							if(foo[j].toUpperCase().equals(qlist.get(i).getAnswer(j))) {
								right++;
							}
						}
					}
					else if(answers[i].equals(qlist.get(i).getAnswer(0))) {
						right++;
					}
				}
				for(int i = 0; i < qlist.size(); i++) {
					if(qlist.get(i).getType().equals("multiple choice"))
						total++;
					else
						total += 4;
				}
				//create a frame to display the results as a percentage
				int sc = (int)((float)right/total*100);
				JFrame jf = new JFrame();
				jf.setSize(100, 100);
				JLabel score = new JLabel("" + sc + "%");
				jf.setLayout(new FlowLayout());
				jf.add(score);
				jf.setVisible(true);
			}
			
		}
		//if they selected a radio button then save their answer
		else if(source instanceof JRadioButton) {
			JRadioButton rb = (JRadioButton)source;
			answers[counter] = rb.getActionCommand();
		}
	}
	
}
