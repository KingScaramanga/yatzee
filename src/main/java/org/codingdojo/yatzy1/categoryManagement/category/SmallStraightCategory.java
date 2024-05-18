package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Arrays;
import java.util.Comparator;

public class SmallStraightCategory implements Category {

    private static final int SMALL_STRAIGHT_SCORE = 15;

    @Override
    public int calculate(Dice[] diceFromRoll) {

        Arrays.sort(diceFromRoll, Comparator.comparingInt(Dice::getValue));
        if (diceFromRoll[0].getValue() == Dice.FACE_ONE &&
            diceFromRoll[1].getValue() == Dice.FACE_TWO &&
            diceFromRoll[2].getValue() == Dice.FACE_THREE &&
            diceFromRoll[3].getValue() == Dice.FACE_FOUR &&
            diceFromRoll[4].getValue() == Dice.FACE_FIVE)
        {
            return SMALL_STRAIGHT_SCORE;
        }
        else {
            return 0;
        }

    }
}
