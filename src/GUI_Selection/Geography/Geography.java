package GUI_Selection.Geography;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Geography extends JFrame {

    JFileChooser jFileChooser;
    private GeographyPanelLeft left;
    private GeographyPanelRight right;
    private JMenuBar menuBar;

    public Geography(){

        super("Geography quiz");
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
        left = new GeographyPanelLeft();
        right = new GeographyPanelRight();
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
                int action = JOptionPane.showConfirmDialog(Geography.this,"Really want to exit?","Exit confirmation",JOptionPane.OK_CANCEL_OPTION);

                if(action == JOptionPane.OK_OPTION){
                   System.exit(0);
               }
             }
         });

            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(jFileChooser.showSaveDialog(Geography.this) == JFileChooser.APPROVE_OPTION){
                        try{
                            File file = jFileChooser.getSelectedFile();
                            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                            String content = getContentFromArea();
                            String cat = "Geography";
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
        left.setLeftPanelListener(new GeoPanelListener() {
            @Override
            public void GeoLeftPanelEventOccured(GeoLeftPanelEvent gfpe) {
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
