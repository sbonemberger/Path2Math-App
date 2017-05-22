package ubiquitouscomputing.pat2math_app.model;

public class Hint {
	private String text;
	private int level, points;
	
	public Hint(String text, int level) {
		this.text = text;
		this.level = level;
		this.points = (level + 1) * 2;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String toString() {
		return text + " (n�vel" + level + ")";
	}
}
