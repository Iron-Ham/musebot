package Practice;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.*;

import Quizzes.*;
import SheetMusic.SheetMusic;

public class Practice extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	
	Question currentQuestion;
	
	JButton check;
	JButton next;
	JLabel bg;
	JLayeredPane pane;
	QuizzesListener ql;
	
	public Practice() {
		setBounds(0, 0, 900, 720);
		pane = new JLayeredPane();
		bg = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/Blue_Abstract_Home.png").toString()));
		check = new JButton("Check Answers");
		next = new JButton("Next Question");
		
		check.setBounds(380, 650, 120, 30);
		next.setBounds(500, 650, 120, 30);
		
		pane.setBounds(0, 0, 1180, 720);
		pane.add(check, new Integer(2));
		pane.add(next, new Integer(2));
		currentQuestion = newQuestion();
		DisplayQuestion dq = new DisplayQuestion(currentQuestion);
		dq.setBounds(0, 0, 1180, 720);
		pane.add(dq, new Integer(1));
		pane.add(bg, new Integer(0));
		add(pane, new Integer(0));
	}
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	
	public void showNewQuestion() {
		pane.remove(0);
		currentQuestion = newQuestion();
		DisplayQuestion dq = new DisplayQuestion(currentQuestion);
		dq.setBounds(0, 0, 1180, 650);
		pane.add(dq, new Integer(1));
	}
	
	public void registerListeners(ActionListener l) {
		check.addActionListener(l);
		next.addActionListener(l);
	}
	
	public Question newQuestion() {
		Question q = new Question();
		String[] foo = {"4/4", "3/4", "6/8", "3/2"};
		int bar = new Random().nextInt(4);
		SheetMusic sm = new SheetMusic(foo[bar]);
		sm.useDots(true);
		sm = sm.generateRandomSheetMusic(4);
		q.setSheetMusic(sm);
		int qType = new Random().nextInt(2);
		if(qType == 0) {
			q.setQuestion("What are the 1st, 2nd, 3rd, and 4th notes(without accents) on the sheet music?");
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
		}
		if(qType == 1) {
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
		}

		return q;
	}
}
