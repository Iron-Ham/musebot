import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Practice extends JFrame {
	
	public JPanel pane = new JPanel();                             //JPanel init.
	public JPanel pane2 = new JPanel();
	
	private static JTextArea QuestionText; 
	private static JRadioButton aButton;/////Buttons init
	private static JRadioButton bButton;
	private static JRadioButton cButton;
	private static JRadioButton dButton;/////Buttons init
	
	private ButtonGroup groupLayout = new ButtonGroup();
	
	private static JTextArea results = new JTextArea("");
 	
	Practice(String Name) throws IOException {
		super(Name);
	
		aButton = new JRadioButton("A.");
		bButton = new JRadioButton("B.");
		cButton = new JRadioButton("C.");
		dButton = new JRadioButton("D.");
		
		QuestionText = new JTextArea("Press Start");  ////////Textfields
		QuestionText.setLineWrap(true);
		
		SheetMusic sm = new SheetMusic("4/4");
		sm = sm.generateRandomSheetMusic(2);
		SheetMusicComponent smc = new SheetMusicComponent(sm, 0, 0, 636, 140, this);
		pane.add(smc);
		
		//pane.add(QuestionText);
		pane.add(results);                            ///////Textfields
		
	
		Container con = this.getContentPane(); 
		//Frame Inheritance.
		con.add(pane);
		
		
		GridLayout BLay = new GridLayout(5,2,1,2); //Sets Layout
		FlowLayout LLay = new FlowLayout(); 
	
		//Handler handler = new Handler(pane);
		pane.setLayout(BLay);
		pane2.setLayout(LLay);
		
		pane.add(aButton);                   //////////////////Selection Buttons
		//aButton.addActionListener(handler);
		
		pane.add(bButton);
		//bButton.addActionListener(handler);
		
		pane.add(cButton);
		//cButton.addActionListener(handler);
		
		pane.add(dButton);
		//dButton.addActionListener(handler); //////////////////Selection Buttons
		
		//group collection
		groupLayout.add(aButton);
		groupLayout.add(bButton);
		groupLayout.add(cButton);
		groupLayout.add(dButton);
		         
		
	    JButton Start = new JButton("Start");           //////////////Nav Buttons
		LLay.addLayoutComponent(" ",Start);
		//Start.addActionListener(handler);
		
		JButton Submit = new JButton("Submit");
		LLay.addLayoutComponent("YO", Submit);
		//Submit.addActionListener(handler);
		
		JButton Back = new JButton("Back");
		LLay.addLayoutComponent("YO", Back);
		//Back.addActionListener(handler);
		
		JButton Next = new JButton("Next");
		LLay.addLayoutComponent("YO", Next);
	//	Next.addActionListener(handler); 
		
		
		
	
		setResizable(false);
		setVisible(true);
		
	}
	
	public static void loadData(int num, String Q, String A, String B, String C, String D) {  //loads data onto fields
	
		QuestionText.setText(String.valueOf(num)+". " + Q+"?");
		aButton.setText(A+".");
		bButton.setText(B+".");
		cButton.setText(C+".");
		dButton.setText(D+".");
		
		}
	
	public static void setResults(String Results){
		results.setText(Results);                // displays results
	}


		
	}


