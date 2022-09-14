package GUI_Questions;

import java.util.ArrayList;
import java.util.Random;

public class ChemQuestions {
	
	/**
	 * Klasa koja se koriti kao mini Database za sva pitanja i odgovore za kategoriju kemije.
	 * 
	 * @author filip
	 * @since lipanj, 2020
	 */

    public ArrayList<String> questions = new ArrayList<>();
    public ArrayList<String> answers = new ArrayList<>();
    public ArrayList<String> elements = new ArrayList<>();
    public ArrayList<String> symbols = new ArrayList<>();

    public ChemQuestions(){

        addQuestions();
        addAnswers();
        addElements();
        symbols();

    }


    private void addQuestions(){

        questions.add("What is the first element on the periodic table?");
        questions.add("K is the chemical symbol for which element?");
        questions.add("What is H20 more commonly known as?");
        questions.add("What is the third most common gas found in the air we breathe?");
        questions.add("What is the chemical symbol for gold?");
        questions.add("What is the fourth most abundant element in the universe in terms of mass?");
        questions.add("What is the chemical symbol for iron?");
        questions.add("What is the chemical symbol for copper?");


    }
    private void addAnswers(){

        answers.add("Hydrogen");
        answers.add("Potassium");
        answers.add("Water");
        answers.add("Argon");
        answers.add("Au");
        answers.add("Carbon");
        answers.add("Fe");
        answers.add("Cu");

    }

    private void addElements(){

        elements.add("Oxygen");
        elements.add("Calcium");
        elements.add("Barium");
        elements.add("Plutonium");
        elements.add("Copper");
        elements.add("Sodium");

    }

    private void symbols(){

        symbols.add("He");
        symbols.add("Ta");
        symbols.add("Mg");
        symbols.add("Ar");
        symbols.add("O");


    }


    /**
     * Metoda koja uzima nasumice pitanja iz liste.
     * @return randomVal
     */

    public String randomQuestion(){
        Random generator = new Random();
        Object[] values  = questions.toArray();
        String randomVal = (String) values[generator.nextInt(values.length)];

        return randomVal;
    }
}