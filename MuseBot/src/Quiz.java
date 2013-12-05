import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;


public class Quiz extends JLayeredPane {

	private static final long serialVersionUID = 1L;
	
	JLayeredPane layeredPane;
	JButton[] quizButton;
	
	JPanel quiz;
	
	public Quiz() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(1180, 720);
		layeredPane = new JLayeredPane();
		
		ImageIcon divii = new ImageIcon("Extras/Resources/Frame/divBar.png");
		JLabel divBar = new JLabel(divii);
		divBar.setBounds(900, 0, 20, 720);
		
		ImageIcon navii = new ImageIcon("Extras/Resources/Frame/Panel_bg.png");
		JLabel navBar = new JLabel(navii);
		navBar.setBounds(920, 0, 260, 720);
		
		layeredPane.add(navBar, new Integer(0));
		layeredPane.add(divBar, new Integer(1));
		setBackground(Color.WHITE);
		
		quizButton = new JButton[6];
		for(int i = 0; i < 6; i++) {
			int x = (120 * i);
			quizButton[i] = new JButton();
			quizButton[i].setActionCommand("Quiz " + (i+1));
			quizButton[i].setLocation(920, x);
			quizButton[i].setSize(260,120);
		}
		quizButton[0].setIcon(new ImageIcon(new File("Extras/Resources/Quiz/Quiz1.png").toString()));
		quizButton[1].setIcon(new ImageIcon(new File("Extras/Resources/Quiz/Quiz2.png").toString()));
		quizButton[2].setIcon(new ImageIcon(new File("Extras/Resources/Quiz/Quiz3.png").toString()));
		quizButton[3].setIcon(new ImageIcon(new File("Extras/Resources/Quiz/Quiz4.png").toString()));
		quizButton[4].setIcon(new ImageIcon(new File("Extras/Resources/Quiz/Quiz5.png").toString()));
		quizButton[5].setIcon(new ImageIcon(new File("Extras/Resources/Quiz/Quiz6.png").toString()));
		for (int i = 0; i < 6; i++) {
			layeredPane.add(quizButton[i], new Integer(2));
		}

		layeredPane.setBounds(0, 0, 1180, 720);
		add(layeredPane);
	}
	
	public JPanel getQuizPanel() {
		return quiz;
	}
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}
	
	public void registerListeners(ActionListener l) {
		for(int i = 0; i < 6; i++)
			quizButton[i].addActionListener(l);
	}
	
	
}
