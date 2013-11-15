import java.util.ArrayList;
import java.util.List;


public class Measure {
	List<Note> notes;
	
	//Constructors
	public Measure()						{	notes = new ArrayList<Note>();	}
	public Measure(String usingTimeSignature)	{
		notes = new ArrayList<Note>();
		}
	
	//Setters and Getters
	public List<Note> getNotes()				{	return notes;				}
	public void addNote(Note note)				{	notes.add(note);			}
	public void addNote(Note note, int index) 	{	notes.add(index, note);		}
	public Note getNote(int index)				{	return notes.get(index);	}
	public int numberOfNotes()					{	return notes.size();		}
	
	
	
	//Generates a random measure based on a time signature given in a string format
	public Measure generateRandomMeasure(String timeSignature) {
		Measure m = new Measure();
		//while there aren't enough notes in the measure keep adding random notes
		while (m.beatsToTimeSignatureRatio(timeSignature) != 1) {
			Note n = new Note();
			n = n.randomNote();
			m.addNote(n);
			//If there are too many beats in the measure then remove a note
			if (m.beatsToTimeSignatureRatio(timeSignature) > 1)
				m.getNotes().remove(m.numberOfNotes()-1);
		}
		
		return m;
	}
	
	//Returns the ratio of beats in the measure to time signature
	//Used for generating random notes to know when to stop adding notes
	public double beatsToTimeSignatureRatio(String timeSignature) {
		String[] 	ts 			= timeSignature.split("/");
		int 		numerator 	= Integer.valueOf(ts[0]);
		int 		denominator = Integer.valueOf(ts[1]);
		double		tsRatio		= (double)numerator/(double)denominator;
		
		double		beatsRatio	= 0;
		for(int i = 0; i < numberOfNotes(); i++)
			beatsRatio += getNote(i).doubleValueOfDuration();
		
		return beatsRatio / tsRatio;
	}
	
	
	//String representation of the measure object
	public String toString() {
		String out = "";
		for(Note n : notes)
			out += n + "\t\t";
		return out;
	}
}
