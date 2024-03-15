package org.gameOfLife;

public class Rule {


    private final int expectedAmountOfAliveNeighbors;
    private final FieldType expectedCellState;

    public Rule(int expectedAmountOfAliveNeighbors, FieldType expectedCellState) {

        this.expectedAmountOfAliveNeighbors = expectedAmountOfAliveNeighbors;
        this.expectedCellState = expectedCellState;
    }

    public boolean decideIfCellShouldBeAlive(int aliveNeighborsOfCheckedCell, FieldType cellStateOfCheckedCell) {

        return expectedAmountOfAliveNeighbors == aliveNeighborsOfCheckedCell && expectedCellState == cellStateOfCheckedCell;
    }
}
