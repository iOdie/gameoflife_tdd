package org.gameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.function.Predicate;

public class RuleTest {

    @Test
    public void decideIfCellShouldBeAlive_Should_ReturnTrueForMatchingNeighborFilter_AndMatchingStatusOfItself () {
        //GIVEN
        Predicate<Integer> neighborFilter = (it) -> it == 3;
        FieldType cellState = FieldType.ALIVE;
        Rule rule = new Rule(neighborFilter, cellState);
        //WHEN
        boolean result = rule.decideIfCellShouldBeAlive(3, FieldType.ALIVE);
        //THEN
        Assertions.assertTrue(result);
    }

    @Test
    public void decideIfCellShouldBeAlive_Should_ReturnFalseForUnmatchingNeighborFilter_AndMatchingStatusOfItself () {
        //GIVEN
        Predicate<Integer> neighborFilter = (it) -> it == 6;
        FieldType cellState = FieldType.ALIVE;
        Rule rule = new Rule(neighborFilter, cellState);
        //WHEN
        boolean result = rule.decideIfCellShouldBeAlive(5, FieldType.ALIVE);
        //THEN
        Assertions.assertFalse(result);
    }

    @Test
    public void decideIfCellShouldBeAlive_Should_ReturnFalseForMatchingNeighborFilter_AndUnmatchingStatusOfItself () {
        //GIVEN
        Predicate<Integer> neighborFilter = (it) -> it == 8;
        FieldType cellState = FieldType.ALIVE;
        Rule rule = new Rule(neighborFilter, cellState);
        //WHEN
        boolean result = rule.decideIfCellShouldBeAlive(8, FieldType.UNALIVE);
        //THEN
        Assertions.assertFalse(result);
    }

    @Test
    public void decideIfCellShouldBeAlive_Should_ReturnFalseForUnmatchingNeighborFilter_AndUnmatchingStatusOfItself () {
        //GIVEN
        Predicate<Integer> neighborFilter = (it) -> it < 2;
        FieldType cellState = FieldType.ALIVE;
        Rule rule = new Rule(neighborFilter, cellState);
        //WHEN
        boolean result = rule.decideIfCellShouldBeAlive(7, FieldType.UNALIVE);
        //THEN
        Assertions.assertFalse(result);
    }

    /*
    @Test
    public void decideIfCellShouldBeAlive_Should_ReturnPredefinedValue_For () {

        //GIVEN
        Rule rule = new Rule(3, FieldType.ALIVE);
        Rule rule2 = new Rule(3, FieldType.ALIVE);
        Rule rule3 = new Rule(8, FieldType.ALIVE);
        //WHEN
        boolean result = rule.decideIfCellShouldBeAlive(5, FieldType.ALIVE);
        boolean result2 = rule2.decideIfCellShouldBeAlive(10, FieldType.UNALIVE);
        boolean result3 = rule3.decideIfCellShouldBeAlive(7, FieldType.UNALIVE);
        //THEN
        Assertions.assertFalse(result);
        Assertions.assertFalse(result2);
        Assertions.assertFalse(result3);
    }
     */
}
