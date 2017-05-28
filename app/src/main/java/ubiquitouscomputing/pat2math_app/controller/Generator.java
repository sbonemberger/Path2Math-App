package ubiquitouscomputing.pat2math_app.controller;

import ubiquitouscomputing.pat2math_app.model.Exercise;

import java.util.LinkedList;

public class Generator {
	private static String[][] fractions = {{"5/10", "2/8", "4/6", "6/14", "15/20", "10/30", "4/16"},
										   {"10/30", "9/36", "50/100", "22/88", "4/10", "4/50", "60/90"},
										   {"25/75", "77/88", "55/245", "21/36", "64/56", "98/116", "222/828"},
										   {"144/156", "121/55", "55/245", "250/75", "63/119", "483/1932", "187/1870"},
										   {"832/117", "756/81", "216/72", "954/1260", "9999/99999", "2310/16170", "3315/62985"}};
	
	private static LinkedList<String>[] fractionsLists;
	
	//0 = Muito Fácil
	//1 = Fácil
	//2 = Médio
	//3 = Difícil
	//4 = Desafio
	
	public static void generateLists() {
		fractionsLists = (LinkedList<String>[]) new Object[5];
		
		for (int i = 0; i < fractionsLists.length; i++) {
			fractionsLists[i] = new LinkedList<String>();
			
			for (int j = 0; i < fractions[i].length; i++) 
				fractionsLists[i].add(fractions[i][j]);		
		}
	}
	
	public static void generateList(int difficultyLevel) {	
		for (int j = 0; j < fractions[difficultyLevel].length; j++) {
			//Inverte a fra��o para se tornar um exerc�cio diferente
			String[] temp = fractions[difficultyLevel][j].split("/");
			fractions[difficultyLevel][j] = temp[1] + "/" + temp[0];
			
			fractionsLists[difficultyLevel].add(fractions[difficultyLevel][j]);
		}
	}
	
	public static Exercise generateExercise(int difficultyLevel) {
		int maxPoints = 20;
		
		if (difficultyLevel == 1)
			maxPoints = 40;
		
		else if (difficultyLevel == 2)
			maxPoints = 60;
		
		else if (difficultyLevel == 3)
			maxPoints = 80;
		
		else
			maxPoints = 100;
		
		Fraction f;
		int sizeList = fractionsLists[difficultyLevel].size();
		
		//Neste momento, a lista atual ficar� vazia e dever� ser preenchida novamente
		if (sizeList == 1) {
			f = new Fraction(fractionsLists[difficultyLevel].removeFirst());
			generateList(difficultyLevel);
		}
		
		else {
			int pos = (int) Math.random() * sizeList;
			f = new Fraction(fractionsLists[difficultyLevel].remove(pos));
		}
		
		return new Exercise(f, maxPoints);
	}
}
