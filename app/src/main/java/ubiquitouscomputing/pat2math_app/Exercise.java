package ubiquitouscomputing.pat2math_app;

public class Exercise {
	private Fraction initialFraction, currentFraction;
	private int maxPoints, earnedPoints, lostPoints, numErrors, levelHint;
	private boolean isSolved;
	
	public Exercise(Fraction f, int maxPoints) {
		this.initialFraction = f;
		this.currentFraction = new Fraction(f.getNumerator(), f.getDenominator());
		this.maxPoints = maxPoints;
		this.isSolved = false;
	}
	
	public Feedback answer(int divisor, int numeratorAnswer, int denominatorAnswer) {
		Feedback f = Corrector.correctsSimplification(currentFraction, divisor, numeratorAnswer, denominatorAnswer, levelHint);
		
		if (f.isCorrectAnswer()) {
			levelHint = 0;
			currentFraction.simplify(divisor);
			
			if (f.isFinalAnswer()) {
				earnedPoints = maxPoints - lostPoints;
				isSolved = true;
			}
			
			else {
				earnedPoints += 10;
				
				//Verifica se a soma dos pontos ganhos e perdidos ultrapassa o valor m�ximo de pontos do exerc�cio
				//Se sim, remove os 10 pontos salvos anteriormente
				if ((earnedPoints + lostPoints) >= maxPoints)
					earnedPoints -= 10;
			}
		}
		
		else {
			lostPoints += 5;
			numErrors++;
			
			if (levelHint < 2)
				levelHint++;
		}
		
		return f;
	}
	
	public Hint getHint() {
		Hint h = HintBank.getHintSimplification(0, levelHint, initialFraction);
		lostPoints += h.getPoints();
		
		if (levelHint < 2)
			levelHint++;
		
		return h;
	}

	public Fraction getInitialFraction() {
		return initialFraction;
	}

	public void setInitialFraction(Fraction initialFraction) {
		this.initialFraction = initialFraction;
	}

	public Fraction getCurrentFraction() {
		return currentFraction;
	}

	public void setCurrentFraction(Fraction currentFraction) {
		this.currentFraction = currentFraction;
	}

	public int getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}

	public int getNumErrors() {
		return numErrors;
	}

	public void setNumErros(int numErrors) {
		this.numErrors = numErrors;
	}

	public int getLevelHint() {
		return levelHint;
	}

	public void setLevelHint(int levelHint) {
		this.levelHint = levelHint;
	}

	public boolean isSolved() {
		return isSolved;
	}

	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	public int getEarnedPoints() {
		return earnedPoints;
	}

	public void setEarnedPoints(int earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

	public int getLostPoints() {
		return lostPoints;
	}

	public void setLostPoints(int lostPoints) {
		this.lostPoints = lostPoints;
	}
	
	public String toString() {
		String s = "Fra��o inicial: " + initialFraction +
			       "\nFra��o atual: " + currentFraction +
			       "\nPontua��o: " + (earnedPoints - lostPoints) +
			       "\nErros: " + numErrors;
		
		if (isSolved)
			s += "\nO exerc�cio foi resolvido";
		
		else
			s += "\nO exerc�cio est� em desenvolvimento";
		
		return s;
	}
}
