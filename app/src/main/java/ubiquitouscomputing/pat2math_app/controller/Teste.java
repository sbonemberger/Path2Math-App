package ubiquitouscomputing.pat2math_app.controller;

import ubiquitouscomputing.pat2math_app.model.Exercise;
import ubiquitouscomputing.pat2math_app.controller.Generator;

public class Teste {

	public static void main(String[] args) {

		Generator gen = new Generator();
		gen.generateLists();

		Exercise ex = gen.generateExercise(0);
		HintBank.createHintBank();

		ex.answer(5,10);

		System.out.println(ex.toString());

		//Fraction f = new Fraction(50, 100);
		//Exercise e = new Exercise(f, 20);
		//HintBank.createHintBank();
		
		//System.out.println(e.answer(10, 5));
		//System.out.println("");
		//System.out.println(e);
	}

}
