package org.codingdojo.yatzy1.categoryManagement;

import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.List;

public class DiceValueStrategy implements CategoryStrategy{
    private final int diceValue;
    @Override
    public int calculate(List<Dice> dices) {
        return dices.stream()
            .filter(dice -> dice.getValue() == diceValue)
            .mapToInt(Dice::getValue)
            .sum();
    }

    public DiceValueStrategy(int diceValue) {
        this.diceValue = diceValue;
    }
}
