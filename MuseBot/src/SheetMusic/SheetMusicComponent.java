package SheetMusic;
import java.awt.*;
import java.io.File;
import java.io.IOException;


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
		drawCanvas(g);
		//draw the lines that go on the side of the staff
		drawSideLines(g);
		//draw the staff
		drawStaff(g);
		//draw the clefs
		drawClefs(g);
		//draw the time signature
		drawTimeSignature(g);
		//draw the measures and notes
		for(int i = 0; i < sheetMusic.numberOfMeasures(); i++)
			drawMeasure(g, i);
		//draw the measure separators (if applicable)
		drawMeasureSeparators(g);
		
	}
	
	public static int getBravuraIntForInt(int index) {
		int[] map = new int[10];
		map[0] = 59936;
		map[1] = 59937;
		map[2] = 59939;
		map[3] = 59940;
		map[4] = 59941;
		map[5] = 59943;
		map[6] = 59947;
		map[7] = 59949;
		map[8] = 59951;
		map[9] = 59952;
		return map[index];
	}
	public void drawTimeSignature(Graphics g) {
		String smts = sheetMusic.getTimeSignature();
		String[] 	ts 			= smts.split("/");
		int 		numerator 	= getBravuraIntForInt(Integer.valueOf(ts[0]));
		int 		denominator = getBravuraIntForInt(Integer.valueOf(ts[1]));
		File f = new File("src/SheetMusic/Bravura.otf");
		Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, f);
			font = font.deriveFont((float) (size.height*.5));
			g.setFont(font);
			g.drawChars(Character.toChars(numerator), 0, 1, (int) (size.width*.05 + origin.width+size.height*.075), (int) (origin.height+size.height*.05 + size.height*.075*3));
			g.drawChars(Character.toChars(denominator), 0, 1, (int) (size.width*.05 + origin.width+size.height*.075), (int) (origin.height+size.height*.05 + size.height*.075*5));
		}
		catch(FontFormatException | IOException e)
		{
		}
	}
	
	public void drawClefs(Graphics g) {
		File f = new File("src/SheetMusic/Bravura.otf");
		Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, f);
			font = font.deriveFont((float) (size.height*.2));
			g.setFont(font);
			g.drawChars(Character.toChars(57440), 0, Character.toChars(57440).length, (int) (size.width*.015 + origin.width), (int) (origin.height+size.height*.05 + size.height*.075*4));
			g.drawChars(Character.toChars(57455), 0, Character.toChars(57455).length, (int) (size.width*.015 + origin.width), (int) (origin.height+size.height*.05 + size.height*.075*8));
		}
		catch(FontFormatException | IOException e)
		{
		}
	}
	
	//goes through all the notes in the specified measure and draws them in the correct location
	public void drawMeasure(Graphics g, int measure) {
		File f = new File("src/SheetMusic/Bravura.otf");
		Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, f);
			font = font.deriveFont((float) (size.height*.075*2.5));
			g.setFont(font);
			
			int numOfNotes 	= sheetMusic.getMeasure(measure).numberOfNotes();
			for(int i = 0; i < numOfNotes; i++) {
				Note note = sheetMusic.getMeasure(measure).getNote(i);
				double startingAt 	= (size.width*.1 + size.width*.9/sheetMusic.numberOfMeasures()*measure);
				double x 			= (int) (startingAt + size.width*.9/(numOfNotes+1)*(i+1)/sheetMusic.numberOfMeasures() + origin.width - size.width*.075/8);
				double intNoteVal	= Note.getIntValueForNote(note.getNote());
				double y 			= size.height*.05 + (.075*(size.height)*intNoteVal/2);
				
				if((intNoteVal >= 24 || intNoteVal <= 0 || intNoteVal == 12) && !note.getNote().equals("rest"))
					g.drawLine((int)(x-.075/3*size.height), (int)(size.height-y-1+.075*size.height/4+origin.height), 
							(int)(x+.075*size.height), (int)(size.height-y-1+.075*size.height/4+origin.height));
				
				
//57862
				//System.out.println(note.getNote());
				
				if(!note.getNote().equals("rest")) {
					//draw the dot if applicable
					if(note.dotted())
						g.drawChars(Character.toChars(57878), 0, 1, (int)(x + .075*size.height), (int)(size.height - y + origin.height + size.height*.075/10));
					//draw the duration
					if(note.getDuration() == "whole")
						g.drawChars(Character.toChars(57857), 0, 1, (int)x, (int)(size.height - y + origin.height + size.height*.075/8));
					if(note.getDuration() == "half")
						g.drawChars(Character.toChars(57858), 0, 1, (int)x, (int)(size.height - y + origin.height + size.height*.075/8));
					if(note.getDuration() == "quarter")
						g.drawChars(Character.toChars(57860), 0, 1, (int)x, (int)(size.height - y + origin.height + size.height*.075/8));
					if(note.getDuration() == "eighth")
						g.drawChars(Character.toChars(57862), 0, 1, (int)x, (int)(size.height - y + origin.height + size.height*.075/8));
					if(note.getDuration() == "sixteenth")
						g.drawChars(Character.toChars(57864), 0, 1, (int)x, (int)(size.height - y + origin.height + size.height*.075/8));
					if(note.getDuration() == "thirtysecond")
						g.drawChars(Character.toChars(57866), 0, 1, (int)x, (int)(size.height - y + origin.height + size.height*.075/8));
					
					//draw the accent
					if(note.getAccent() == "sharp")
						g.drawChars(Character.toChars(9839), 0, 1, (int) (x - .05*size.height), (int)(size.height - y - 1 + .075*size.height/8 + origin.height));
					else if(note.getAccent() == "flat")
						g.drawChars(Character.toChars(9837), 0, 1, (int) (x - .05*size.height), (int)(size.height - y - 1 + .075*size.height/8 + origin.height));
				}
				else if(note.getNote().equals("rest")) {
					//draw the duration
					double yPos = size.height*.05 + origin.height + size.height*.075*3 + size.height*.075/8;
					if(note.getDuration() == "whole")
						g.drawChars(Character.toChars(58658), 0, 1, (int)x, (int)(yPos-size.height*.075));
					if(note.getDuration() == "half")
						g.drawChars(Character.toChars(58659), 0, 1, (int)x, (int)yPos);
					if(note.getDuration() == "quarter")
						g.drawChars(Character.toChars(58660), 0, 1, (int)x, (int)yPos);
					if(note.getDuration() == "eighth")
						g.drawChars(Character.toChars(58661), 0, 1, (int)x, (int)yPos);
					if(note.getDuration() == "sixteenth")
						g.drawChars(Character.toChars(58662), 0, 1, (int)x, (int)yPos);
				}
			}
			
			
			
		} catch (FontFormatException | IOException e) {
			System.out.println("error here");
			e.printStackTrace();
		}
	}
	
	//position and draw the staff lines based on the dimensions of our component
	public void drawStaff(Graphics g) {
		double x1 = origin.width+5;
		double x2 = size.width-5 + origin.width;
		double y1 = (origin.height + .05 * size.height);
		for (int i = 0; i < 2; i++) {
			 y1 += (0.075*size.height*i);
			for (int j = 0; j < 5; j++) {
				y1 += .075*size.height;
				g.drawLine((int)x1, (int)y1, (int)x2, (int)y1);
			}
		}
	}
	
	
	//draws a line to separate measures in accordance with common sheet music notation
	public void drawMeasureSeparators(Graphics g) {
		double X1 		= (size.width*.9)/sheetMusic.numberOfMeasures();
		double startY1 	= (size.height*.05 + size.height*.075);
		double endY1 	= (startY1 + size.height*.075*4.0);
		double startY2 	= (endY1 + .075*2*size.height);
		double endY2 	= (startY2 + .075*4*size.height);
		
		for(int i = 1; i < sheetMusic.numberOfMeasures(); i++) {
			g.drawLine((int)(X1*i + origin.width + size.width*.1), (int)startY1+origin.height, (int)(X1*i + origin.width + size.width*.1), (int)endY1+origin.height);
			g.drawLine((int)(X1*i + origin.width + size.width*.1), (int)startY2 + origin.height, (int)(X1*i + origin.width + size.width*.1), (int)endY2 + origin.height);
		}
	}
	
	//draw 2 lines on each side of the canvas
	public void drawSideLines(Graphics g) {
		
		g.setColor(Color.BLACK);
		
		//Set the positions for our lines
		double X1 		= origin.width+5;
		double startY1 	= (size.height*.05+size.height*.075) + origin.height;
		double endY1 	= (size.height - size.height*.05 - size.height*.075) + origin.height;
		double X2 		= size.width-5 + origin.width;
		double startY2 	= (size.height*.05+size.height*.075) + origin.height;
		double endY2 	= (size.height - size.height*.05 - size.height*.075) + origin.height;
		
		//draw the two lines on the sides of the rectangle
		g.drawLine((int)X1, (int)startY1, (int)X1, (int)endY1);
		g.drawLine((int)X2, (int)startY2, (int)X2, (int)endY2);
	}
	
	
	//draw a white rectangle to fit the sheet music
	public void drawCanvas(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(origin.width, origin.height, size.width, size.height);
	}
	public Dimension preferredSize() {
		return minimumSize();
	 	}
	public synchronized Dimension minimumSize() {
		return size;
		}
	
	
}
