package org.gameOfLife;

import java.util.function.Predicate;

public class Rule {


    private final Predicate<Integer> filterExpectedAmountOfAliveNeighbors;
    private final FieldType expectedCellState;

    public Rule(Predicate<Integer> filterExpectedAmountOfAliveNeighbors, FieldType expectedCellState) {

        this.filterExpectedAmountOfAliveNeighbors = filterExpectedAmountOfAliveNeighbors;
        this.expectedCellState = expectedCellState;
    }

    public boolean decideIfCellShouldBeAlive(int aliveNeighborsOfCheckedCell, FieldType cellStateOfCheckedCell) {

        return filterExpectedAmountOfAliveNeighbors.test(aliveNeighborsOfCheckedCell) && expectedCellState == cellStateOfCheckedCell;
    }
}
