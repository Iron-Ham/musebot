import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LessonPanel extends JLayeredPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7237085649944010724L;
	private JLabel lessonContent;
	private JLabel btnGradient;
	private ImageIcon image;
	private JLabel divider;
	private String imgPath;
	public JButton[] lessonBtns;
	private JScrollPane scrollPane;
	private int counter;
	
	public LessonPanel() throws IOException { 
		setSize(1180, 720);
		counter = 3;
		
		//Initialization
		lessonBtns = new JButton[6];
		imgPath = new String();
		imgPath = "Extras/Lessons/Lesson1.png";
		image = new ImageIcon(ImageIO.read(new File(imgPath)));
		picturePrep();
		divider = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/divBar.png").toString()));
		lessonContent = new JLabel(image);
		buttonInitialization();
		btnGradient = new JLabel(new ImageIcon(new File("Extras/Resources/Lesson/LessonPanel_bg.png").toString()));
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(lessonContent);
		scrollPane.setLocation(0, 0);
		scrollPane.setSize(900, 720);
		btnGradient.setLocation(920, 0);
		divider.setLocation(900,0);
		divider.setSize(20, 720);
		add(btnGradient, new Integer(0));
		add(divider, new Integer(1));
		add(scrollPane, new Integer(2));
	}
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public JButton[] getLessonBtns() {
		return lessonBtns;
	}

	public void setLessonBtns(JButton[] lessonBtns) {
		this.lessonBtns = lessonBtns;
	}

	private void buttonInitialization() { 
		int x = 0;
		for (int i = 0; i < lessonBtns.length; i++) { 
			lessonBtns[i] = new JButton();
			x = (120 * i);
			lessonBtns[i].setLocation(920, x);
			lessonBtns[i].setSize(260, 120);
		}
		lessonBtns[0].setIcon(new ImageIcon(new File("Extras/Resources/Lesson/LP_Buttons/Lesson1.png").toString()));
		lessonBtns[1].setIcon(new ImageIcon(new File("Extras/Resources/Lesson/LP_Buttons/Lesson2.png").toString()));
		lessonBtns[2].setIcon(new ImageIcon(new File("Extras/Resources/Lesson/LP_Buttons/Lesson3.png").toString()));
		lessonBtns[3].setIcon(new ImageIcon(new File("Extras/Resources/Lesson/LP_Buttons/Lesson4.png").toString()));
		lessonBtns[4].setIcon(new ImageIcon(new File("Extras/Resources/Lesson/LP_Buttons/Lesson5.png").toString()));
		lessonBtns[5].setIcon(new ImageIcon(new File("Extras/Resources/Lesson/LP_Buttons/Lesson6.png").toString()));
		for (int i = 0; i < lessonBtns.length; i++) { 
			add(lessonBtns[i], new Integer(3));
		}
	}
	
	public void changeImg(String path) throws IOException { 
		image = new ImageIcon(ImageIO.read(new File(path)));
		picturePrep();
		lessonContent = new JLabel(image);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(lessonContent);
		scrollPane.setLocation(0, 0);
		counter++;
		scrollPane.setSize(900, 720);
		add(scrollPane, new Integer(counter));

	}
	public void registerListener(ActionListener listener) {
		for (int i = 0; i < lessonBtns.length; i++) { 
			lessonBtns[i].addActionListener(listener);
		}
	}
	public void picturePrep() { 
		double imageWidth = image.getIconWidth();
		int imageHeight = image.getIconHeight();
		imageWidth = 880/imageWidth;
		imageHeight = (int) (imageWidth * imageHeight);
		Image img = image.getImage();
		image = new ImageIcon(img.getScaledInstance(880, imageHeight, Image.SCALE_SMOOTH));
	}
	
}
