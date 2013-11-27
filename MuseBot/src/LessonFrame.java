import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LessonFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5668599322703453262L;
	private ImageIcon image;
	private String imgPath;
	private JLabel divider;
	private JLabel btnGradient;
	private JLabel navBar;
	private JLabel lessonContent;
	private JButton[] navBtns;
	private JButton[] lessonBtns;
	
	public LessonFrame() throws IOException { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720); 
		setResizable(false);
		
		//Initialization
		imgPath = new String();
		imgPath = "Extras/Lessons/Lesson1.png";
		image = new ImageIcon(ImageIO.read(new File(imgPath)));
		picturePrep();
		navBtns = new JButton[4];
		lessonBtns = new JButton[6];
		divider = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/divBar.png").toString()));
		btnGradient = new JLabel(new ImageIcon(new File("Extras/Resources/Lesson/LessonPanel_bg.png").toString()));
		navBar = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/navBar_Lesson.png").toString()));
		JLayeredPane mypane = new JLayeredPane(); 
		lessonContent = new JLabel(image);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lessonContent);
		for (int i = 0; i < navBtns.length; i++) { 
			navBtns[i] = new JButton();
		}
		
		//Set sizes and locations
		btnGradient.setSize(260, 720);
		navBtns[0].setSize(100, 94);
		navBtns[0].setLocation(0,0);
		navBtns[1].setSize(100, 104);
		navBtns[1].setLocation(0,101);
		navBtns[2].setSize(100, 104);
		navBtns[2].setLocation(0, 210);
		navBtns[3].setSize(100, 102);
		navBtns[3].setLocation(0, 320);
		int x = 0;
		for (int i = 0; i < lessonBtns.length; i++) { 
			lessonBtns[i] = new JButton();
			x = (120 * i);
			lessonBtns[i].setLocation(1020, x);
			lessonBtns[i].setSize(260, 120);
		}
		btnGradient.setLocation(1020, 0);
		navBar.setSize(100, 720);
		navBar.setLocation(0,0);
		divider.setSize(20, 720);
		divider.setLocation(1000, 0);
		scrollPane.setLocation(100,0);
		scrollPane.setSize(900, 720);
		
		//Add to the panel and frame 
		mypane.add(btnGradient, new Integer(0));
		mypane.add(divider, new Integer(1));
		mypane.add(navBar, new Integer(2));
		for (int i = 0; i < navBtns.length; i++) { 
			navBtns[i].setOpaque(false);
			navBtns[i].setContentAreaFilled(false);
			navBtns[i].setBorderPainted(false);
			mypane.add(navBtns[i], new Integer(3));
		}
		for (int i = 0; i < lessonBtns.length; i++) { 
			lessonBtns[i].setOpaque(false);
			lessonBtns[i].setContentAreaFilled(false);
			lessonBtns[i].setBorderPainted(false);
			mypane.add(lessonBtns[i], new Integer(4));
		}
		mypane.add(scrollPane);
		add(mypane);
	}
	
	public void picturePrep() { 
		double imageWidth = image.getIconWidth();
		int imageHeight = image.getIconHeight();
		imageWidth = 880/imageWidth;
		imageHeight = (int) (imageWidth * imageHeight);
		System.out.println("Height = " + imageHeight + "\n Width = " + imageWidth);
		Image img = image.getImage();
		image = new ImageIcon(img.getScaledInstance(880, imageHeight, Image.SCALE_SMOOTH));
	}
	
	public static void main(String[] args) throws IOException { 
		LessonFrame f = new LessonFrame();
		f.setVisible(true);
	}
}
