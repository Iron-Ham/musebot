package Quizzes;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//THIS CLASS CREATES THE NAVIGATION PANEL FOR THE DIFFERENT QUIZZES
//@author Michael Wayman

public class Nav_Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//allocate the buttons for navigation
	JButton start;
	JButton previous;
	JButton next;
	JButton submit;

	public Nav_Panel() {
		//initialize the buttons for navigation
		start 		= new JButton("Start");
		previous 	= new JButton("Previous");
		next 		= new JButton("Next");
		submit 		= new JButton("Submit");
		
		previous.setEnabled(false);
		next.setEnabled(false);
		submit.setEnabled(false);

		//add the buttons to our JPanel
		add(start);
		add(previous);
		add(next);
		add(submit);
	}
	
	//method to register the action listeners
	public void registerListener(ActionListener l) {
		start.addActionListener(l);
		previous.addActionListener(l);
		next.addActionListener(l);
		submit.addActionListener(l);
	}

	public JButton getStart() {
		return start;
	}

	public JButton getPrevious() {
		return previous;
	}

	public JButton getNext() {
		return next;
	}

	public JButton getSubmit() {
		return submit;
	}
	

}
