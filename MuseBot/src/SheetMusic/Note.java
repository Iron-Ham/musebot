package SheetMusic;
import java.util.Random;

//THIS CLASS DEFINES A NOTE AND HAS METHODS TO GENERATE RANDOM NOTES
//@author MICHAEL WAYMAN

public class Note {
	
	String duration;
	String note;
	String accent;
	boolean isDotted;
	
	//Constructors
	public Note() {}
	public Note(String duration, String note) {
		this.duration	= duration;
		this.note		= note;
	}
	
	//Getters and Setters
	public String getNote()						{	return note;				}
	public String getDuration() 				{	return duration;			}
	public String getAccent()					{	return accent;				}
	public boolean dotted()						{	return isDotted;			}
	public void setNote(String note)			{	this.note = note;			}
	public void setDuration(String duration)	{	this.duration = duration;	}
	public void setAccent(String accent)		{	this.accent = accent;		}
	public void setDotted(boolean dotted)		{	this.isDotted = dotted;		}
	
	//Generates a random note
	public Note randomNote() {
		Random r = new Random();
		int intNoteVal = r.nextInt(25);
		int intDuraVal = r.nextInt(9);
		
		int accentVal  = r.nextInt(100);
		int dottedVal  = r.nextInt(100);
		
		Note n = new Note();
		n.setNote(this.noteByIntValue(intNoteVal));
		n.setDuration(this.durationByIntValue(intDuraVal));
		
		//gives 1/6 odds that it will be dotted
		if (dottedVal%6 == 0 && !n.getDuration().equals("thirtysecond"))
			n.setDotted(true);
		else
			n.setDotted(false);
		
		//gives 1/8 odds that it will have an accent
		if (accentVal%16 == 0)
			n.setAccent("flat");
		else if (accentVal%16 == 1)
			n.setAccent("sharp");
		else
			n.setAccent("none");
		
		return n;
	}
	
	//GENERATE A REST NOTE
	public Note randomRest() {
		Random r = new Random();
		Note n = new Note();
		n.setNote("rest");
		int whichRest = r.nextInt(8);
		n.setDuration(durationByIntValue(whichRest));
		n.setDotted(false);
		n.setAccent("none");
		return n;
	}
	
	public static String getStringRepresentationOfBeatsForDouble(double d) {
		//System.out.println(d);
		if(d == 1)
			return "1";
		if(d == 1.5)
			return "1.5";
		if(d == 2)
			return "2";
		if(d == 3)
			return "3";
		if(d == 0.75)
			return "0.75";
		if(d == 0.1875)
			return "three sixteenths";
		if(d == 0.375)
			return "three eighths";
		if(d == 4)
			return "4";
		if(d == 5)
			return "5";
		if(d == 6)
			return "6";
		if(d == 7)
			return "7";
		if(d == 8)
			return "8";
		if(d == .5)
			return "half";
		if(d == .25)
			return "quarter";
		if(d == .125)
			return "eighth";
		if(d == .075)
			return "sixteenth";
		return "1";
	}

	//Returns the string representation of a duration based on integer value
	//Put more "half" "quarter" and "eighth" in their so that they are more likely to occur than the rarer notes
	public String durationByIntValue(int intVal) {
		String[] durations = { "whole", "half", "half", "quarter", "quarter", "eighth", "eighth", "sixteenth", "thirtysecond" };
		return durations[intVal];
	}
	
	//Returns the double value of a notes duration
	public double doubleValueOfDuration() {
		double returnVal = 0;
		if(duration.equals("whole"))
			returnVal = 1.0;
		else if(duration.equals("half"))
			returnVal = 0.5;
		else if(duration.equals("quarter"))
			returnVal = 0.25;
		else if(duration.equals("eighth"))
			returnVal = 0.125;
		else if(duration.equals("sixteenth"))
			returnVal = 0.0625;
		else if(duration.equals("thirtysecond"))
			returnVal = 0.03125;
		
		if (isDotted)
			returnVal = returnVal * 1.5;
		
		return returnVal;
	}
	
	//Return the string representation of a note based on an integer value
	public String noteByIntValue(int intVal) {
		return listOfNotes[intVal];
	}
	
	//A string representation of the note object
	public String toString() {
		return this.note + " " + this.duration + " " + this.accent + " " + String.valueOf(isDotted);
	}
	
	//Get an integer representation of the note
	public static int getIntValueForNote(String note) {
		int val = -1;
		for(int j = 0; j < listOfNotes.length; j++) {
			if(note.equals(listOfNotes[j])) {
				val = j;
			}
		}
		return val;
	}
	
	//A static string of all the possible notes we will accommodate in our program
	static String[] listOfNotes = {	"E0", "F0", "G0", "A0", "B0", "C0", "D0", "E1", "F1", "G1", 
		"A1", "B1", "C1", "D1", "E2", "F2", "G2", "A2", "B2", "C2",
		"D2", "E3", "F3", "G3", "A3"	};
	
	
}
