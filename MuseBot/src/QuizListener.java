import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Quizzes.Quiz1;


public class QuizListener implements ActionListener {
	
	Quiz frame;
	
	public QuizListener(Quiz frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source instanceof JButton) {
			JButton src = (JButton) source;
			if(src.getActionCommand().equals("Quiz 1")) {
				Quiz1 q1 = new Quiz1(1);
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 2")) {
				Quiz1 q1 = new Quiz1(2);
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 3")) {
				Quiz1 q1 = new Quiz1(3);
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 4")) {
				Quiz1 q1 = new Quiz1(4);
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 5")) {
				Quiz1 q1 = new Quiz1(5);
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 6")) {
				
			}
		}
		
	}

}
