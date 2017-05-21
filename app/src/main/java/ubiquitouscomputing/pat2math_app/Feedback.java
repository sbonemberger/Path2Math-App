package ubiquitouscomputing.pat2math_app;

public class Feedback {
	private boolean isCorrectAnswer, isFinalAnswer;
	private Hint hint;
	private String text;
	
	public Feedback(boolean isCorrectAnswer, boolean isFinalAnswer, Hint hint, String text) {
		this.isCorrectAnswer = isCorrectAnswer;
		this.isFinalAnswer = isFinalAnswer;
		this.hint = hint;
		this.text = text;
	}
	
	public Feedback(boolean isCorrectAnswer, boolean isFinalAnswer) {
		this.isCorrectAnswer = isCorrectAnswer;
		this.isFinalAnswer = isFinalAnswer;
	}

	public boolean isCorrectAnswer() {
		return isCorrectAnswer;
	}

	public void setCorrectAnswer(boolean isCorrectAnswer) {
		this.isCorrectAnswer = isCorrectAnswer;
	}

	public boolean isFinalAnswer() {
		return isFinalAnswer;
	}

	public void setFinalAnswer(boolean isFinalAnswer) {
		this.isFinalAnswer = isFinalAnswer;
	}

	public Hint getHint() {
		return hint;
	}

	public void setHint(Hint hint) {
		this.hint = hint;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		String s = "Resposta correta";
		
		if (!isCorrectAnswer)
			s = "Resposta errada, " + text + " (" + hint + ")";
		
		return s;
	}
}
