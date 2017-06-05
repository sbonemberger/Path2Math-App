package ubiquitouscomputing.pat2math_app.controller;

import ubiquitouscomputing.pat2math_app.model.Exercise;

import java.util.LinkedList;
import java.util.ArrayList;


public class Generator {
	private String[][] fractions = {{"5/10", "2/8", "4/6", "6/14", "15/20", "10/30", "4/16"},
										   {"10/30", "9/36", "50/100", "22/88", "4/10", "4/50", "60/90"},
										   {"25/75", "77/88", "55/245", "21/36", "64/56", "98/116", "222/828"},
										   {"144/156", "121/55", "55/245", "250/75", "63/119", "483/1932", "187/1870"},
										   {"832/117", "756/81", "216/72", "954/1260", "9999/99999", "2310/16170", "3315/62985"}};

    private ArrayList<LinkedList<String>> fractionsLists;
	
	//0 = Muito Fácil
	//1 = Fácil
	//2 = Médio
	//3 = Difícil
	//4 = Desafio
	
	public void generateLists() {
		//fractionsLists = (LinkedList<String>[]) new LinkedList<String>()[5];

        fractionsLists = new ArrayList<LinkedList<String>>();

        //for (int i = 0; i < fractionsLists.size(); i++) {
		for (int i = 0; i < 5; i++) {
			fractionsLists.add(i,new LinkedList<String>());
			
			for (int j = 0; j < fractions[i].length; j++)
				fractionsLists.get(i).add(fractions[i][j]);
		}
	}
	
	public void generateList(int difficultyLevel) {
		for (int j = 0; j < fractions[difficultyLevel].length; j++) {
			//Inverte a fra��o para se tornar um exerc�cio diferente
			String[] temp = fractions[difficultyLevel][j].split("/");
			fractions[difficultyLevel][j] = temp[1] + "/" + temp[0];
			
			fractionsLists.get(difficultyLevel).add(fractions[difficultyLevel][j]);
		}
	}
	
	public Exercise generateExercise(int difficultyLevel) {
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
		int sizeList = fractionsLists.get(difficultyLevel).size();
		
		//Neste momento, a lista atual ficar� vazia e dever� ser preenchida novamente
		if (sizeList <= 1) {
			f = new Fraction(fractionsLists.get(difficultyLevel).removeFirst());
			generateList(difficultyLevel);
		}
		
		else {
			int pos = (int) Math.random() * sizeList;
			f = new Fraction(fractionsLists.get(difficultyLevel).remove(pos));
		}
		
		return new Exercise(f, maxPoints);
	}
}
