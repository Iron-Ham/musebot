import java.awt.event.ActionListener;

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
		
		quizButton = new JButton[6];
		for(int i = 0; i < 6; i++) {
			int x = (120 * i);
			quizButton[i] = new JButton("Quiz " + (i+1));
			quizButton[i].setBounds(920, x, 260, 120);
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
