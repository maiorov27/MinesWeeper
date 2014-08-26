package gui;

import logic.Field;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    private HiddenCellLabel[][] gamingField;
    private Field field;
    private int fieldDimension;

    public GameField(Field field) {
        this.field = field;
        fieldDimension = field.getDimension();
        this.gamingField = new HiddenCellLabel[fieldDimension][fieldDimension];
        setFieldLayout();
        createCellsOnTheField();
    }

    private void setFieldLayout() {
        GridLayout layout = new GridLayout(fieldDimension, fieldDimension,0,10);
        setLayout(layout);
    }

    private void createCellsOnTheField() {
        for (int i = 0; i < field.getDimension(); i++) {
            for (int j = 0; j < field.getDimension(); j++) {
                String cellValue = String.valueOf(field.getCellValue(i, j));
                gamingField[i][j] = HiddenCellLabel.getInstance(cellValue);
                this.add(gamingField[i][j]);
            }
        }
    }


}
