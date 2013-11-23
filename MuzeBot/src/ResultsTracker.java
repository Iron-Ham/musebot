import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
	
	public double GetAverageScoresOfQuizes(){
		int tries = 0;
		double sum = 0.00;
		double avg = 0.00;
		
		for (int i = 0; i<QuizList.size(); i++){
			String HighlightQuiz = QuizList.get(i).toString();
			
			
				tries = tries + 1;
				String[] QuizScore = HighlightQuiz.split("\t");
				sum = sum + Double.parseDouble(QuizScore[1]);
			}
		
		
		avg = sum / tries;
		
		return avg;
		
	}
	
public double GetHighScoreOfQuizesByNumber(int Number){
	
	double QL = 0.00;
	double QH = 0.00;
	

	List adaptList = new LinkedList();
	
	
	for (int i = 0; i<QuizList.size(); i++){
		String HighlightQuiz = QuizList.get(i).toString();
		Double score = Double.valueOf(HighlightQuiz.split("\t")[1]);
		
		if (Integer.valueOf(HighlightQuiz.charAt(0)) == Number){
			adaptList.add(score);
		}
		
		if (Integer.valueOf(HighlightQuiz.charAt(1)) == Number){
			adaptList.add(score);
		}

		if (Integer.valueOf(HighlightQuiz.charAt(2)) == Number){
			adaptList.add(score);
		}

		if (Integer.valueOf(HighlightQuiz.charAt(3)) == Number){
			adaptList.add(score);
		}
		if (Integer.valueOf(HighlightQuiz.charAt(4)) == Number){
			adaptList.add(score);
		}

		if (Integer.valueOf(HighlightQuiz.charAt(5)) == Number){
			adaptList.add(score);
		}

		if (Integer.valueOf(HighlightQuiz.charAt(6)) == Number){
			adaptList.add(score);
		}
	}
	double MAX = Collections.max(adaptList);
	adaptList.clear();
	
	return MAX;	
	}

public double GetHighScoreOfQuizes(){
	
	double QL = 0.00;
	double QH = 0.00;
	

	List adaptList = new LinkedList();
	
	
	for (int i = 0; i<QuizList.size(); i++){
		String HighlightQuiz = QuizList.get(i).toString();
		Double score = Double.valueOf(HighlightQuiz.split("\t")[1]);
			adaptList.add(score);
	}
	
	double MAX = Collections.max(adaptList);
	adaptList.clear();
	
	return MAX;	
	}

public int GetQuizAttempts(int Number){
int attempts = 0;
	
	
	for (int i = 0; i<QuizList.size(); i++){
		String HighlightQuiz = QuizList.get(i).toString();
		Double score = Double.valueOf(HighlightQuiz.split("\t")[1]);
		
		if (Integer.valueOf(HighlightQuiz.charAt(0)) == Number){
			attempts=attempts+1;
		}
		
		if (Integer.valueOf(HighlightQuiz.charAt(1)) == Number){
			attempts=attempts+1;
		}

		if (Integer.valueOf(HighlightQuiz.charAt(2)) == Number){
			attempts=attempts+1;
		}

		if (Integer.valueOf(HighlightQuiz.charAt(3)) == Number){
			attempts=attempts+1;
		}
		if (Integer.valueOf(HighlightQuiz.charAt(4)) == Number){
			attempts=attempts+1;
		}

		if (Integer.valueOf(HighlightQuiz.charAt(5)) == Number){
			attempts=attempts+1;
		}

		if (Integer.valueOf(HighlightQuiz.charAt(6)) == Number){
			attempts=attempts+1;
		}
	}
	return attempts; 
	
}



public double GetLowScoreOfQuizesByNumber(int Number){
	
	double QL = 0.00;
	double QH = 0.00;
	

	List adaptList = new LinkedList();
	
	
	for (int i = 0; i<QuizList.size(); i++){
		String HighlightQuiz = QuizList.get(i).toString();
		Double score = Double.valueOf(HighlightQuiz.split("\t")[1]);
		
		if (Integer.valueOf(HighlightQuiz.charAt(0)) == Number){
			adaptList.add(score);
		}
		
		if (Integer.valueOf(HighlightQuiz.charAt(1)) == Number){
			adaptList.add(score);
		}

		if (Integer.valueOf(HighlightQuiz.charAt(2)) == Number){
			adaptList.add(score);
		}

		if (Integer.valueOf(HighlightQuiz.charAt(3)) == Number){
			adaptList.add(score);
		}
		if (Integer.valueOf(HighlightQuiz.charAt(4)) == Number){
			adaptList.add(score);
		}

		if (Integer.valueOf(HighlightQuiz.charAt(5)) == Number){
			adaptList.add(score);
		}

		if (Integer.valueOf(HighlightQuiz.charAt(6)) == Number){
			adaptList.add(score);
		}
	}
	double MIN = Collections.min(adaptList);
	
	
	return MIN;	
	}

public double GetLowScoreOfQuizes(){
	
	double QL = 0.00;
	double QH = 0.00;
	

	List adaptList = new LinkedList();
	
	
	for (int i = 0; i<QuizList.size(); i++){
		String HighlightQuiz = QuizList.get(i).toString();
		Double score = Double.valueOf(HighlightQuiz.split("\t")[1]);
			adaptList.add(score);
	}
	
	double MIN = Collections.min(adaptList);
	adaptList.clear();
	
	return MIN;	
	}



public boolean AddScoreOfQuiz(int Number, double Score, String filename) throws IOException{
	File database = new File(filename);
	if(database.exists()){
		
		  FileWriter fstream = new FileWriter(filename);
		  BufferedWriter out = new BufferedWriter(fstream);
		  for (int i = 0; i<QuizList.size(); i++){
			  out.write(QuizList.get(i).toString()); 
			  out.newLine();
		  }
		  QuizList.add(Number + "\t" +Score);
		  out.write(Number + "\t" +Score);
		  out.close();
		  
		  return true;
	  }else{
		  FileWriter fstream = new FileWriter(filename);
		  BufferedWriter out = new BufferedWriter(fstream);
		  out.write(Number + "\t" +Score);
		  out.close();
		  return false;
	  }
	
}
	
}




