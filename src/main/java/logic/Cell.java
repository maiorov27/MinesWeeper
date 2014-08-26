package logic;

public class Cell {
    private int value;
    private boolean mined;

    public Cell() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void incValue() {
        this.value++;
    }

    public boolean isCellClear() {
        return value == 0;
    }

    public boolean isMined() {
        return mined;
    }

    public void setMined(boolean status) {
        this.mined = status;
    }
}
