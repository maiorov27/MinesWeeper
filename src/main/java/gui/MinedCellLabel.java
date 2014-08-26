package gui;

import javax.swing.*;

public class MinedCellLabel extends JLabel {
    private static final String HIDDEN_CELL = "hid.png";
    private static ImageIcon closedCellIcon = new ImageIcon(HIDDEN_CELL);

    private MinedCellLabel(ImageIcon icon) {
        super(closedCellIcon);
    }

    public static MinedCellLabel getInstance() {
        return new MinedCellLabel(closedCellIcon);
    }
}
