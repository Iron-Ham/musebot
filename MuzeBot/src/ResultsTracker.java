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
	
	public double GetAverageScoresOfQuizesByNumber(int Number){
		int tries = 0;
		double sum = 0.00;
		double avg = 0.00;
		
		for (int i = 0; i<QuizList.size(); i++){
			String HighlightQuiz = QuizList.get(i).toString();
			
			if (Integer.valueOf(HighlightQuiz.charAt(0)) == Number){
				tries = tries + 1;
				String[] QuizScore = HighlightQuiz.split("\t");
				sum = sum + Double.parseDouble(QuizScore[1]);
			}
		}
		
		avg = sum / tries;
		
		return avg;
		
	}
	
public List GetHighLowScoresOfQuizByNumber(int Number){
	
	double QL = 0.00;
	double QH = 0.00;
	
	List<Double> a = new LinkedList<Double>();
	a.add(QL);
	a.add(QH);
	
	return a;	
	}
	
}
