package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.enums.NumberCategory;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.*;


public class TwoPairsCategory implements Category {

    @Override
    public int calculate(Dice[] diceFromRoll) {
        Map<Dice, Integer> occurenceDiceMap = CategoryUtil.getOccurenceDiceMap(diceFromRoll);
        List<Dice> dicePairs = occurenceDiceMap.keySet()
            .stream()
            .filter(dice->occurenceDiceMap.get(dice)>1)
            .toList();

        if (dicePairs.size() > NumberCategory.SINGLE_VALUE){
            return dicePairs.stream()
                .mapToInt(dice->dice.getValue()* NumberCategory.PAIR)
                .sum();
        } else {
            return occurenceDiceMap.keySet().stream()
                .filter(key->occurenceDiceMap.get(key) > NumberCategory.THREE_OF_A_KIND)
                .mapToInt(dice->dice.getValue() * NumberCategory.FOUR_OF_A_KIND)
                .findFirst()
                .orElse(0);
        }
    }
}
