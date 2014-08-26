package logic;

public class CellsValueIncrementer {
    private Cell[][] cells;

    public CellsValueIncrementer(Cell[][] cells) {
        this.cells = cells;
    }

    public void incrementCellsValue(int line, int column) {
        int dimension = cells.length;
        if (line != 0 && line != dimension - 1 &&
                column != 0 && column != dimension - 1) {
            incrementValueInCenterPosition(line, column);
        }
        if (line == 0 && column != 0 && column != dimension - 1) {
            incValueInCenterOfFirstLine(line, column);
        }
        if (line == 0 && (column == 0)) {
            incValueInFirstColumnAndFirstLine(line, column);
        }
        if (line == 0 && (column == dimension - 1)) {
            incValueInFirstLineAndLastColumn(line, column);
        }
        if (line == dimension - 1 && (column == 0)) {
            incValueInLastLineAndFirstColumn(line, column);
        }
        if (line == dimension - 1 && (column == dimension - 1)) {
            incValueInLastLineAndLastColumn(line, column);
        }
        if (line == dimension - 1 && column != 0 && column != dimension - 1) {
            incValueInLastLineAndCenterColumn(line, column);
        }
        if (column == dimension - 1 && line != 0 && line != dimension - 1) {
            incValueInCenterOfLastColumn(line, column);
        }
        if (column == 0 && line != 0 && line != dimension - 1) {
            incValueInCenterOfFirstColumn(line, column);
        }
    }

    private void incrementValueInCenterPosition(int line, int column) {
        cells[line + 1][column].incValue();
        cells[line + 1][column + 1].incValue();
        cells[line + 1][column - 1].incValue();
        cells[line][column + 1].incValue();
        cells[line][column - 1].incValue();
        cells[line - 1][column].incValue();
        cells[line - 1][column + 1].incValue();
        cells[line - 1][column - 1].incValue();
    }

    private void incValueInCenterOfFirstLine(int line, int column) {
        cells[line][column - 1].incValue();
        cells[line][column + 1].incValue();
        cells[line + 1][column - 1].incValue();
        cells[line + 1][column].incValue();
        cells[line + 1][column + 1].incValue();
    }

    private void incValueInFirstColumnAndFirstLine(int line, int column) {
        cells[line][column + 1].incValue();
        cells[line + 1][column + 1].incValue();
        cells[line + 1][column].incValue();
    }

    private void incValueInFirstLineAndLastColumn(int line, int column) {
        cells[line][column - 1].incValue();
        cells[line + 1][column - 1].incValue();
        cells[line + 1][column].incValue();
    }

    private void incValueInLastLineAndFirstColumn(int line, int column) {
        cells[line][column + 1].incValue();
        cells[line - 1][column + 1].incValue();
        cells[line - 1][column].incValue();
    }

    private void incValueInLastLineAndLastColumn(int line, int column) {
        cells[line][column - 1].incValue();
        cells[line - 1][column - 1].incValue();
        cells[line - 1][column].incValue();
    }

    private void incValueInLastLineAndCenterColumn(int line, int column) {
        cells[line][column - 1].incValue();
        cells[line][column + 1].incValue();
        cells[line - 1][column - 1].incValue();
        cells[line - 1][column].incValue();
        cells[line - 1][column + 1].incValue();
    }

    private void incValueInCenterOfLastColumn(int line, int column) {
        cells[line - 1][column].incValue();
        cells[line - 1][column - 1].incValue();
        cells[line][column - 1].incValue();
        cells[line + 1][column - 1].incValue();
        cells[line + 1][column].incValue();
    }

    private void incValueInCenterOfFirstColumn(int line, int column) {
        cells[line - 1][column].incValue();
        cells[line - 1][column + 1].incValue();
        cells[line][column + 1].incValue();
        cells[line + 1][column + 1].incValue();
        cells[line + 1][column].incValue();
    }


}
