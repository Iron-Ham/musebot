package Question;


import javax.swing.*;

import SheetMusic.SheetMusicComponent;
//THIS CLASS WILL CREATE A JPANEL WHICH IS USED TO DISPLAY A QUESTION BASED ON QUESTION TYPE
//@author Michael Wayman

public class DisplayQuestion extends JPanel {
	private static final long serialVersionUID = 1L;

	Question q;
	JTextArea question;
	
	//multiple choice components
	JRadioButton[] rb;
	ButtonGroup bg;
	
	//fill in components
	JTextField[] field;
	JLabel[] label;
	SheetMusicComponent smc;
	
	//combobox components
	JComboBox[] durationOptions;
	
	//constructor
	public DisplayQuestion(Question q) {
		this.q = q;
		//display the question based on the question type
		if(q.getType().equals("multiple choice"))
			initMultipleChoice();
		else if(q.getType().equals("identify 4 notes")) {
			initSheetMusicFieldChoice();
		}
		else if(q.getType().equals("identify 4 durations")) {
			initSheetMusicDurationChoice();
		}
		else if(q.getType().equals("identify 4 beats")) {
			initSheetMusicDurationChoice();
		}
		else if(q.getType().equals("identify 4 rests")) {
			initSheetMusicDurationChoice();
		}
		
	}

	//If the question uses combo boxes like for duration type
	public void initSheetMusicDurationChoice() {
		//initialize the components add add them to the DisplayQuestion pane
		label = new JLabel[4];
		question = new JTextArea();
		question.setBounds(25, 230, 850, 45);
		question.setText(q.getQuestion());
		add(question);
		question.setEditable(false);
		setLayout(null);
		smc = new SheetMusicComponent(q.getSheetMusic(), 15, 25, 850, 150, this);
		smc.setBounds(15,  25,  875, 250);
		add(smc);
		String[] options;
		//set the combo box choices based on question type
		if(q.getType().equals("identify 4 beats")) {
			String[] tmp = {"1", "2", "3", "4", "5", "6", "7", "8", "half", "quarter", "eighth", "sixteenth", "three sixteenths", "three eighths", "three halves"};
			options = tmp;
		}
		else {
			String[] tmp = {"whole", "half", "quarter", "eighth", "sixteenth", "thirtysecond"};
			options = tmp;
		}
		durationOptions = new JComboBox[4];
		//position and add the labels and combo boxes
		for(int i = 0; i < 4; i++) {
			durationOptions[i] = new JComboBox(options);
			durationOptions[i].setSelectedIndex(0);
			durationOptions[i].setBounds(100 + (i*130), 330, 120, 20);
			add(durationOptions[i]);
			
			label[i] = new JLabel();
			label[i].setText("Note " + (i+1) + " beat");
			label[i].setBounds(100 + (i*130), 305, 80, 20);
			add(label[i]);
		}
	}
	//if the question type requires the user enter information
	//used for not recognition
	public void initSheetMusicFieldChoice() {
		//initialize and add the components
		field = new JTextField[4];
		label = new JLabel[4];
		question = new JTextArea();
		question.setBounds(25, 230, 850, 45);
		question.setText(q.getQuestion());
		add(question);
		question.setEditable(false);
		setLayout(null);
		smc = new SheetMusicComponent(q.getSheetMusic(), 15, 25, 850, 150, this);
		smc.setBounds(15,  25,  875, 250);
		add(smc);
		//position and add the fields and labels
		for(int i = 0; i < 4; i++) {
			field[i] = new JTextField();
			field[i].setBounds(300 + (i*60), 330, 50, 20);
			add(field[i]);
			label[i] = new JLabel();
			label[i].setText("Note " + (i+1));
			label[i].setBounds(300 + (i*60), 305, 50, 20);
			add(label[i]);
		}
	}
	
	//if the question is a multiple choice question drawn from the questionbank
	public void initMultipleChoice() {
		bg = new ButtonGroup();
		question = new JTextArea();
		question.setBounds(25, 50, 850, 45);
		question.setText(q.getQuestion());
		question.setEditable(false);
		setLayout(null);
		add(question);
		rb = new JRadioButton[4];
		for(int i = 0; i < 4; i++) {
			rb[i] = new JRadioButton(q.getOption(i));
			bg.add(rb[i]);
			rb[i].setBounds(150, 200 + 50*(i), 500, 25);
			add(rb[i]);
		}
	}
	public JTextField[] getFields() {
		return field;
	}
	public JComboBox[] getCombos() {
		return durationOptions;
	}
	public JTextArea getTextArea() {
		return question;
	}
	public ButtonGroup getButtonGroup() {
		return bg;
	}
	public JRadioButton[] getRadioButton() {
		return rb;
	}
}
