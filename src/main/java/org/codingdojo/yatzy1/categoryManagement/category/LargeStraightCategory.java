package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Arrays;
import java.util.Comparator;

public class LargeStraightCategory implements Category {
    private static final int LARGE_STRAIGHT_SCORE = 20;

    @Override
    public int calculate(Dice[] dices) {

        Arrays.sort(dices, Comparator.comparingInt(Dice::getValue));

        if (dices[0].getValue() == Dice.FACE_TWO &&
            dices[1].getValue() == Dice.FACE_THREE &&
            dices[2].getValue() == Dice.FACE_FOUR &&
            dices[3].getValue() == Dice.FACE_FIVE &&
            dices[4].getValue() == Dice.FACE_SIX)
        {
            return LARGE_STRAIGHT_SCORE;
        }
        else {
            return 0;
        }
    }
}
