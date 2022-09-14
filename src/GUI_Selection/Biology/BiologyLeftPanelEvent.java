package GUI_Selection.Biology;

import java.util.EventObject;

public class BiologyLeftPanelEvent extends EventObject {
	
	/**
	 * Klasa koja se koristi za cuvanje rezultata i score-a.
	 * 
	 * @author filip
	 * @since lipanj, 2020
	 */

    private int score;
    private int rightAnswers;

    public BiologyLeftPanelEvent(Object source){
        super(source);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
}
