package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Map;

public class ThreeOfAKindCategory implements Category {
    @Override
    public int calculate(Dice[] diceFromRoll) {
        Map<Dice, Integer> occurenceDiceMap = CategoryUtil.getOccurenceDiceMap(diceFromRoll);
        return occurenceDiceMap.keySet().stream()
            .filter(key->occurenceDiceMap.get(key)>2)
            .mapToInt(dice -> dice.getValue()*3)
            .findFirst()
            .orElse(0);
    }
}
