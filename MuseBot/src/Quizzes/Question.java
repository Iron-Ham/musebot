package Quizzes;

import java.util.ArrayList;
import java.util.List;

import SheetMusic.SheetMusic;

public class Question {
	String type;
	SheetMusic sm;
	String question;
	List<String> options;
	List<String> answer;
	
	public Question() {
		question 	= new String();
		options 	= new ArrayList<String>();
		answer 		= new ArrayList<String>();
	}
	
	public void setSheetMusic(SheetMusic sm) {
		this.sm = sm;
	}
	
	public SheetMusic getSheetMusic() {
		return sm;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption(int i) {
		return options.get(i);
	}
	public List<String> getOptionList() {
		return options;
	}

	public void addOption(String option) {
		options.add(option);
	}

	public String getAnswer(int i) {
		return answer.get(i);
	}

	public List<String> getAnswerList() {
		return answer;
	}
	public void addAnswer(String answer) {
		this.answer.add(answer);
	}
	public String getType() {
		return type;
	}
	public void setType(String s) {
		type = s;
	}
	public String toString() {
		String s = question + "\nOptions:\n";
		for(int i = 0; i < options.size(); i++)
			s += "\t" + options.get(i) + "\n";
		s += "Answers:\n"; 
		for(int i = 0; i < answer.size(); i++)
			s += "\t" + answer.get(i) + "\n";
		return s;
	}
	
}
