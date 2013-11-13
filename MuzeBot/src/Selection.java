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
		
		 JFrame f = new JFrame();
         f.setContentPane(lesson);
         f.setSize(1280, 720);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setVisible(true);

		//lesson.show(true);

	}

}
