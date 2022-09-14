package GUI_Questions;

import java.util.ArrayList;
import java.util.Random;

public class GeoQuestions {
	
	/**
	 * Klasa koja se koriti kao mini Database za sva pitanja i odgovore za kategoriju geografije.
	 * 
	 * @author filip
	 * @since lipanj, 2020
	 */

    public ArrayList<String> answers = new ArrayList<>();
    public ArrayList<String> questions = new ArrayList<>();
    public ArrayList<String> cities = new ArrayList<>();
    public ArrayList<String> countries = new ArrayList<>();
    public ArrayList<String> scales = new ArrayList<>();
    public ArrayList<String> stuff = new ArrayList<>();


    public GeoQuestions(){
        questions();
        cityOptions();
        countryOption();
        scalesQuestion();
        volcanoOption();
        rightAnswer();
    }

    private void questions(){

        questions.add("What is the capital of Poland?");
        questions.add("Which major city is located on two continents?");
        questions.add("What is the second largest country in the world, by area?");
        questions.add("What is the second most populous country in the world?");
        questions.add("Machu Picchu can be found in which country?");
        questions.add("What are Krakatoa, Etna and Mauna Loa?");
        questions.add("Earthquakes are measured on what scale? ");
        questions.add("What is the world's northernmost capital city?");

    }

    private void cityOptions(){

        cities.add("Paris");
        cities.add("Washington");
        cities.add("Berlin");
        cities.add("Zagreb");
        cities.add("Zadar");
        cities.add("Moscow");
    }
    private void countryOption(){

        countries.add("Croatia");
        countries.add("Italy");
        countries.add("USA");
        countries.add("Russia");
        countries.add("Indonesia");
    }

    private void scalesQuestion(){

        scales.add("Celsius scale");
        scales.add("Fahrenheit scale");
        scales.add("Scoville scale");
        scales.add("Metric scale");
        scales.add("Imperial scale");
    }

    private void volcanoOption(){

        stuff.add("Mountains");
        stuff.add("Lakes");
        stuff.add("Caves");
        stuff.add("Clouds");
        stuff.add("Bombs");
    }

    private void rightAnswer(){

        answers.add("Warsaw");
        answers.add("Istanbul");
        answers.add("Canada");
        answers.add("India");
        answers.add("Peru");
        answers.add("Volcanos");
        answers.add("Richter scale");
        answers.add("Reykjavik");

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
