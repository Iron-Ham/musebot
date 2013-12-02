package Quizzes;

import java.io.*;
import java.util.*;
import SheetMusic.*;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Quiz1 extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	
	List<Question> qlist;
	
	JPanel displayArea;
	
	int quizNumber;

	public Quiz1(int quizNum) {

		qlist = new ArrayList<Question>();
		
		quizNumber = quizNum;
		
		//set the size
		setBounds(0, 0, 900, 720);
		
		//create the navigation buttons
		Nav_Panel nav = new Nav_Panel();
		nav.setBounds(200, 650, 500, 70);
		
		//add the navigation buttons to the quiz
		add(nav, new Integer(0));
		
		
		if(quizNumber == 1) {
			initMultipleChoiceQuestions("Extras/Quiz Questions/quiz1questions.txt");
			initQuiz1Questions();
		}
		else if(quizNumber == 2) {
			initMultipleChoiceQuestions("Extras/Quiz Questions/quiz1questions.txt");
			initQuiz2Questions();
		}
		else if(quizNumber == 3) {
			initMultipleChoiceQuestions("Extras/Quiz Questions/quiz1questions.txt");
			initQuiz3Questions();
		}
		else if(quizNumber == 4) {
			initMultipleChoiceQuestions("Extras/Quiz Questions/quiz1questions.txt");
			initQuiz4Questions();
		}
		else if(quizNumber == 5) {
			initMultipleChoiceQuestions("Extras/Quiz Questions/quiz1questions.txt");
			initQuiz5Questions();
		}
		else if(quizNumber == 6) {
			initMultipleChoiceQuestions("Extras/Quiz Questions/quiz1questions.txt");
		}
		
		Collections.shuffle(qlist);
		//create and add the action listeners
		QuizzesListener l = new QuizzesListener(qlist, this, nav);
		nav.registerListener(l);
	}
	public void setDisplay(JPanel p) {
		displayArea = new JPanel();
		displayArea = p;
		displayArea.setBounds(0, 0, 900, 650);
		if(getComponentCount() == 2)
			remove(0);
		add(displayArea, new Integer(1));
	}
	public void initMultipleChoiceQuestions(String file) {
		File f = new File(file);
		try {
			Scanner scanner = new Scanner(new BufferedReader(new FileReader(f.getAbsolutePath())));
			while(scanner.hasNext()) {
				Question q = new Question();
				q.setQuestion(scanner.nextLine());
				q.addOption(scanner.nextLine());
				q.addOption(scanner.nextLine());
				q.addOption(scanner.nextLine());
				q.addOption(scanner.nextLine());
				q.addAnswer(scanner.nextLine());
				q.setType("multiple choice");
				qlist.add(q);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public void initQuiz1Questions() {
		int s = qlist.size();
		for(int i = 0; i < s; i ++) {
			Question q = new Question();
			SheetMusic sm = new SheetMusic("4/4");
			sm.useDots(false);
			sm = sm.generateRandomSheetMusic(4);
			q.setSheetMusic(sm);
			q.setQuestion("What are the 1st, 2nd, 3rd, and 4th notes on the sheet music without accents(if applicable)?");
			int w = 0;
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < sm.getMeasure(j).numberOfNotes(); k++) {
					if(w >= 4)
						break;
					w++;
					q.addAnswer(sm.getMeasure(j).getNote(k).getNote().substring(0, 1).toUpperCase());
				}
			}
			q.setType("identify 4 notes");
			qlist.add(q);
		}
		while(qlist.size() > 15) {
			qlist.remove(0);
		}
	}
	public void initQuiz2Questions() {
		int s = qlist.size();
		for(int i = 0; i < s; i ++) {
			Question q = new Question();
			SheetMusic sm = new SheetMusic("4/4");
			sm.useDots(false);
			sm = sm.generateRandomSheetMusic(4);
			q.setSheetMusic(sm);
			q.setQuestion("What are the 1st, 2nd, 3rd, and 4th note durations on the sheet music?");
			int w = 0;
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < sm.getMeasure(j).numberOfNotes(); k++) {
					if(w >= 4)
						break;
					w++;
					q.addAnswer(sm.getMeasure(j).getNote(k).getDuration().toUpperCase());
				}
			}
			q.setType("identify 4 durations");
			qlist.add(q);
		}
		while(qlist.size() > 15) {
			qlist.remove(0);
		}
	}
	public void initQuiz3Questions() {
		int s = qlist.size();
		for(int i = 0; i < s; i ++) {
			Question q = new Question();
			String[] foo = {"4/4", "3/4", "6/8", "3/2"};
			int bar = new Random().nextInt(4);
			SheetMusic sm = new SheetMusic(foo[bar]);
			sm.useDots(false);
			sm = sm.generateRandomSheetMusic(4);
			q.setSheetMusic(sm);
			q.setQuestion("How many beats are the 1st, 2nd, 3rd, and 4th notes on the sheet music?");
			int w = 0;
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < sm.getMeasure(j).numberOfNotes(); k++) {
					if(w >= 4)
						break;
					w++;
					q.addAnswer(Note.getStringRepresentationOfBeatsForDouble(sm.getMeasure(j).getNote(k).doubleValueOfDuration()*Double.valueOf(foo[bar].split("/")[1])).toUpperCase());
				}
			}
			q.setType("identify 4 beats");
			qlist.add(q);
		}
		while(qlist.size() > 15) {
			qlist.remove(0);
		}
	}
	public void initQuiz4Questions() {
		int s = qlist.size();
		for(int i = 0; i < s; i ++) {
			Question q = new Question();
			SheetMusic sm = new SheetMusic("4/4");
			sm = sm.generateRandomRestSheetMusic(4);
			q.setSheetMusic(sm);
			q.setQuestion("What are the 1st, 2nd, 3rd, and 4th rest durations on the sheet music?");
			int w = 0;
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < sm.getMeasure(j).numberOfNotes(); k++) {
					if(w >= 4)
						break;
					w++;
					q.addAnswer(sm.getMeasure(j).getNote(k).getDuration().toUpperCase());
				}
			}
			q.setType("identify 4 rests");
			qlist.add(q);
		}
		while(qlist.size() > 15) {
			qlist.remove(0);
		}
	}
	public void initQuiz5Questions() {
		int s = qlist.size();
		for(int i = 0; i < s; i ++) {
			Question q = new Question();
			String[] foo = {"4/4", "3/4", "6/8", "3/2"};
			int bar = new Random().nextInt(4);
			SheetMusic sm = new SheetMusic(foo[bar]);
			sm = sm.generateRandomSheetMusicDotsOnly(4);
			q.setSheetMusic(sm);
			q.setQuestion("How many beats are the 1st, 2nd, 3rd, and 4th notes on the sheet music?");
			int w = 0;
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < sm.getMeasure(j).numberOfNotes(); k++) {
					if(w >= 4)
						break;
					w++;
					q.addAnswer(Note.getStringRepresentationOfBeatsForDouble(sm.getMeasure(j).getNote(k).doubleValueOfDuration()*Double.valueOf(foo[bar].split("/")[1])).toUpperCase());
				}
			}
			q.setType("identify 4 beats");
			qlist.add(q);
		}
		while(qlist.size() > 15) {
			qlist.remove(0);
		}
	}
	
}