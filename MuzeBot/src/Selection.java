import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Selection {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
//		splashFrame splashSplash = new splashFrame();
//		splashSplash.setVisible(true);
		
		
		JPanel lesson = new Lesson();
		
//		 JFrame f = new JFrame();
//         f.setContentPane(lesson);
//         f.setSize(1280, 720);                                 DO NOT DELETE
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setResizable(false);
//         f.setVisible(true);
         
         
         
         Practice practice = new Practice();
         practice.setSize(1280, 720);
         practice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         practice.setResizable(false);
		 practice.setVisible(true);
        
		 
//		 Quiz quiz = new Quiz();
//         quiz.setSize(1280, 720);
//         quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//         quiz.setResizable(false);
//		 quiz.setVisible(true);

		

	}

}
