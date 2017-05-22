package ubiquitouscomputing.pat2math_app.controller;

import ubiquitouscomputing.pat2math_app.model.Hint;

public class HintBank {
	//As linhas representam os passos dos exerc�cios e as colunas os n�veis das dicas
	private static String[][] simpHints;
	
	public static void createHintBank() {
		simpHints = new String[1][3];
		simpHints[0][0] = "Lembre-se dos crit�rios de divisibilidade para escolher o pr�ximo n�mero que pode dividir o numerador e o denominador ao mesmo tempo";
		simpHints[0][1] = "Divida o numerador e o denominador pelo n�mero (N)";
		simpHints[0][2] = "O pr�ximo passo da resolu��o �: (P)";
	}
	
	public static Hint getHintSimplification(int step, int level, Fraction f) {
		String text = simpHints[step][level];
		
		if (text.indexOf("(N)") != 0 || text.indexOf("(P)") != 0) {
			if (text.indexOf("(N)") != -1) {
				String n = "" + f.getStepsSimplification().get(step).getDivisor();
				text = text.replaceAll("(N)", n);
			}
			
			else
				text = text.replaceAll("(P)", f.getStepsSimplification().get(step).toString());
		}
		
		return new Hint(text, level);
	}
}