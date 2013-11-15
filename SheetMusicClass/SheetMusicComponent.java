import java.awt.*;


@SuppressWarnings("serial")
public class SheetMusicComponent extends Canvas {

	SheetMusic sheetMusic;
	Dimension origin;
	Dimension size;
	Container parent;
	
	public SheetMusicComponent(SheetMusic sheetMusic, int x, int y, int width, int height, Container parent) {
		this.sheetMusic		 = sheetMusic;
		size				 = new Dimension(width, height);
		origin				 = new Dimension(x, y);
		this.parent			 = parent;
	}
	
	public void paint (Graphics g) {
		//draw a white rectangle to fit the sheet music
		g.setColor(Color.WHITE);
		g.fillRect(origin.width, origin.height, size.width, size.height);
		
		//set the color to black to draw the staff lines
		g.setColor(Color.BLACK);
		
		//draw the two lines on the sides of the rectangle
		g.drawLine(5, (int)(size.height*.05+size.height*.075), 5, (int)(size.height - size.height*.05-size.height*.075));
		g.drawLine(size.width-5, (int)(size.height*.05+size.height*.075), size.width-5, (int)(size.height - size.height*.05-size.height*.075));
		
		//position and draw the staff lines based on the dimensions of our component
		int x1 = origin.width+5;
		int x2 = size.width-5;
		int y1 = (int) (origin.height + .05 * size.height);
		for (int i = 0; i < 2; i++) {
			 y1 += (.075*size.height*i);
			for (int j = 0; j < 5; j++) {
				y1 += .075*size.height;
				g.drawLine(x1, y1, x2, y1);
			}
		}
		
		Font font = new Font("Bruvera", Font.PLAIN, 15);
		g.setFont(font);
		
		int measures = sheetMusic.numberOfMeasures();
		
		for(int k = 0; k < measures; k++) {
			int numOfNotes = sheetMusic.getMeasure(k).numberOfNotes();
			for(int i = 0; i < numOfNotes; i++) {
				String note = sheetMusic.getMeasure(k).getNote(i).getNote();
				int x = (int) (size.width*.1 + (size.width*.9*k)/2+(size.width*.9/2/numOfNotes*i));
				int y = 0;
				
				for(int j = 0; j < Note.listOfNotes.length; j++) {
					if(note.equals(Note.listOfNotes[j])) {
						y = size.height+3 - (int)((float)(.075*(size.height))*((float)(j+1.0)/2.0));
						if(j >= 24 || j <= 0 || j == 12) {
							g.drawLine(x-8, y-5, x+23, y-5);
						}
					}
					
				}
				g.drawChars(note.toCharArray(), 0, 2, x, y);
			}
			g.drawLine((int)(size.width*.1 + size.width*.9/2),
					(int)(size.height*.05 + size.height*.075), 
					(int)(size.width*.1 + size.width*.9/2), 
					(int)(size.height*.05 + size.height*.075*5));
			g.drawLine((int)(size.width*.1 + size.width*.9/2),
					(int)(size.height*.05 + size.height*.075*7), 
					(int)(size.width*.1 + size.width*.9/2), 
					(int)(size.height*.05 + size.height*.075*11));
		}
		
	}
	
	public Dimension preferredSize() {
		return minimumSize();
	 	}
	public synchronized Dimension minimumSize() {
		return size;
		}
	
	public int positionOnStaff(String note) {
		
		return 0;
	}
	
}
