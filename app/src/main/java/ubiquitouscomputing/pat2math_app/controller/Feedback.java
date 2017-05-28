package ubiquitouscomputing.pat2math_app.controller;

import ubiquitouscomputing.pat2math_app.model.Hint;

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

	public static class Corrector {

        public static Feedback correctsSimplification(Fraction f, double numeratorAnswer, double denominatorAnswer, int levelHint) {
            int numerator = f.getNumerator();
            int denominator = f.getDenominator();
            Hint hint = HintBank.getHintSimplification(0, levelHint, f);

            double divisorNumerator = numerator / numeratorAnswer;
            double divisorDenominator = denominator / denominatorAnswer;

            if (divisorNumerator % 1 == 0 && divisorDenominator % 1 == 0) {
                if (divisorNumerator == divisorDenominator) {
                    Fraction irreducibleFormat = f.getIrreducibleFormat();

                    if (irreducibleFormat.getNumerator() == numeratorAnswer && irreducibleFormat.getDenominator() == denominatorAnswer)
                        return new Feedback(true, true);

                    else
                        return new Feedback(true, false);
                }

                else
                    return new Feedback(false, false, hint, "Você utilizou divisores diferentes para o numerador e o denominador. Lembre-se que o número divisor deve ser o mesmo para ambos");
            }

            else if (divisorNumerator % 1 != 0)
                return new Feedback(false, false, hint, "Você errou o cálculo da divisão no numerador");


            else if (divisorDenominator % 1 != 0)
                return new Feedback(false, false, hint, "Você errou o cálculo da divisão no denominador");

            else
                return new Feedback(false, false, hint, "Você errou o cálculo da divisão no numerador e no denominador");
        }
    }
}
