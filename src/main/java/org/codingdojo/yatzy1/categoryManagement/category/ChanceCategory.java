package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Arrays;

public class ChanceCategory implements Category {
    @Override
    public int calculate(Dice[] dices) {
        return Arrays.stream(dices)
            .mapToInt(Dice::getValue)
            .sum();
    }
}
