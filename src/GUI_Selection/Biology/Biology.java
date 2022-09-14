package GUI_Selection.Biology;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Biology extends JFrame {

    JFileChooser jFileChooser;
    private BiologyPanelLeft left;
    private BiologyPanelRight right;
    private JMenuBar menuBar;

    public Biology(){

        super("Biology quiz");
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
        left = new BiologyPanelLeft();
        right = new BiologyPanelRight();
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
                int action = JOptionPane.showConfirmDialog(Biology.this,"Really want to exit?","Exit confirmation",JOptionPane.OK_CANCEL_OPTION);

                if(action == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jFileChooser.showSaveDialog(Biology.this) == JFileChooser.APPROVE_OPTION){
                    try{
                        File file = jFileChooser.getSelectedFile();
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        String content = getContentFromArea();
                        String category = "Biology";
                        bw.append(category);
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
        left.setLeftPanelListener(new BiologyPanelListener() {
            @Override
            public void BioLeftPanelEventOccured(BiologyLeftPanelEvent bfpe) {
                int rightAnsw = bfpe.getRightAnswers();
                int finalScore = bfpe.getScore();
                right.setText2Area("\n  You guessed: " + rightAnsw + "/3 correct." + "\n  Your score is: " + finalScore);
            }
        });

    }
    public String getContentFromArea(){
        return right.getTextFromArea();
    }
}
