package ubiquitouscomputing.pat2math_app.controller;

import ubiquitouscomputing.pat2math_app.model.Exercise;

public class Teste {

	public static void main(String[] args) {
		Fraction f = new Fraction(50, 100);
		Exercise e = new Exercise(f, 20);
		HintBank.createHintBank();
		
		System.out.println(e.answer(10, 5, 10));
		System.out.println("");
		System.out.println(e);
	}

}
