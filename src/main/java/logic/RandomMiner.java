package logic;

import java.util.ArrayList;
import java.util.Random;

public class RandomMiner implements Miner {
    private MinesPositionsContainer posContainer = new MinesPositionsContainer();

    @Override
    public MinesPositionsContainer calculateMinesPositions(int dimension, int minesNumber) {
        if (minesNumberValid(minesNumber)) {
            for (int i = 0; i < minesNumber; i++) {
                posContainer.add(selectCellForMine(dimension));
            }
        }

        return posContainer;
    }

    private boolean minesNumberValid(int minesNumber) {
        if (minesNumber < 0 || minesNumber == 0)
            throw new IllegalArgumentException();
        return true;
    }

    private int selectCellForMine(int dimension) {
        Random r = new Random();
        int cellNumber = r.nextInt(dimension*dimension);
        while (posContainer.contains(cellNumber)) {
            cellNumber = r.nextInt(dimension*dimension);
        }
        return cellNumber;
    }
}
