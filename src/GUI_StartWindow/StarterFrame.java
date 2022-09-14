package GUI_StartWindow;

import javax.swing.*;
import java.awt.*;

public class StarterFrame extends JFrame{

    private StarterFramePanel StarterFramePanel;

    public StarterFrame(){

        super("Quiz");
        setSize(225,325);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        initializeAll();
        layoutComps();

    }
    private void initializeAll(){
        StarterFramePanel = new StarterFramePanel();
    }
    private void layoutComps(){
        setLayout(new BorderLayout());
        add(StarterFramePanel, BorderLayout.CENTER);
    }
}
