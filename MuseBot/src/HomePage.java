import java.awt.event.*;
import javax.swing.*;


public class HomePage extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JButton lessons;
	JButton quizzes;
	JButton practice;
	
	public HomePage() {
		//basic setup for the frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Welcome to MuseBot");
		setSize(1280, 720);
		
		//create the background
		ImageIcon ii = new ImageIcon("./Statics/Images/mainpage.png");
		ii.setImage(ii.getImage().getScaledInstance(1280, 720, 0));
		JLabel background=new JLabel(ii);
		background.setBounds(0, 0, 1280, 720);
		
		//create a layered pane
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(this.getSize());
		
		//add the background
		layeredPane.add(background, new Integer(0));
		
		//initialize the buttons
		lessons = new JButton("lesson");
		practice = new JButton("practice");
		quizzes = new JButton("quizzes");
		
		//set the button's bounds
		lessons.setBounds(350, 350, 100, 300);
		practice.setBounds(600, 350, 100, 300);
		quizzes.setBounds(850, 350, 100, 300);
		
		//add the buttons to the layered pane
		layeredPane.add(lessons, new Integer(1));
		layeredPane.add(practice, new Integer(1));
		layeredPane.add(quizzes, new Integer(1));
		
		//show the layered pane
		add(layeredPane);
		
		//create and register the listener
		ButtonListener l = new ButtonListener(this);
		this.registerActionListener(l);
	}
	
	//method that registers the button listener to each of our buttons
	public void registerActionListener(ButtonListener a) {
		lessons.addActionListener(a);
		quizzes.addActionListener(a);
		practice.addActionListener(a);
	}
	
	//the button listener
	public class ButtonListener implements ActionListener {
		
		HomePage frame;
		public ButtonListener(HomePage frame) {		this.frame = frame;		}
		
		//only function needed to implement from ActionListener
		public void actionPerformed(ActionEvent e)
		{
		    Object source = e.getSource();
		    if (source instanceof JButton) {
		    	JButton b = (JButton)source;
		    	String buttonText = b.getActionCommand();
		    	if(buttonText == "lesson") {
		    		
		    	}
		    	else if(buttonText == "practice") {
		    		
		    	}
		    	else if(buttonText == "quiz") {
		    		
		    	}
		    	frame.dispose();
		    }
		}
	}

	//main method to display our startup screen
	public static void main(String[] args) {
		HomePage frame = new HomePage();
		frame.setVisible(true);
	}
}
