package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.common.CategoryUtil;
import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.categoryManagement.enums.NumberCategory;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Map;

public class FourOfAKindCategory implements Category {
    @Override
    public int calculate(Dice[] diceFromRoll) {
        Map<Dice, Integer> occurenceDiceMap = CategoryUtil.getOccurenceDiceMap(diceFromRoll);

        return occurenceDiceMap.keySet().stream()
            .filter(dice-> occurenceDiceMap.get(dice) > NumberCategory.THREE_OF_A_KIND)
            .mapToInt(dice-> dice.getValue() * NumberCategory.FOUR_OF_A_KIND)
            .findFirst()
            .orElse(0);
    }
}
