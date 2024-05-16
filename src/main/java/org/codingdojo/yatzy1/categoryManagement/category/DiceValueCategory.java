package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Arrays;
import java.util.List;

public class DiceValueCategory implements Category {
    private final int diceValue;
    @Override
    public int calculate(Dice[] dices) {
        return Arrays.stream(dices)
            .filter(dice -> dice.getValue() == diceValue)
            .mapToInt(Dice::getValue)
            .sum();
    }

    public DiceValueCategory(int diceValue) {
        this.diceValue = diceValue;
    }
}
