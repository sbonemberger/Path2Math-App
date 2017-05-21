package ubiquitouscomputing.pat2math_app;

public class Generator {
	private static String[][] fractions = {{"5/10", "2/8", "4/6", "6/14", "15/20"},
										   {"10/30", "9/36", "50/100", "22/88", "4/10"},
										   {"25/75", "77/88", "55/245", "21/36", "64/56"},
										   {"144/156", "121/55", "55/245", "250/75", "63/119"},
										   {"832/117", "756/81", "216/72", "954/1260", "9999/99999"}};
	//0 = Muito F�cil
	//1 = F�cil
	//2 = M�dio
	//3 = Dif�cil
	//4 = Desafio
	public static Exercise generateExercise(int difficultyLevel) {
		int pos = (int) Math.random() * fractions[difficultyLevel].length;
		int maxPoints = 20;
		
		if (difficultyLevel == 1)
			maxPoints = 40;
		
		else if (difficultyLevel == 2)
			maxPoints = 60;
		
		else if (difficultyLevel == 3)
			maxPoints = 80;
		
		else
			maxPoints = 100;
		
		Fraction f = new Fraction(fractions[difficultyLevel][pos]);
		
		return new Exercise(f, maxPoints);
	}
}
