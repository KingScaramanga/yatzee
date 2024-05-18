package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.common.CategoryUtil;
import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.categoryManagement.enums.NumberCategory;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Comparator;
import java.util.Map;

public class PairCategory implements Category {
    @Override
    public int calculate(Dice[] diceFromRoll) {

        Map<Dice, Integer> occurenceDiceMap = CategoryUtil.getOccurenceDiceMap(diceFromRoll);

        return occurenceDiceMap.keySet()
                .stream()
                .filter(key -> occurenceDiceMap.get(key) > NumberCategory.SINGLE_VALUE)
                .max(Comparator.comparingInt(Dice::getValue))
                .map(dice -> dice.getValue() * NumberCategory.PAIR)
                .orElse(0);
    }
}
