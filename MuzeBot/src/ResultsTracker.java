import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class ResultsTracker {
List QuizList = new LinkedList();

	public boolean ResultsTracker(String filename) throws IOException{
		
		File database = new File(filename);
		
		if(database.exists()){
			
			  Scanner in = new Scanner(database).useDelimiter("[\t|\n|\r]+");
			  while (in.hasNext()){
				QuizList.add(in.nextLine()); 
			  }
			  
			  return true;
		  }else{
			  database.createNewFile();
			  
			  return false;
		  }
		
	}
	
	public double GetAverageScoresOfQuizByNumber(int Number){
		
		
		return 0.00;
		
	}
	
public List GetHighLowScoresOfQuizByNumber(int Number){
	
	double QL = 0.00;
	double QH = 0.00;
	/////////////////
	List<Double> a = new LinkedList<Double>();
	a.add(QL);
	a.add(QH);
	
	return a;	
	}
	
}
