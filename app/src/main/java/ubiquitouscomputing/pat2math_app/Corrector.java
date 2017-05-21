package ubiquitouscomputing.pat2math_app;

public class Corrector {
	
	public static Feedback correctsSimplification(Fraction f, int divisor, int numeratorAnswer, int denominatorAnswer, int levelHint) {
		int numerator = f.getNumerator();
		int denominator = f.getDenominator();
		Hint hint = HintBank.getHintSimplification(0, levelHint, f);
		
		if (numerator % divisor == 0 && denominator % divisor == 0) {
			int newNumerator = numerator / divisor;
			int newDenominator = denominator / divisor;
			
			if (newNumerator == numeratorAnswer || newDenominator == denominatorAnswer) {
				
				if (newNumerator == numeratorAnswer) {
					if (newDenominator == denominatorAnswer) {
						Fraction irreducibleFormat = f.getIrreducibleFormat();
						
						if (irreducibleFormat.getNumerator() == numeratorAnswer && irreducibleFormat.getDenominator() == denominatorAnswer)
							return new Feedback(true, true);
						
						else
							return new Feedback(true, false);
					}
					
					else 			
						return new Feedback(false, false, hint, "Voc� errou o c�lculo da divis�o no denominador");
				}
				
				else 
					return new Feedback(false, false, hint, "Voc� errou o c�lculo da divis�o no numerador");	
			}
						
			else 
				return new Feedback(false, false, hint, "Voc� errou o c�lculo da divis�o no numerador e no denominador");			
		}
		
		else if (numerator % divisor == 0) 
			return new Feedback(false, false, hint, "O denominador (" + denominator + ") n�o pode ser dividido por " + divisor);
				
		
		else if (denominator % divisor == 0) 
			return new Feedback(false, false, hint, "O numerador (" + numerator + ") n�o pode ser dividido por " + divisor);
		
		else
			return new Feedback(false, false, hint, "O numerador e o denominador (" + numerator + " e " + denominator + ") n�o podem ser divididos por " + divisor);
	}
}
