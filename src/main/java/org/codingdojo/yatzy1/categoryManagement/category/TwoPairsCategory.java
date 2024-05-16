package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
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
        //TODO : deal with complicated pairs like 2 pairs from fourth of a kind
        if (dicePairs.size()>1){
            return dicePairs.stream().mapToInt(dice->dice.getValue()*2).sum();
        } else {
            return 0;
        }
    }
}
