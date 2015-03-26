package ballot;

public class Question {
	private String question;

	public Question(String q) {
		question = q;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String toString() {
		return question;
	}
}
