import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.io.File;
import java.io.IOException;


public class splashFrame extends JFrame {

	/**
	 * @param args
	 */
	
	static JButton lesson;
	static JButton practice;
	static JButton quiz;
	Image backgroundImage;
	
	public splashFrame() throws IOException { 
		//Constructor
		backgroundImage = ImageIO.read(new File("temp welcome screen.png"));
//		backgroundImage = backgroundImage.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		//Overrides the frame's content pane with the background image.
		
//		this.setContentPane(new JLabel(new ImageIcon(backgroundImage)));
//		setContentPane(new JPanel(new BorderLayout()) {
//	        @Override public void paintComponent(Graphics g) {
//	            g.drawImage(backgroundImage, 0, 0, null);
//	        }
//	    });
		
		//Initialization
		lesson = new JButton();
		practice = new JButton();
		quiz = new JButton(); 
		
		//Three required lines
		setSize(1280, 720); 
		setTitle("MuseBot"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); // draw the image
		}
	
	
}
