import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Practice extends JFrame{

	
	public Practice() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		
		SheetMusic sm = new SheetMusic("4/4");
		sm = sm.generateRandomSheetMusic(2);
		SheetMusicComponent smc = new SheetMusicComponent(sm, 0, 0, 500, 200, this);
		setLayout(new BorderLayout());
		add(smc);
		
	}
}
