import java.util.Random;

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
	public void setNote(String note)			{	this.note = note;			}
	public void setDuration(String duration)	{	this.duration = duration;	}
	public void setAccent(String accent)		{	this.accent = accent;		}
	public void setDotted(boolean dotted)		{	this.isDotted = dotted;		}
	
	//Generates a random note
	public Note randomNote() {
		Random r = new Random();
		int intNoteVal = r.nextInt(25);
		int intDuraVal = r.nextInt(6);
		
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

	//Returns the string representation of a duration based on integer value
	public String durationByIntValue(int intVal) {
		String[] durations = { "whole", "half", "quarter", "eighth", "sixteenth", "thirtysecond" };
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
