import java.awt.*;
import javax.swing.*;


public class ImplementationExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public ImplementationExample() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		
		
		SheetMusic sm = new SheetMusic("4/4");
		sm = sm.generateRandomSheetMusic(2);
		SheetMusicComponent smc = new SheetMusicComponent(sm, 0, 0, 500, 200, this);
		setLayout(new BorderLayout());
		
		//JLabel label = new JLabel();
		//label.setText("WeedWacker");
		//JLabel label1 = new JLabel();
		//label1.setText("WeedWacker");
		//JLabel label2 = new JLabel();
		//label2.setText("WeedWacker");
		//add(label, BorderLayout.EAST);
		//add(label1, BorderLayout.WEST);
		//add(label2, BorderLayout.NORTH);
		//add(smc, BorderLayout.CENTER);
		add(smc);
		
	}
}
