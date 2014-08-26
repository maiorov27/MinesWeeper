package gui;

import javax.swing.*;

public class OneValueCellLabel extends JLabel{
    private static final String ONE_VALUE_CELL = "hid.png";
    private static ImageIcon oneCellIcon = new ImageIcon(ONE_VALUE_CELL);

    private OneValueCellLabel(ImageIcon icon){
        super(oneCellIcon);
    }

    public static OneValueCellLabel getInstance(){
        return new OneValueCellLabel(oneCellIcon);
    }
}
