package Practice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PracticeListener implements ActionListener {

	Practice p;
	
	public PracticeListener(Practice p) {
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JButton) {
			JButton b = (JButton)source;
			if(b.getActionCommand().equals("Check Answers")) {
				JFrame answers = new JFrame();
				answers.setBounds(300, 300, 250, 100);
				JLabel[] ans = new JLabel[4];
				answers.setLayout(new GridLayout(2, 1));
				for(int i = 0; i < 4; i++) {
					ans[i] = new JLabel("#" + (i+1) + "  " + p.getCurrentQuestion().getAnswer(i));
					answers.add(ans[i]);
				}
				answers.setVisible(true);
			}
			else if(b.getActionCommand().equals("Next Question")) {
				p.showNewQuestion();
			}
		}
		
	}
}
