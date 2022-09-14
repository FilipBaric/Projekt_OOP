package GUI_Selection.Geography;

import GUI_Questions.GeoQuestions;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GeographyPanelLeft extends JPanel {

    private GeoPanelListener listener;

    TreeSet<String> QandA1 = new TreeSet<>();
    ArrayList<String> Q1 = new ArrayList<>();
    TreeSet<String> QandA2 = new TreeSet<>();
    ArrayList<String> Q2 = new ArrayList<>();
    TreeSet<String> QandA3 = new TreeSet<>();
    ArrayList<String> Q3 = new ArrayList<>();

    private int rightAnswers;
    private int score;

    private String questionText1;
    private String questionText2;
    private String questionText3;

    private ButtonGroup q1;
    private ButtonGroup q2;
    private ButtonGroup q3;

    private JTextArea question1;
    private JTextArea question2;
    private JTextArea question3;

    private JRadioButton answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer12;

    private JButton submit;

    public GeographyPanelLeft() {
        createComps();
        setBorders();
        activateAll();
        layoutComps();
        addQuestionsToAreas();
        addAnswersToQuestions();

    }

    private void createComps() {
        submit = new JButton("Submit");

        answer1 = new JRadioButton();
        answer2 = new JRadioButton();
        answer3 = new JRadioButton();
        answer4 = new JRadioButton();
        answer5 = new JRadioButton();
        answer6 = new JRadioButton();
        answer7 = new JRadioButton();
        answer8 = new JRadioButton();
        answer9 = new JRadioButton();
        answer10 = new JRadioButton();
        answer11 = new JRadioButton();
        answer12 = new JRadioButton();

        q1 = new ButtonGroup();
        q1.add(answer1);
        q1.add(answer2);
        q1.add(answer3);
        q1.add(answer4);

        q2 = new ButtonGroup();
        q2.add(answer5);
        q2.add(answer6);
        q2.add(answer7);
        q2.add(answer8);

        q3 = new ButtonGroup();
        q3.add(answer9);
        q3.add(answer10);
        q3.add(answer11);
        q3.add(answer12);

        question1 = new JTextArea();
        question2 = new JTextArea();
        question3 = new JTextArea();

        question1.setEditable(false);
        question2.setEditable(false);
        question3.setEditable(false);

        question1.setLineWrap(true);
        question1.setWrapStyleWord(true);

        question2.setLineWrap(true);
        question2.setWrapStyleWord(true);

        question3.setLineWrap(true);
        question3.setWrapStyleWord(true);

        question1.setPreferredSize(new Dimension(500, 50));
        question2.setPreferredSize(new Dimension(500, 50));
        question3.setPreferredSize(new Dimension(500, 50));

    }

    private void layoutComps() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        //question 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 1.5;
        add(question1, gbc);

        //answer 1 for question 1
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 4;
        add(answer1, gbc);

        //answer 2 for question 1
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(answer2, gbc);

        //answer 3 for question 1
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 2;
        add(answer3, gbc);

        //answer 4 for question 1
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(answer4, gbc);

        //question 2
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(question2, gbc);

        //answer 1 for question 2
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 4;
        add(answer5, gbc);

        //answer 2 for question 2
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(answer6, gbc);

        //answer 3 for question 2
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 3;
        add(answer7, gbc);

        //answer 4 for question 2
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(answer8, gbc);

        //question 3
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 2;
        add(question3, gbc);

        //answer 1 for question 3
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 4;
        add(answer9, gbc);

        //answer 2 for question 3
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(answer10, gbc);

        //answer 3 for question 3
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 4;
        add(answer11, gbc);

        //answer 4 for question 3
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(answer12, gbc);

        //submit button
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        add(submit, gbc);

    }

    private void setBorders() {
        Border inner = BorderFactory.createTitledBorder("Questions");
        Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outer, inner));
    }

    private void activateAll() {

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswers();
                GeoLeftPanelEvent gpe = new GeoLeftPanelEvent(this);
                gpe.setScore(score);
                gpe.setRightAnswers(rightAnswers);
                submit.setVisible(false);
                if(listener != null){
                    listener.GeoLeftPanelEventOccured(gpe);
                }
            }
        });
    }

    public void setLeftPanelListener(GeoPanelListener lst){
        this.listener = lst;
    }

    /**
     * Metoda koja stavlja prikladan odgovor uz prikladno pitanje.
     */

    public void addAnswersToQuestions() {
        GeoQuestions gc = new GeoQuestions();

        boolean i = true;
        boolean j = true;
        boolean k = true;


        //ANSWERS FOR QUESTION 1
        if (questionText1.equals(gc.questions.get(0))) {
            while (i) {
                QandA1.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA1.size() == 3) {
                    i = false;
                }
            }
            QandA1.add(gc.answers.get(0));
            Q1.addAll(QandA1);
            Collections.shuffle(Q1);
            answer1.setText(Q1.get(0));
            answer2.setText(Q1.get(1));
            answer3.setText(Q1.get(2));
            answer4.setText(Q1.get(3));
            QandA1.clear();

        } else if (questionText1.equals(gc.questions.get(1))) {
            while (i) {
                QandA1.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA1.size() == 3) {
                    i = false;
                }
            }
            QandA1.add(gc.answers.get(1));
            Q1.addAll(QandA1);
            Collections.shuffle(Q1);
            answer1.setText(Q1.get(0));
            answer2.setText(Q1.get(1));
            answer3.setText(Q1.get(2));
            answer4.setText(Q1.get(3));
            QandA1.clear();

        } else if (questionText1.equals(gc.questions.get(2))) {
            while (i) {
                QandA1.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA1.size() == 3) {
                    i = false;
                }
            }
            QandA1.add(gc.answers.get(2));
            Q1.addAll(QandA1);
            Collections.shuffle(Q1);
            answer1.setText(Q1.get(0));
            answer2.setText(Q1.get(1));
            answer3.setText(Q1.get(2));
            answer4.setText(Q1.get(3));
            QandA1.clear();

        } else if (questionText1.equals(gc.questions.get(3))) {
            while (i) {
                QandA1.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA1.size() == 3) {
                    i = false;
                }
            }
            QandA1.add(gc.answers.get(3));
            Q1.addAll(QandA1);
            Collections.shuffle(Q1);
            answer1.setText(Q1.get(0));
            answer2.setText(Q1.get(1));
            answer3.setText(Q1.get(2));
            answer4.setText(Q1.get(3));
            QandA1.clear();

        } else if (questionText1.equals(gc.questions.get(4))) {
            while (i) {
                QandA1.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA1.size() == 3) {
                    i = false;
                }
            }
            QandA1.add(gc.answers.get(4));
            Q1.addAll(QandA1);
            Collections.shuffle(Q1);
            answer1.setText(Q1.get(0));
            answer2.setText(Q1.get(1));
            answer3.setText(Q1.get(2));
            answer4.setText(Q1.get(3));
            QandA1.clear();

        } else if (questionText1.equals(gc.questions.get(5))) {
            while (i) {
                QandA1.add(gc.stuff.get(ThreadLocalRandom.current().nextInt(0, gc.stuff.size())));
                if (QandA1.size() == 3) {
                    i = false;
                }
            }
            QandA1.add(gc.answers.get(5));
            Q1.addAll(QandA1);
            Collections.shuffle(Q1);
            answer1.setText(Q1.get(0));
            answer2.setText(Q1.get(1));
            answer3.setText(Q1.get(2));
            answer4.setText(Q1.get(3));
            QandA1.clear();

        } else if (questionText1.equals(gc.questions.get(6))) {
            while (i) {
                QandA1.add(gc.scales.get(ThreadLocalRandom.current().nextInt(0, gc.scales.size())));
                if (QandA1.size() == 3) {
                    i = false;
                }
            }
            QandA1.add(gc.answers.get(6));
            Q1.addAll(QandA1);
            Collections.shuffle(Q1);
            answer1.setText(Q1.get(0));
            answer2.setText(Q1.get(1));
            answer3.setText(Q1.get(2));
            answer4.setText(Q1.get(3));
            QandA1.clear();

        } else if (questionText1.equals(gc.questions.get(7))) {
            while (i) {
                QandA1.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA1.size() == 3) {
                    i = false;
                }
            }
            QandA1.add(gc.answers.get(7));
            Q1.addAll(QandA1);
            Collections.shuffle(Q1);
            answer1.setText(Q1.get(0));
            answer2.setText(Q1.get(1));
            answer3.setText(Q1.get(2));
            answer4.setText(Q1.get(3));
            QandA1.clear();

        }


        //ANSWERS FOR QUESTION 2
        if (questionText2.equals(gc.questions.get(0))) {
            while (j) {
                QandA2.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA2.size() == 3) {
                    j = false;
                }
            }
            QandA2.add(gc.answers.get(0));
            Q2.addAll(QandA2);
            Collections.shuffle(Q2);
            answer5.setText(Q2.get(0));
            answer6.setText(Q2.get(1));
            answer7.setText(Q2.get(2));
            answer8.setText(Q2.get(3));
            QandA2.clear();

        } else if (questionText2.equals(gc.questions.get(1))) {
            while (j) {
                QandA2.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA2.size() == 3) {
                    j = false;
                }
            }
            QandA2.add(gc.answers.get(1));
            Q2.addAll(QandA2);
            Collections.shuffle(Q2);
            answer5.setText(Q2.get(0));
            answer6.setText(Q2.get(1));
            answer7.setText(Q2.get(2));
            answer8.setText(Q2.get(3));
            QandA2.clear();

        } else if (questionText2.equals(gc.questions.get(2))) {
            while (j) {
                QandA2.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA2.size() == 3) {
                    j = false;
                }
            }
            QandA2.add(gc.answers.get(2));
            Q2.addAll(QandA2);
            Collections.shuffle(Q2);
            answer5.setText(Q2.get(0));
            answer6.setText(Q2.get(1));
            answer7.setText(Q2.get(2));
            answer8.setText(Q2.get(3));
            QandA2.clear();

        } else if (questionText2.equals(gc.questions.get(3))) {
            while (j) {
                QandA2.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA2.size() == 3) {
                    j = false;
                }
            }
            QandA2.add(gc.answers.get(3));
            Q2.addAll(QandA2);
            Collections.shuffle(Q2);
            answer5.setText(Q2.get(0));
            answer6.setText(Q2.get(1));
            answer7.setText(Q2.get(2));
            answer8.setText(Q2.get(3));
            QandA2.clear();

        } else if (questionText2.equals(gc.questions.get(4))) {
            while (j) {
                QandA2.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA2.size() == 3) {
                    j = false;
                }
            }
            QandA2.add(gc.answers.get(4));
            Q2.addAll(QandA2);
            Collections.shuffle(Q2);
            answer5.setText(Q2.get(0));
            answer6.setText(Q2.get(1));
            answer7.setText(Q2.get(2));
            answer8.setText(Q2.get(3));
            QandA2.clear();

        } else if (questionText2.equals(gc.questions.get(5))) {
            while (j) {
                QandA2.add(gc.stuff.get(ThreadLocalRandom.current().nextInt(0, gc.stuff.size())));
                if (QandA2.size() == 3) {
                    j = false;
                }
            }
            QandA2.add(gc.answers.get(5));
            Q2.addAll(QandA2);
            Collections.shuffle(Q2);
            answer5.setText(Q2.get(0));
            answer6.setText(Q2.get(1));
            answer7.setText(Q2.get(2));
            answer8.setText(Q2.get(3));
            QandA2.clear();

        } else if (questionText2.equals(gc.questions.get(6))) {
            while (j) {
                QandA2.add(gc.scales.get(ThreadLocalRandom.current().nextInt(0, gc.scales.size())));
                if (QandA2.size() == 3) {
                    j = false;
                }
            }
            QandA2.add(gc.answers.get(6));
            Q2.addAll(QandA2);
            Collections.shuffle(Q2);
            answer5.setText(Q2.get(0));
            answer6.setText(Q2.get(1));
            answer7.setText(Q2.get(2));
            answer8.setText(Q2.get(3));
            QandA2.clear();

        } else if (questionText2.equals(gc.questions.get(7))) {
            while (j) {
                QandA2.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA2.size() == 3) {
                    j = false;
                }
            }
            QandA2.add(gc.answers.get(7));
            Q2.addAll(QandA2);
            Collections.shuffle(Q2);
            answer5.setText(Q2.get(0));
            answer6.setText(Q2.get(1));
            answer7.setText(Q2.get(2));
            answer8.setText(Q2.get(3));
            QandA2.clear();

        }


        //ANSWERS FOR QUESTION 3
        if (questionText3.equals(gc.questions.get(0))) {
            while (k) {
                QandA3.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA3.size() == 3) {
                    k = false;
                }
            }
            QandA3.add(gc.answers.get(0));
            Q3.addAll(QandA3);
            Collections.shuffle(Q3);
            answer9.setText(Q3.get(0));
            answer10.setText(Q3.get(1));
            answer11.setText(Q3.get(2));
            answer12.setText(Q3.get(3));
            QandA3.clear();

        } else if (questionText3.equals(gc.questions.get(1))) {
            while (k) {
                QandA3.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA3.size() == 3) {
                    k = false;
                }
            }
            QandA3.add(gc.answers.get(1));
            Q3.addAll(QandA3);
            Collections.shuffle(Q3);
            answer9.setText(Q3.get(0));
            answer10.setText(Q3.get(1));
            answer11.setText(Q3.get(2));
            answer12.setText(Q3.get(3));
            QandA3.clear();

        } else if (questionText3.equals(gc.questions.get(2))) {
            while (k) {
                QandA3.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA3.size() == 3) {
                    k = false;
                }
            }
            QandA3.add(gc.answers.get(2));
            Q3.addAll(QandA3);
            Collections.shuffle(Q3);
            answer9.setText(Q3.get(0));
            answer10.setText(Q3.get(1));
            answer11.setText(Q3.get(2));
            answer12.setText(Q3.get(3));
            QandA3.clear();

        } else if (questionText3.equals(gc.questions.get(3))) {
            while (k) {
                QandA3.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA3.size() == 3) {
                    k = false;
                }
            }
            QandA3.add(gc.answers.get(3));
            Q3.addAll(QandA3);
            Collections.shuffle(Q3);
            answer9.setText(Q3.get(0));
            answer10.setText(Q3.get(1));
            answer11.setText(Q3.get(2));
            answer12.setText(Q3.get(3));
            QandA3.clear();

        } else if (questionText3.equals(gc.questions.get(4))) {
            while (k) {
                QandA3.add(gc.countries.get(ThreadLocalRandom.current().nextInt(0, gc.countries.size())));
                if (QandA3.size() == 3) {
                    k = false;
                }
            }
            QandA3.add(gc.answers.get(4));
            Q3.addAll(QandA3);
            Collections.shuffle(Q3);
            answer9.setText(Q3.get(0));
            answer10.setText(Q3.get(1));
            answer11.setText(Q3.get(2));
            answer12.setText(Q3.get(3));
            QandA3.clear();

        } else if (questionText3.equals(gc.questions.get(5))) {
            while (k) {
                QandA3.add(gc.stuff.get(ThreadLocalRandom.current().nextInt(0, gc.stuff.size())));
                if (QandA3.size() == 3) {
                    k = false;
                }
            }
            QandA3.add(gc.answers.get(5));
            Q3.addAll(QandA3);
            Collections.shuffle(Q2);
            answer9.setText(Q3.get(0));
            answer10.setText(Q3.get(1));
            answer11.setText(Q3.get(2));
            answer12.setText(Q3.get(3));
            QandA3.clear();

        } else if (questionText3.equals(gc.questions.get(6))) {
            while (k) {
                QandA3.add(gc.scales.get(ThreadLocalRandom.current().nextInt(0, gc.scales.size())));
                if (QandA3.size() == 3) {
                    k = false;
                }
            }
            QandA3.add(gc.answers.get(6));
            Q3.addAll(QandA3);
            Collections.shuffle(Q3);
            answer9.setText(Q3.get(0));
            answer10.setText(Q3.get(1));
            answer11.setText(Q3.get(2));
            answer12.setText(Q3.get(3));
            QandA3.clear();

        } else if (questionText3.equals(gc.questions.get(7))) {
            while (k) {
                QandA3.add(gc.cities.get(ThreadLocalRandom.current().nextInt(0, gc.cities.size())));
                if (QandA3.size() == 3) {
                    k = false;
                }
            }
            QandA3.add(gc.answers.get(7));
            Q3.addAll(QandA3);
            Collections.shuffle(Q3);
            answer9.setText(Q3.get(0));
            answer10.setText(Q3.get(1));
            answer11.setText(Q3.get(2));
            answer12.setText(Q3.get(3));
            QandA3.clear();

        }
    }

    /**
     * Metoda koja dodaje pitanja u text area i provjerava jesu li ista te ih zamijeni ako jesu.
     */

    public void addQuestionsToAreas() {
        GeoQuestions gq = new GeoQuestions();

        questionText1 = gq.randomQuestion();

        questionText2 = gq.randomQuestion();

        questionText3 = gq.randomQuestion();

        boolean var = true;

        while (var) {
            if (questionText1.equals(questionText2)) {
                questionText1 = gq.randomQuestion();
            } else if (questionText1.equals(questionText3)) {
                questionText1 = gq.randomQuestion();
            } else if (questionText2.equals(questionText3)) {
                questionText2 = gq.randomQuestion();
            } else {
                question1.append(questionText1);
                question2.append(questionText2);
                question3.append(questionText3);
                var = false;
            }
        }
    }

    /**
     * Metoda koja provjerava odgovore.
     * 
     */

    public void checkAnswers() {
        GeoQuestions gc = new GeoQuestions();

        //QUESTION 1 CHECK

        if (questionText1.equals(gc.questions.get(0))) {
            if (answer1.getText().equals(gc.answers.get(0))) {
                if (answer1.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer2.getText().equals(gc.answers.get(0))) {
                if (answer2.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer3.getText().equals(gc.answers.get(0))) {
                if (answer3.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer4.getText().equals(gc.answers.get(0))) {
                if (answer4.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText1.equals(gc.questions.get(1))) {
            if (answer1.getText().equals(gc.answers.get(1))) {
                if (answer1.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer2.getText().equals(gc.answers.get(1))) {
                if (answer2.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer3.getText().equals(gc.answers.get(1))) {
                if (answer3.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer4.getText().equals(gc.answers.get(1))) {
                if (answer4.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText1.equals(gc.questions.get(2))) {
            if (answer1.getText().equals(gc.answers.get(2))) {
                if (answer1.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer2.getText().equals(gc.answers.get(2))) {
                if (answer2.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer3.getText().equals(gc.answers.get(2))) {
                if (answer3.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer4.getText().equals(gc.answers.get(2))) {
                if (answer4.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText1.equals(gc.questions.get(3))) {
            if (answer1.getText().equals(gc.answers.get(3))) {
                if (answer1.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer2.getText().equals(gc.answers.get(3))) {
                if (answer2.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer3.getText().equals(gc.answers.get(3))) {
                if (answer3.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer4.getText().equals(gc.answers.get(3))) {
                if (answer4.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText1.equals(gc.questions.get(4))) {
            if (answer1.getText().equals(gc.answers.get(4))) {
                if (answer1.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer2.getText().equals(gc.answers.get(4))) {
                if (answer2.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer3.getText().equals(gc.answers.get(4))) {
                if (answer3.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer4.getText().equals(gc.answers.get(4))) {
                if (answer4.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText1.equals(gc.questions.get(5))) {
            if (answer1.getText().equals(gc.answers.get(5))) {
                if (answer1.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer2.getText().equals(gc.answers.get(5))) {
                if (answer2.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer3.getText().equals(gc.answers.get(5))) {
                if (answer3.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer4.getText().equals(gc.answers.get(5))) {
                if (answer4.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText1.equals(gc.questions.get(6))) {
            if (answer1.getText().equals(gc.answers.get(6))) {
                if (answer1.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer2.getText().equals(gc.answers.get(6))) {
                if (answer2.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer3.getText().equals(gc.answers.get(6))) {
                if (answer3.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer4.getText().equals(gc.answers.get(6))) {
                if (answer4.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText1.equals(gc.questions.get(7))) {
            if (answer1.getText().equals(gc.answers.get(7))) {
                if (answer1.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer2.getText().equals(gc.answers.get(7))) {
                if (answer2.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer3.getText().equals(gc.answers.get(7))) {
                if (answer3.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer4.getText().equals(gc.answers.get(7))) {
                if (answer4.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }

        //QUESTION 2 CHECK

        if (questionText2.equals(gc.questions.get(0))) {
            if (answer5.getText().equals(gc.answers.get(0))) {
                if (answer5.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer6.getText().equals(gc.answers.get(0))) {
                if (answer6.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer7.getText().equals(gc.answers.get(0))) {
                if (answer7.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer8.getText().equals(gc.answers.get(0))) {
                if (answer8.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText2.equals(gc.questions.get(1))) {
            if (answer5.getText().equals(gc.answers.get(1))) {
                if (answer5.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer6.getText().equals(gc.answers.get(1))) {
                if (answer6.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer7.getText().equals(gc.answers.get(1))) {
                if (answer7.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer8.getText().equals(gc.answers.get(1))) {
                if (answer8.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText2.equals(gc.questions.get(2))) {
            if (answer5.getText().equals(gc.answers.get(2))) {
                if (answer5.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer6.getText().equals(gc.answers.get(2))) {
                if (answer6.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer7.getText().equals(gc.answers.get(2))) {
                if (answer7.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer8.getText().equals(gc.answers.get(2))) {
                if (answer8.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText2.equals(gc.questions.get(3))) {
            if (answer5.getText().equals(gc.answers.get(3))) {
                if (answer5.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer6.getText().equals(gc.answers.get(3))) {
                if (answer6.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer7.getText().equals(gc.answers.get(3))) {
                if (answer7.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer8.getText().equals(gc.answers.get(3))) {
                if (answer8.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText2.equals(gc.questions.get(4))) {
            if (answer5.getText().equals(gc.answers.get(4))) {
                if (answer5.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer6.getText().equals(gc.answers.get(4))) {
                if (answer6.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer7.getText().equals(gc.answers.get(4))) {
                if (answer7.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer8.getText().equals(gc.answers.get(4))) {
                if (answer8.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText2.equals(gc.questions.get(5))) {
            if (answer5.getText().equals(gc.answers.get(5))) {
                if (answer5.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer6.getText().equals(gc.answers.get(5))) {
                if (answer6.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer7.getText().equals(gc.answers.get(5))) {
                if (answer7.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer8.getText().equals(gc.answers.get(5))) {
                if (answer8.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText2.equals(gc.questions.get(6))) {
            if (answer5.getText().equals(gc.answers.get(6))) {
                if (answer5.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer6.getText().equals(gc.answers.get(6))) {
                if (answer6.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer7.getText().equals(gc.answers.get(6))) {
                if (answer7.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer8.getText().equals(gc.answers.get(6))) {
                if (answer8.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText2.equals(gc.questions.get(7))) {
            if (answer5.getText().equals(gc.answers.get(7))) {
                if (answer5.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer6.getText().equals(gc.answers.get(7))) {
                if (answer6.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer7.getText().equals(gc.answers.get(7))) {
                if (answer7.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer8.getText().equals(gc.answers.get(7))) {
                if (answer8.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }

        //QUESTION 3 CHECK

        if (questionText3.equals(gc.questions.get(0))) {
            if (answer9.getText().equals(gc.answers.get(0))) {
                if (answer9.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer10.getText().equals(gc.answers.get(0))) {
                if (answer10.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer11.getText().equals(gc.answers.get(0))) {
                if (answer11.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer12.getText().equals(gc.answers.get(0))) {
                if (answer12.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText3.equals(gc.questions.get(1))) {
            if (answer9.getText().equals(gc.answers.get(1))) {
                if (answer9.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer10.getText().equals(gc.answers.get(1))) {
                if (answer10.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer11.getText().equals(gc.answers.get(1))) {
                if (answer11.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer12.getText().equals(gc.answers.get(1))) {
                if (answer12.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText3.equals(gc.questions.get(2))) {
            if (answer9.getText().equals(gc.answers.get(2))) {
                if (answer9.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer10.getText().equals(gc.answers.get(2))) {
                if (answer10.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer11.getText().equals(gc.answers.get(2))) {
                if (answer11.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer12.getText().equals(gc.answers.get(2))) {
                if (answer12.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }if (questionText3.equals(gc.questions.get(3))) {
            if (answer9.getText().equals(gc.answers.get(3))) {
                if (answer9.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer10.getText().equals(gc.answers.get(3))) {
                if (answer10.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer11.getText().equals(gc.answers.get(3))) {
                if (answer11.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer12.getText().equals(gc.answers.get(3))) {
                if (answer12.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText3.equals(gc.questions.get(4))) {
            if (answer9.getText().equals(gc.answers.get(4))) {
                if (answer9.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer10.getText().equals(gc.answers.get(4))) {
                if (answer10.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer11.getText().equals(gc.answers.get(4))) {
                if (answer11.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer12.getText().equals(gc.answers.get(4))) {
                if (answer12.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText3.equals(gc.questions.get(5))) {
            if (answer9.getText().equals(gc.answers.get(5))) {
                if (answer9.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer10.getText().equals(gc.answers.get(5))) {
                if (answer10.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer11.getText().equals(gc.answers.get(5))) {
                if (answer11.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer12.getText().equals(gc.answers.get(5))) {
                if (answer12.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText3.equals(gc.questions.get(6))) {
            if (answer9.getText().equals(gc.answers.get(6))) {
                if (answer9.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer10.getText().equals(gc.answers.get(6))) {
                if (answer10.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer11.getText().equals(gc.answers.get(6))) {
                if (answer11.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer12.getText().equals(gc.answers.get(6))) {
                if (answer12.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
        if (questionText3.equals(gc.questions.get(7))) {
            if (answer9.getText().equals(gc.answers.get(7))) {
                if (answer9.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer10.getText().equals(gc.answers.get(7))) {
                if (answer10.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer11.getText().equals(gc.answers.get(7))) {
                if (answer11.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            } else if (answer12.getText().equals(gc.answers.get(7))) {
                if (answer12.isSelected()) {
                    rightAnswers++;
                    score = score + 10;
                }
            }
        }
    }
}