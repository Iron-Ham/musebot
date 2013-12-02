import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Quizzes.Quiz1;


public class QuizListener implements ActionListener {
	
	Quiz frame;
	int currentQuiz;
	
	public QuizListener(Quiz frame) {
		this.frame = frame;
		currentQuiz = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(source instanceof JButton) {
			JButton src = (JButton) source;
			if(src.getActionCommand().equals("Quiz 1") && currentQuiz != 1) {
				Quiz1 q1 = new Quiz1(1);
				if(currentQuiz != 0)
					frame.getLayeredPane().remove(0);
				currentQuiz = 1;
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 2") && currentQuiz != 2) {
				Quiz1 q1 = new Quiz1(2);
				if(currentQuiz != 0)
					frame.getLayeredPane().remove(0);
				currentQuiz = 2;
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 3") && currentQuiz != 3) {
				Quiz1 q1 = new Quiz1(3);
				if(currentQuiz != 0)
					frame.getLayeredPane().remove(0);
				currentQuiz = 3;
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 4") && currentQuiz != 4) {
				Quiz1 q1 = new Quiz1(4);
				if(currentQuiz != 0)
					frame.getLayeredPane().remove(0);
				currentQuiz = 4;
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 5") && currentQuiz != 5) {
				Quiz1 q1 = new Quiz1(5);
				if(currentQuiz != 0)
					frame.getLayeredPane().remove(0);
				currentQuiz = 5;
				frame.getLayeredPane().add(q1, new Integer(4));
			}
			else if(src.getActionCommand().equals("Quiz 6") && currentQuiz != 6) {
				Quiz1 q1 = new Quiz1(6);
				if(currentQuiz != 0)
					frame.getLayeredPane().remove(0);
				currentQuiz = 6;
				frame.getLayeredPane().add(q1, new Integer(4));
			}
		}
		
	}

}
