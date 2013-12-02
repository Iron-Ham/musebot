
public class tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Quiz quiz = new Quiz();
		QuizListener l = new QuizListener(quiz);
		quiz.registerListeners(l);
		quiz.setVisible(true);
	}

}
