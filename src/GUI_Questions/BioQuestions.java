package GUI_Questions;

import java.util.ArrayList;
import java.util.Random;

public class BioQuestions {
	
	/**
	 * Klasa koja se koriti kao mini Database za sva pitanja i odgovore za kategoriju biologije.
	 * 
	 * @author filip
	 * @since lipanj, 2020
	 */

    public ArrayList<String> answers = new ArrayList<>();
    public ArrayList<String> questions = new ArrayList<>();
    public ArrayList<String> THanimal = new ArrayList<>();
    public ArrayList<String> colours = new ArrayList<>();
    public ArrayList<String> bird = new ArrayList<>();
    public ArrayList<String> fastBoi = new ArrayList<>();
    public ArrayList<String> snakezOnAPlane = new ArrayList<>();
    public ArrayList<String> treeBeards = new ArrayList<>();

    public BioQuestions(){
        questions();
        answer();
        ThreeHeartsAnimals();
        colours();
        birds();
        TooFast4You();
        snakez();
        treeBeard();
    }
    private void questions(){

        questions.add("What animal has three hearts?");
        questions.add("What color is mollusk blood?");
        questions.add("What is the smallest bird?");
        questions.add("What is the fastest land animal?");
        questions.add("Which birds have scales on their wings?");
        questions.add("The largest snake on Earth is:");
        questions.add("The largest tree in the world is:");
        questions.add("The tallest trees in the world is:");
    }
    private void answer(){

        answers.add("Octopus");
        answers.add("Blue");
        answers.add("Colibri");
        answers.add("Cheetah");
        answers.add("Penguins");
        answers.add("Anaconda");
        answers.add("Sequoia");
        answers.add("Eucalyptus");

    }
    private void ThreeHeartsAnimals(){

        THanimal.add("Cuttlefish");
        THanimal.add("Komodo Dragon");
        THanimal.add("Puffer fish");
        THanimal.add("Sea Urchin");
        THanimal.add("Aligator");

    }
    private void colours(){

        colours.add("Pink");
        colours.add("Purple");
        colours.add("Red");
        colours.add("Orange");
        colours.add("Transparent");

    }
    private void birds(){

        bird.add("Swallow");
        bird.add("Blackbird");
        bird.add("Parrot");
        bird.add("Ostrich");
        bird.add("Turkey");
        bird.add("Chicken");

    }
    private void TooFast4You(){

        fastBoi.add("Tiger");
        fastBoi.add("Lion");
        fastBoi.add("Zebra");
        fastBoi.add("Antelope");
        fastBoi.add("Dessert fox");

    }
    private void snakez(){

        snakezOnAPlane.add("Boa Constrictor");
        snakezOnAPlane.add("Cobra");
        snakezOnAPlane.add("Viper");
        snakezOnAPlane.add("Python");

    }
    private void treeBeard(){

        treeBeards.add("Oak");
        treeBeards.add("Beech");
        treeBeards.add("Pine");
        treeBeards.add("Kapok");

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