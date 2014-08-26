package logic;

public class Field {
    private final int MINES_NUMBER;

    private Cell[][] cells;
    private int dimension;
    private Miner miner;
    private CellsValueIncrementer incrementer;
    public Field(Miner miner) {
        this(miner, 20);
    }

    public Field(Miner miner, int dimension) {
        this.dimension = dimension;
        MINES_NUMBER = dimension * dimension / 6;
        this.miner = miner;
        cells = new Cell[dimension][dimension];
        createCells();
        incrementer  =  new CellsValueIncrementer(cells);
        putMinesOnTheField();
        calculateValuesForCells();
    }

    private void createCells() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    protected void putMinesOnTheField() {
        MinesPositionsContainer posContainer = miner.calculateMinesPositions(dimension, dimension * dimension / 6);
        for (int i = 0; i < posContainer.size(); i++) {
            int position = posContainer.get(i);
            int line = convertPosToLineNumber(position);
            int row = convertPosToCellNumber(position);
            cells[line][row].setMined(true);
        }
    }

    protected Integer convertPosToLineNumber(int position) {
        return position / dimension;
    }

    protected Integer convertPosToCellNumber(int position) {
        return position % dimension;
    }

    protected void calculateValuesForCells() {
        for (int line = 0; line < dimension; line++) {
            for (int column = 0; column < dimension; column++) {
                if (cells[line][column].isMined()) {
                    incrementer.incrementCellsValue(line, column);
                }
            }
        }
    }

//    private void incrementCellsValue(int line, int column) {
//        // center case
//        if (line != 0 && line != dimension - 1 &&
//                column != 0 && column != dimension - 1) {
//            cells[line + 1][column].incValue();
//            cells[line + 1][column + 1].incValue();
//            cells[line + 1][column - 1].incValue();
//            cells[line][column + 1].incValue();
//            cells[line][column - 1].incValue();
//            cells[line - 1][column].incValue();
//            cells[line - 1][column + 1].incValue();
//            cells[line - 1][column - 1].incValue();
//        }
//
//        //in the center of firstLine
//        if (line == 0 && column != 0 && column != dimension -1) {
//            cells[line][column - 1].incValue();
//            cells[line][column + 1].incValue();
//            cells[line + 1][column - 1].incValue();
//            cells[line + 1][column].incValue();
//            cells[line + 1][column + 1].incValue();
//        }
//
//        //first line first column
//        if (line == 0 && (column == 0)){
//            cells[line][column+1].incValue();
//            cells[line+1][column+1].incValue();
//            cells[line+1][column].incValue();
//        }
//
//        //first line last column
//        if (line == 0 && (column == dimension - 1)){
//            cells[line][column-1].incValue();
//            cells[line+1][column-1].incValue();
//            cells[line+1][column].incValue();
//        }
//
//        //last line first column
//        if (line == dimension - 1 && (column == 0)){
//            cells[line][column+1].incValue();
//            cells[line-1][column+1].incValue();
//            cells[line-1][column].incValue();
//        }
//
//        //last line last column
//        if (line == dimension - 1 && (column == dimension - 1)){
//            cells[line][column-1].incValue();
//            cells[line-1][column-1].incValue();
//            cells[line-1][column].incValue();
//        }
//
//        //in the center of last line
//        if (line == dimension - 1 && column != 0 && column != dimension - 1) {
//            cells[line][column - 1].incValue();
//            cells[line][column + 1].incValue();
//            cells[line -1][column - 1].incValue();
//            cells[line -1 ][column].incValue();
//            cells[line - 1][column + 1].incValue();
//        }
//
//        //in the center of last column
//        if(column == dimension - 1 && line != 0 && line != dimension - 1){
//            cells[line-1][column].incValue();
//            cells[line-1][column-1].incValue();
//            cells[line][column-1].incValue();
//            cells[line+1][column-1].incValue();
//            cells[line+1][column].incValue();
//        }
//
//        //in the center of first collumn
//        if(column == 0 && line != 0 && line != dimension - 1){
//            cells[line-1][column].incValue();
//            cells[line-1][column+1].incValue();
//            cells[line][column+1].incValue();
//            cells[line+1][column+1].incValue();
//            cells[line+1][column].incValue();
//        }
//
//
//    }

    public void setMiner(Miner miner) {
        this.miner = miner;
    }

    public int getCellValue(int row, int column){
        return cells[row][column].getValue();
    }

    public int getCellValue(int position){
        int row = convertPosToCellNumber(position);
        int column = convertPosToLineNumber(position);
        return cells[row][column].getValue();
    }
    public int getDimension() {
        return dimension;
    }

    public void showMines() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if(cells[i][j].isMined()){
                    System.out.print(" X ");
                } else {
                    System.out.print(" "+cells[i][j].getValue()+" ");
//                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Field f = new Field(new RandomMiner(), 20);
        f.showMines();
        System.exit(0);
    }
}
