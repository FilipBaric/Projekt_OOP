package GUI_Selection.Biology;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BiologyPanelRight extends JPanel {

    private JTextArea area;
    private JScrollPane scrollPane;

    public BiologyPanelRight(){
        Dimension dim = getPreferredSize();
        dim.width = 450;
        setPreferredSize(dim);
        setBorders();
        createComps();

    }
    private void setBorders(){
        Border inner = BorderFactory.createTitledBorder("Results");
        Border outer = BorderFactory.createEmptyBorder(5,5,5,5);
        Border fnlBr = BorderFactory.createCompoundBorder(outer, inner);
        setBorder(fnlBr);
    }

    private void createComps(){
        area = new JTextArea();
        area.setEditable(false);
        scrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setLayout(new BorderLayout());
        add(scrollPane,BorderLayout.CENTER);
    }

    public void setText2Area(String text){
        area.append(text);
    }
    public String getTextFromArea(){
        area.selectAll();
        return area.getSelectedText();
    }
}
