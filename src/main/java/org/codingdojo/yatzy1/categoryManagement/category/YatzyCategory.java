package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Arrays;

public class YatzyCategory implements Category {
    private static final int YATZY_SCORE = 50;

    @Override
    public int calculate(Dice[] dices) {
       int countedDiceDifferentFromFirst = (int) Arrays.stream(dices)
           .mapToInt(Dice::getValue)
           .filter(diceValue -> diceValue != dices[0].getValue())
           .count();

       if ( countedDiceDifferentFromFirst > 0){
           return 0;
       } else {
           return YATZY_SCORE;
       }

    }
}
