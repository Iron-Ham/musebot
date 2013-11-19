import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.*;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class LessonViewer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -359398248582066716L;
	private Image image;
	String filePath;
	private JWebBrowser fileBrowser;	//Use a web component to display the PDF
	public LessonViewer(String path) { 
		filePath = path; 			//You need absolute filepath!
		fileBrowser = new JWebBrowser(); 
		fileBrowser.setBarsVisible(false);
		fileBrowser.setStatusBarVisible(false);
		setSize(1280, 720);
		setLayout(new BorderLayout());
		add(fileBrowser, BorderLayout.CENTER);
		fileBrowser.navigate(filePath);
	}
	public void setPDFFilePath(String path) {
		filePath = path;
	}
}
