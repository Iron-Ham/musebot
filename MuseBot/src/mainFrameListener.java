import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;


public class mainFrameListener implements ActionListener {
	
	mainFrame frame;
	
	int currentPane;
	
	public mainFrameListener(mainFrame f) {
		frame = f;
		currentPane = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JButton) {
			JButton b = (JButton)source;
			if(b.getActionCommand().equals("home")) {
				if(currentPane != 1) {
					if(currentPane != 0)
						frame.getPrimaryPane().remove(4);
				}
				currentPane = 1;
			}
			else if(b.getActionCommand().equals("lesson")) {
				if(currentPane != 2) {
					try {
						if(currentPane != 0)
							frame.getPrimaryPane().remove(4);
							LessonPanel somePanel;
							somePanel = new LessonPanel();
							somePanel.setBounds(100, 0, 1180, 720);
							LessonListener listen = new LessonListener(somePanel);
							frame.getPrimaryPane().add(somePanel, new Integer(1));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				currentPane = 2;
			}
			else if(b.getActionCommand().equals("practice")) {
				if(currentPane != 3) {
					if(currentPane != 0)
						frame.getPrimaryPane().remove(4);
				}
				currentPane = 3;
			}
			else if(b.getActionCommand().equals("quiz")) {
				if(currentPane != 4) {
					if(currentPane != 0)
						frame.getPrimaryPane().remove(4);
					Quiz q = new Quiz();
					q.setBounds(100, 0, 1180, 720);
					QuizListener l = new QuizListener(q);
					q.registerListeners(l);
					frame.getPrimaryPane().add(q, new Integer(1));
				}
				currentPane = 4;
			}
		}
		
	}

}
