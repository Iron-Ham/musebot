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
	private ImageIcon images[];
	private JLabel divider;
	private String imgPath;
	public JButton[] lessonBtns;
	private JScrollPane scrollPane;
	private int counter;
	
	public LessonPanel() throws IOException { 
		setSize(1180, 720);
		counter = 3;		
		//Initialization
		images = new ImageIcon[6];
		images();
		lessonBtns = new JButton[6];
		imgPath = new String();
		imgPath = "Extras/Lessons/Lesson1.png";
		divider = new JLabel(new ImageIcon(new File("Extras/Resources/Frame/divBar.png").toString()));
		lessonContent = new JLabel(images[0]);
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
	
	public void changeImg(int i) throws IOException { 
		lessonContent = new JLabel(images[i]);
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
	public void picturePrep(ImageIcon icon, int i) { 
		double imageWidth = icon.getIconWidth();
		int imageHeight = icon.getIconHeight();
		imageWidth = 880/imageWidth;
		imageHeight = (int) (imageWidth * imageHeight);
		Image img = icon.getImage();
		images[i] = new ImageIcon(img.getScaledInstance(880, imageHeight, Image.SCALE_SMOOTH));
	}
	public void images() throws IOException { 
		for (int i =0; i< images.length; i++) { 
			images[i] = new ImageIcon();
		}
		images[0] = new ImageIcon(ImageIO.read(new File("Extras/Lessons/Lesson1.png")));
		images[1] = new ImageIcon(ImageIO.read(new File("Extras/Lessons/Lesson2.png")));
		images[2] = new ImageIcon(ImageIO.read(new File("Extras/Lessons/Lesson3.png")));
		images[3] = new ImageIcon(ImageIO.read(new File("Extras/Lessons/Lesson4.png")));
		images[4] = new ImageIcon(ImageIO.read(new File("Extras/Lessons/Lesson5.png")));
		images[5] = new ImageIcon(ImageIO.read(new File("Extras/Lessons/Lesson6.png")));
		for (int i = 0; i < images.length; i++) { 
			picturePrep(images[i], i);
		}

	}
	
	
}
