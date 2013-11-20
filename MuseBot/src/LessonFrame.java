import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.File;

public class LessonFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5668599322703453262L;
	private JLabel lessonContent;
	private String imgPath;
	private JLabel divider;
	private JLabel btnGradient;
	private JButton[] btnArray;
	
	public LessonFrame() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720); 
		setResizable(false);
		
		//Initialization
		imgPath = new String();
		imgPath = "Extras/Lessons/Lesson1.png";
		btnArray = new JButton[6];
		divider = new JLabel(new ImageIcon(new File("Extras/Resources/Lesson/Divider.png").toString()));
		btnGradient = new JLabel(new ImageIcon(new File("Extras/Resources/Lesson/LessonPanel_bg.png").toString()));
		lessonContent = new JLabel(new ImageIcon(imgPath));
		JLayeredPane mypane = new JLayeredPane(); 

		//Set sizes and locations
		btnGradient.setSize(260, 720);
		btnGradient.setLocation(1020, 0);
		divider.setSize(20, 720);
		divider.setLocation(1000, 0);
		
		mypane.add(btnGradient, new Integer(0));
		mypane.add(divider, new Integer(1));
		add(mypane);
		a
		

		
	}
	public static void main(String[] args) { 
		LessonFrame f = new LessonFrame();
		f.setVisible(true);
	}
}
