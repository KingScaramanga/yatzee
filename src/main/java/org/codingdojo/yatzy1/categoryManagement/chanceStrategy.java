package org.codingdojo.yatzy1.categoryManagement;

import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.List;
import java.util.stream.IntStream;

public class chanceStrategy implements CategoryStrategy{
    @Override
    public int calculate(List<Dice> dices) {
        return dices.stream()
            .mapToInt(Dice::getValue)
            .sum();
    }
}
