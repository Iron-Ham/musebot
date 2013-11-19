import java.awt.*;
import javax.swing.*;


public class MainPage extends JFrame {
	
	JButton lessons;
	JButton quizzes;
	JButton practice;
	
	public MainPage() {
		
		//basic setup for the frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Welcome to MuseBot");
		setSize(960, 540);
		//setLayout(null);
		
		
		//create and add the background
		ImageIcon ii = new ImageIcon("./Statics/Images/mainpage.png");
		ii.setImage(ii.getImage().getScaledInstance(960, 540, 0));
		JLabel background=new JLabel(ii);
		add(background);
		
		
		//create and add the buttons
		lessons  = new JButton();
		quizzes  = new JButton();
		practice = new JButton();
		
		Dimension d = new Dimension(75, 75);
		
		lessons.setSize(75, 75);
		lessons.setMaximumSize(d);
		lessons.setOpaque(false);
		//add(lessons);
		
		
	}


	public static void main(String[] args) {
		MainPage mp = new MainPage();
		mp.setVisible(true);
	}
}
