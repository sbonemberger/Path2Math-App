package ubiquitouscomputing.pat2math_app.controller;

public class StepSimplification {
	private String fraction;
	private int divisor;
	
	public StepSimplification(String fraction, int divisor) {
		this.fraction = fraction;
		this.divisor = divisor;
	}

	public String getFraction() {
		return fraction;
	}

	public void setFraction(String fraction) {
		this.fraction = fraction;
	}

	public int getDivisor() {
		return divisor;
	}

	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}
	
	public String toString() {
		return fraction + " (dividida por " + divisor + ")";
	}
	
	

}
