import java.io.File;

import javax.swing.*;


public class mainFrame extends JFrame {

	private JLayeredPane primaryPane;
	private JLabel navBar;
	private JButton[] navButtons;
	private JLayeredPane currentPane;
	public mainFrame() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(1280, 720);
		setResizable(false);
		
		
		//Initialization
		navButtons = new JButton[4];
		JLayeredPane primaryPane = new JLayeredPane();
		JLayeredPane currentPane = new JLayeredPane();
		navBar = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/navBar_home.png").toString()));
		navBar.setSize(100,720);
		navBar.setLocation(0,0);
		primaryPane.add(navBar, new Integer(0));
		buttonInitialization();
		
		add(primaryPane);
	}
	
	public static void main(String[] args) { 
		mainFrame frame = new mainFrame();
		frame.setVisible(true);
	}
	private void buttonInitialization() { 
		for (int i = 0; i < navButtons.length; i++) { 
			navButtons[i] = new JButton();
		}
		System.out.println(navButtons.length);
		navButtons[0].setSize(100, 94);
		navButtons[0].setLocation(0,0);
		navButtons[0].setIcon(new ImageIcon(new File("Extras/Resources/Frame/homeButton.png").toString()));
		navButtons[1].setSize(100, 104);
		navButtons[1].setLocation(0,101);
		navButtons[1].setIcon(new ImageIcon(new File("Extras/Resources/Frame/lessonButton.png").toString()));
		navButtons[2].setSize(100, 104);
		navButtons[2].setLocation(0, 210);
		navButtons[2].setIcon(new ImageIcon(new File("Extras/Resources/Frame/practiceButton.png").toString()));
		navButtons[3].setSize(100, 102);
		navButtons[3].setLocation(0, 320);
		navButtons[3].setIcon(new ImageIcon(new File("Extras/Resources/Frame/quizButton.png").toString()));
		for (int i =0; i < navButtons.length; i++) { 
			primaryPane.add(navButtons[i], new Integer(1));
		}
	}
}
