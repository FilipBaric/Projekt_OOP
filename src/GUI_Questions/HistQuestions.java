package GUI_Questions;

import java.util.ArrayList;
import java.util.Random;

public class HistQuestions{
	
	/**
	 * Klasa koja se koriti kao mini Database za sva pitanja i odgovore za kategoriju povijesti.
	 * 
	 * @author filip
	 * @since lipanj, 2020
	 */

    public ArrayList<String> questions = new ArrayList<>();
    public ArrayList<String> answers = new ArrayList<>();
    public ArrayList<String> year = new ArrayList<>();
    public ArrayList<String> space = new ArrayList<>();
    public ArrayList<String> euroMan = new ArrayList<>();
    public ArrayList<String> spanishInquisition = new ArrayList<>();
    public ArrayList<String> ships = new ArrayList<>();

    public HistQuestions(){

        questions();
        answers();
        years();
        spaceMan();
        nobodyExpectsThe();
        europeanMan();
        titanic();

    }

    private void questions(){

        questions.add("What year was America discovered?");
        questions.add("What year did WW1 start?");
        questions.add("Who was the first person to travel to outer space?");
        questions.add("What was the name of the ship that collided with an iceberg in the Atlantic ocean?");
        questions.add("Which spanish leader started the spanish inquisition?");
        questions.add("When did the first crusade start?");
        questions.add("Who was Charlemagne?");
        questions.add("When did America get its independence?");

    }

    private void answers(){

        answers.add("1492");
        answers.add("1914");
        answers.add("Yuri Gagarin");
        answers.add("Titanic");
        answers.add("Isabella I of Castille");
        answers.add("1091");
        answers.add("A european Emperor");
        answers.add("1776");

    }

    private void years(){

        year.add("1991");
        year.add("1147");
        year.add("1939");
        year.add("1453");
        year.add("111");
        year.add("1247");

    }

    private void spaceMan(){

        space.add("Neil Armstrong");
        space.add("Buzz Aldrin");
        space.add("Laika");
        space.add("Michael Collins");

    }

    private void europeanMan(){

        euroMan.add("A trader");
        euroMan.add("A french king");
        euroMan.add("Some vagabond");
        euroMan.add("The pope");

    }

    private void nobodyExpectsThe(){

        spanishInquisition.add("Ferdinand V of Castille");
        spanishInquisition.add("Joanna of Castille");
        spanishInquisition.add("Philip I of Castille");
        spanishInquisition.add("John II of Aragorn");

    }

    private void titanic(){

        ships.add("Queen Anne's Revenge");
        ships.add("HMS Hood");
        ships.add("USS Enterprise");
        ships.add("Richelieu");

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