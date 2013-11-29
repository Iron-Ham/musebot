import java.awt.event.*;
import java.io.*;

import javax.swing.*;

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
			try { 
				if (button == panel.lessonBtns[0]) { 
					panel.changeImg("Extras/Lessons/Lesson1.png");
				}
				else if (button == panel.lessonBtns[1]) { 
					panel.changeImg("Extras/Lessons/Lesson2.png");
				}
				else if (button == panel.lessonBtns[2]) { 
					panel.changeImg("Extras/Lessons/Lesson3.png");
				}
				else if (button == panel.lessonBtns[3]) { 
					panel.changeImg("Extras/Lessons/Lesson4.png");
				}
				else if (button == panel.lessonBtns[4]) {
					panel.changeImg("Extras/Lessons/Lesson5.png");
				}
				else if (button == panel.lessonBtns[5]) { 
					panel.changeImg("Extras/Lessons/Lesson6.png");
				}
			}catch (IOException ex) { 
				ex.printStackTrace();
			}
			
		}
	}
}
