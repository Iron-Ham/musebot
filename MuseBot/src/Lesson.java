import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.*;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class Lesson extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -359398248582066716L;
	private Image image;
	private JWebBrowser fileBrowser;	//Use a web component to display the PDF
	public Lesson() { 
		try{
			this.image = ImageIO.read(new File("Statics/Lessons/Lesson 1.jpg"));	//This needs to change later.
			
		} catch (IOException ex) { 
			ex.printStackTrace();
		}
		fileBrowser = new JWebBrowser(); 
		fileBrowser.setBarsVisible(false);
		fileBrowser.setStatusBarVisible(false);
		setSize(1280, 720);
		setTitle("Lesson");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}
}
