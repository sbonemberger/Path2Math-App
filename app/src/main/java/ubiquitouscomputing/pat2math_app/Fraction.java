package ubiquitouscomputing.pat2math_app;

import java.util.ArrayList;

public class Fraction implements Cloneable {
	protected int numerator, denominator;
	protected boolean isIrreducible;
	protected ArrayList<StepSimplification> stepsSimplification;
	protected Fraction irreducibleFormat;
	
	public Fraction (int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		this.stepsSimplification = new ArrayList<StepSimplification>();
		
		simplify();	
	}
	
	public Fraction (String fraction) {
		String[] terms = fraction.split("/");
		this.numerator = Integer.parseInt(terms[0]);
		this.denominator = Integer.parseInt(terms[1]); 
		this.stepsSimplification = new ArrayList<StepSimplification>();
		
		simplify();			
	}
	
	public void simplify(int divisor) {
		numerator /= divisor;
		denominator /= divisor;
		isIrreducible = equals(irreducibleFormat);
		
	}
	
	public boolean equals(Fraction f) {
		return (numerator == f.numerator && denominator == f.denominator);
	}
	
	private void simplify() {
		try {
		irreducibleFormat = (Fraction) this.clone();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro na c�pia do objeto");
		}
		
		int currentPrimeNumber = 2;
		int i = 1;
		
		do {
			if (irreducibleFormat.numerator % currentPrimeNumber == 0 && irreducibleFormat.denominator % currentPrimeNumber == 0) {
				irreducibleFormat.numerator /= currentPrimeNumber;
				irreducibleFormat.denominator /= currentPrimeNumber;
				
				stepsSimplification.add(new StepSimplification(irreducibleFormat.toString(), currentPrimeNumber));
			}
			
			else
				currentPrimeNumber = Utility.primeNumbers[i++];
		} while (currentPrimeNumber <= irreducibleFormat.numerator && currentPrimeNumber <= irreducibleFormat.denominator);
		
		isIrreducible = equals(irreducibleFormat);
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public boolean isIrreducible() {
		return isIrreducible;
	}
	public void setIrreducible(boolean isIrreducible) {
		this.isIrreducible = isIrreducible;
	}
	public ArrayList<StepSimplification> getStepsSimplification() {
		return stepsSimplification;
	}
	public void setStepsSimplification(ArrayList<StepSimplification> stepsSimplification) {
		this.stepsSimplification = stepsSimplification;
	}
	public Fraction getIrreducibleFormat() {
		return irreducibleFormat;
	}
	public void setIrreducibleFormat(Fraction irreducibleFormat) {
		this.irreducibleFormat = irreducibleFormat;
	}
	
}
