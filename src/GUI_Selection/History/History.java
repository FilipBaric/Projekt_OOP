package GUI_Selection.History;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class History extends JFrame {

    JFileChooser jFileChooser;
    private HistoryPanelLeft left;
    private HistoryPanelRight right;
    private JMenuBar menuBar;

    public History(){

        super("History quiz");
        setSize(1000,800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout());
        initAll();
        layoutComps();
        activate();
        setJMenuBar(menuBar);

    }

    private void initAll(){
        menuBar = createMenuBar();
        left = new HistoryPanelLeft();
        right = new HistoryPanelRight();
    }
    private void layoutComps(){
        setLayout(new BorderLayout());
        add(left, BorderLayout.CENTER);
        add(right,BorderLayout.EAST);
    }


    private JMenuBar createMenuBar(){
        jFileChooser = new JFileChooser();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem save = new JMenuItem("Save score");
        JMenuItem quit = new JMenuItem("Exit");

        menuBar.add(menu);

        menu.add(save);
        menu.addSeparator();
        menu.add(quit);


        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(History.this,"Really want to exit?","Exit confirmation",JOptionPane.OK_CANCEL_OPTION);

                if(action == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jFileChooser.showSaveDialog(History.this) == JFileChooser.APPROVE_OPTION){
                    try{
                        File file = jFileChooser.getSelectedFile();
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        String content = getContentFromArea();
                        String cat = "History";
                        bw.append(cat);
                        bw.append(content);
                        bw.close();
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                    }
                }
            }
        });

        return menuBar;
    }
    private void activate(){
        left.setLeftPanelListener(new HistoryPanelListener() {
            @Override
            public void HistoryLeftPanelEventOccured(HistoryLeftPanelEvent gfpe) {
                int rightAnsw = gfpe.getRightAnswers();
                int finalScore = gfpe.getScore();
                right.setText2Area("\n  You guessed: " + rightAnsw + "/3 correct." + "\n  Your score is: " + finalScore);
            }
        });

    }
    public String getContentFromArea(){
        return right.getTextFromArea();
    }
}
