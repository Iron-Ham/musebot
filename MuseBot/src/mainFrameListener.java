import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.io.*;

import javax.swing.JButton;
import javax.swing.JLabel;

import Lesson.LessonListener;
import Lesson.LessonPanel;
import Practice.Practice;
import Practice.PracticeListener;

/**
 * 
 * @author Michael Wayman
 * Modified and Refactored by Hesham Salman
 *
 */
public class mainFrameListener implements ActionListener {
	
	mainFrame frame;
	int currentPane;
	LessonPanel somePanel;
	LessonListener lessonListener;
	
	public mainFrameListener(mainFrame f) throws IOException {
		frame = f;
		currentPane = 0;
		somePanel = new LessonPanel();
		lessonListener = new LessonListener(somePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JButton) {
			JButton b = (JButton)source;
			/*if(b.getActionCommand().equals("home")) {
				if(currentPane != 0) {
					//frame.getPrimaryPane().remove(0);
					//Makes no changes until the HomePane is added
				}
				currentPane = 0;
			}*/
			//display the lessons pane
			if(b.getActionCommand().equals("lesson")) {
				if(currentPane != 2) {
					if(currentPane != 0) {
						//remove any old panes
						frame.getPrimaryPane().remove(0);
					}
						somePanel.setBounds(100, 0, 1180, 720);
						frame.getPrimaryPane().add(somePanel, new Integer(3));
					}
				currentPane = 2;
			}
			//display the practice pane
			else if(b.getActionCommand().equals("practice")) {
				if(currentPane != 3) {
					//remove any old panes
					if(currentPane != 0)
						frame.getPrimaryPane().remove(0);
					Practice p = new Practice();
					PracticeListener pl = new PracticeListener(p);
					p.registerListeners(pl);
					p.setBounds(100, 0, 1180, 720);
					frame.getPrimaryPane().add(p, new Integer(3));
				}
				currentPane = 3;
			}
			//display the quiz pane
			else if(b.getActionCommand().equals("quiz")) {
				if(currentPane != 4) {
					//remove any old panes
					if(currentPane != 0)
						frame.getPrimaryPane().remove(0);
					Quiz q = new Quiz();
					q.setBounds(100, 0, 1180, 720);
					QuizListener l = new QuizListener(q);
					q.registerListeners(l);
					frame.getPrimaryPane().add(q, new Integer(3));
				}
				currentPane = 4;
			}
		}
		
	}

}
