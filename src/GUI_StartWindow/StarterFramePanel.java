package GUI_StartWindow;

import GUI_Selection.Biology.Biology;
import GUI_Selection.Chemistry.Chemistry;
import GUI_Selection.Geography.Geography;
import GUI_Selection.History.History;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarterFramePanel extends JPanel {

    private JComboBox<String> comboCat;
    private JButton start;

    public StarterFramePanel(){
        setLayout(new BorderLayout());
        setBorders();
        createComps();
        layoutComps();
        activateAll();

    }
    private void setBorders(){
        Border inner = BorderFactory.createTitledBorder("Quiz Game");
        Border outer = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outer,inner));

    }
    private void createComps(){
        start = new JButton("Start");
        comboCat = new JComboBox<>();

        //Combo box
        DefaultComboBoxModel<String> catModel = new DefaultComboBoxModel<>();
        catModel.addElement("Geography");
        catModel.addElement("History");
        catModel.addElement("Chemistry");
        catModel.addElement("Biology");
        comboCat.setModel(catModel);
        comboCat.setSelectedIndex(0);

    }
    private void layoutComps(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //combo box
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose Category: "), gbc);

        gbc.gridy++;
        gbc.weighty = 0.4;
        gbc.insets = new Insets(5,5,0,0);
        add(comboCat,gbc);


        //Start button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weighty = 0.5;
        add(start,gbc);

    }


    public void activateAll(){


        //selecting category
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboSelect();
            }
        });


    }

    /**
     * Metoda koja otvori novi frame odabrane kategorije.
     */

    public void comboSelect() {
        if (comboCat.getSelectedItem().toString().equals("Geography")) {
            Geography geo = new Geography();
        } else if (comboCat.getSelectedItem().toString().equals("Chemistry")) {
            Chemistry chem = new Chemistry();
        } else if (comboCat.getSelectedItem().toString().equals("Biology")) {
            Biology bio = new Biology();
        } else if (comboCat.getSelectedItem().toString().equals("History")) {
            History hist = new History();
        }
    }

}


