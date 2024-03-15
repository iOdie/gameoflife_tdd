package org.gameOfLife;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameBoardTest {

    @Test
    public void initialize_Should_CreateBoard_WithTenByTenFields_Unalive_ForZeroParameters () {
        //WHEN
        GameBoard gameboard = new GameBoard();
        //THEN
        Assert.assertEquals(10, gameboard.getWidth());
        Assert.assertEquals(10, gameboard.getHeight());

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Assert.assertEquals(FieldType.UNALIVE, gameboard.getField(x,y));
            }
        }
    }

    @Test
    public void setField_Should_SetFieldTypeToFieldAtGivenPosition_ForFieldTypeXAndY () {
        //GIVEN
        GameBoard gameboard = new GameBoard();
        //WHEN
        gameboard.setField(FieldType.ALIVE, 5, 4);
        //THEN
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if(x == 5 && y == 4) {
                    Assert.assertEquals(FieldType.ALIVE, gameboard.getField(x,y));
                } else {
                    Assert.assertEquals(FieldType.UNALIVE, gameboard.getField(x,y));
                }
            }
        }
    }

    @Test
    public void getNeighbors_Should_returnNeighborsOfCell_ForXAndYPosition () {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        //WHEN
        FieldType[] neighbors = gameBoard.getNeigbors(1, 1);

        //THEN
        Assertions.assertEquals(8, neighbors.length);

        for (FieldType neighbor : neighbors) {
            Assertions.assertEquals(FieldType.UNALIVE, neighbor);
        }
    }

    @Test
    public void getNeighbors_Should_returnNeighborsOfCell_ForXAndYPosition_OnBoardWithAliveAndUnaliveCells () {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        gameBoard.setField(FieldType.ALIVE, 0, 0);
        gameBoard.setField(FieldType.ALIVE, 2, 2);
        //WHEN
        FieldType[] neighbors = gameBoard.getNeigbors(1, 1);

        //THEN
        Assertions.assertEquals(8, neighbors.length);

        assertAliveNeighbors(neighbors, List.of(0,7));

    }

    public void assertAliveNeighbors (FieldType[] actualFields, List<Integer> expectedAliveFields) {
        for ( int i = 0; i < actualFields.length; i++) {
            if (expectedAliveFields.contains(i)) {
                Assertions.assertEquals(FieldType.ALIVE, actualFields[i]);
            } else {
                Assertions.assertEquals(FieldType.UNALIVE, actualFields[i]);
            }
        }
    }

    @Test
    public void setField_Should_ThrowException_When_X_OutOfBoard () {
        //GIVEN
        GameBoard gameboard = new GameBoard();
        //WHEN /THEN
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> gameboard.setField(FieldType.ALIVE, 15, 8));
    }

    @Test
    public void setField_Should_ThrowException_When_Y_OutOfBoard () {
        //GIVEN
        GameBoard gameboard = new GameBoard();
        //WHEN /THEN
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> gameboard.setField(FieldType.ALIVE, 7, 15));
    }
}