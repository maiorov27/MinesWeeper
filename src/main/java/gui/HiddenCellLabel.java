package gui;

import javax.swing.*;

public class HiddenCellLabel extends JLabel {
    private static final String HIDDEN_CELL = "hid.png";
    private static final String MINED_CELL = "one.png";

    private static ImageIcon cellIcon;

    private HiddenCellLabel(ImageIcon cellIcon){
        super(cellIcon);
    }

    public static HiddenCellLabel getInstance(String value){
        cellIcon = getCorrespondingIcon(value);
        return new HiddenCellLabel(cellIcon);
    }

    private static ImageIcon getCorrespondingIcon(String value) {
        return new ImageIcon(HIDDEN_CELL);
    }

    public void setLabelValue(Icon icon){
        setIcon(icon);
    }
}
