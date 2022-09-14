package GUI_Selection.History;

import java.util.EventObject;

public class HistoryLeftPanelEvent extends EventObject {

    private int score;
    private int rightAnswers;

    public HistoryLeftPanelEvent(Object source){
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
