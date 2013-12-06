package Lesson;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


/*
 * This class is the listener class for the LessonPanel
 * @author: Hesham Salman
 */
public class LessonListener implements ActionListener {
	LessonPanel panel;
	
	public LessonListener(LessonPanel p) throws IOException { 
		panel = p;
		panel.registerListener(this);
	}
	@Override 
	public void actionPerformed(ActionEvent e){ 
		Object source = e.getSource();
		if (source instanceof JButton) { 
			JButton button = (JButton) source;
			try { //Changes lessons
				if (button == panel.lessonBtns[0]) { 
					panel.changeImg(0);	
				}
				else if (button == panel.lessonBtns[1]) { 
					panel.changeImg(1);
				}
				else if (button == panel.lessonBtns[2]) { 
					panel.changeImg(2);
				}
				else if (button == panel.lessonBtns[3]) { 
					panel.changeImg(3);
				}
				else if (button == panel.lessonBtns[4]) {
					panel.changeImg(4);
				}
				else if (button == panel.lessonBtns[5]) { 
					panel.changeImg(5);
				}
			}catch (IOException ex) { 
				ex.printStackTrace();
			}
			
		}
	}
}
