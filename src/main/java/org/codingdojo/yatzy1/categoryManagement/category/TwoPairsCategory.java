package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.*;
import java.util.stream.Collectors;

public class TwoPairsCategory implements Category {
    @Override
    public int calculate(Dice[] diceFromRoll) {
        Map<Dice, Integer> occurenceDiceMap = CategoryUtil.getOccurenceDiceMap(diceFromRoll);
        List<Dice> dicePairs = occurenceDiceMap.keySet()
            .stream()
            .filter(dice->occurenceDiceMap.get(dice)>1)
            .toList();

        if (dicePairs.size()>1){
            return dicePairs.stream().mapToInt(dice->dice.getValue()*2).sum();
        } else {
            return 0;
        }
    }
}
