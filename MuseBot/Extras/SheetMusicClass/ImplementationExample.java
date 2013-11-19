import javax.swing.*;


public class ImplementationExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public ImplementationExample() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,600);
		
		
		SheetMusic sm = new SheetMusic("4/4");
		
		sm = sm.generateRandomSheetMusic(4);
		
		SheetMusicComponent smc = new SheetMusicComponent(sm, 50, 60, 900, 200, this);
		add(smc);
	}
}
