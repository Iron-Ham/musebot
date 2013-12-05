import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class mainFrame extends JFrame {
	/**
	 * The purpose of this class is to hold the navigation bar and other panels
	 * @author: Hesham Salman
	 */
	
	private static final long serialVersionUID = 1L;
	private JLayeredPane primaryPane;
	private JLabel navBar;
	private JButton[] navButtons;
	private JLabel bg;
	public mainFrame() throws IOException { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(1280, 720);
		setResizable(false);
		
		
		//Initialization
		navButtons = new JButton[4];
		primaryPane = new JLayeredPane();
		
		bg = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/Blue_Abstract_Home.png").toString()));
		bg.setSize(1180, 720);
		bg.setLocation(100,0);
		
		navBar = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/navBar_home.png").toString()));
		navBar.setSize(100,720);
		navBar.setLocation(0,0);
		primaryPane.add(navBar, new Integer(0));

		buttonInitialization();
		for (int i = 0; i < navButtons.length; i++) { 
			primaryPane.add(navButtons[i], new Integer(1));
		}
		primaryPane.add(bg, new Integer(2));
		add(primaryPane);

	}
	
	public JLayeredPane getPrimaryPane() {
		return primaryPane;
	}
	
	public static void main(String[] args) throws IOException { 
		mainFrame frame = new mainFrame();
		mainFrameListener l = new mainFrameListener(frame);
		frame.registerButtonListeners(l);
		frame.setVisible(true);
	}
	
	public void registerButtonListeners(ActionListener l) {
		for (int i = 0; i < navButtons.length; i++) { 
			navButtons[i].addActionListener(l);
		}
	}
	
	private void buttonInitialization() { 
		for (int i = 0; i < navButtons.length; i++) { 
			navButtons[i] = new JButton();
		}
		navButtons[0].setActionCommand("home");
		navButtons[0].setSize(100, 94);
		navButtons[0].setLocation(0,0);
		navButtons[0].setIcon(new ImageIcon(new File("Extras/Resources/Frame/homeButton.png").toString()));
		navButtons[1].setActionCommand("lesson");
		navButtons[1].setSize(100, 104);
		navButtons[1].setLocation(0,101);
		navButtons[1].setIcon(new ImageIcon(new File("Extras/Resources/Frame/lessonButton.png").toString()));
		navButtons[2].setActionCommand("practice");
		navButtons[2].setSize(100, 104);
		navButtons[2].setLocation(0, 210);
		navButtons[2].setIcon(new ImageIcon(new File("Extras/Resources/Frame/practiceButton.png").toString()));
		navButtons[3].setActionCommand("quiz");
		navButtons[3].setSize(100, 102);
		navButtons[3].setLocation(0, 320);
		navButtons[3].setIcon(new ImageIcon(new File("Extras/Resources/Frame/quizButton.png").toString()));
	}
}
