import java.io.File;

import javax.swing.*;


public class mainFrame extends JFrame {

	private JLayeredPane primaryPane;
	private JLabel navBar;
	private JLayeredPane currentPane;
	public mainFrame() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(1280, 720);
		setResizable(false);
		
		
		//Initialization
		JLayeredPane primaryPane = new JLayeredPane();
		JLayeredPane currentPane = new JLayeredPane();
		navBar = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/navBar_Home").toString()));
		navBar.setLocation(0,0);
		navBar.setSize(100,720);
		currentPane.add(navBar);
		
	}
}
