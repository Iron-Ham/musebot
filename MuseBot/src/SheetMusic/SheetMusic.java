package SheetMusic;


import java.util.ArrayList;
import java.util.List;


public class SheetMusic {
	List<Measure> measures;
	
	boolean useDot;
	
	//timeSignation is a string representation of a time signature e.g. "4/4", "3/6", "6/8", etc.
	String timeSignature;
	
	//Constructors
	public SheetMusic(String timeSignature) {
		measures 			= new ArrayList<Measure>();
		this.timeSignature 	= timeSignature;
		useDot = true;
		}
	
	//Getters and Setters
	public List<Measure> getMeasures()					{	return measures;				}
	public void addMeasure(Measure measure)				{	measures.add(measure);			}
	public void addMeasure(Measure measure, int index) 	{	measures.add(index, measure);	}
	public Measure getMeasure(int index)				{	return measures.get(index);		}
	public int numberOfMeasures()						{	return measures.size();			}
	public String getTimeSignature()					{	return timeSignature;			}
	public void useDots(boolean b)						{	useDot = b;						}
	
	//Generates a random sheetmusic object with the specified number of measures
	public SheetMusic generateRandomSheetMusic(int numberOfMeasures) {
		SheetMusic sm = new SheetMusic(timeSignature);
		for(int i = 0; i < numberOfMeasures; i++) {
			Measure m = new Measure();
			m.useDots(useDot);
			m = m.generateRandomMeasure(timeSignature);
			sm.addMeasure(m);
		}
		return sm;
	}
	
	public SheetMusic generateRandomRestSheetMusic(int numberOfMeasures) {
		SheetMusic sm = new SheetMusic(timeSignature);
		for(int i = 0; i < numberOfMeasures; i++) {
			Measure m = new Measure();
			m = m.generateRandomRestMeasure(timeSignature);
			sm.addMeasure(m);
		}
		return sm;
	}
	
	public SheetMusic generateRandomSheetMusicDotsOnly(int numberOfMeasures) {
		SheetMusic sm = new SheetMusic(timeSignature);
		for(int i = 0; i < numberOfMeasures; i++) {
			Measure m = new Measure();
			m = m.generateRandomDotsMeasure(timeSignature);
			sm.addMeasure(m);
		}
		return sm;
	}
	
	//String representation of the sheetmusic object
	public String toString() {
		String out = "";
		for(Measure m : getMeasures())
			out += m + "\n";
		return out;
	}
	
}
