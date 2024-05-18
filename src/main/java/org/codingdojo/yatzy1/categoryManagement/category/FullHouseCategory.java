package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.enums.NumberCategory;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Map;

public class FullHouseCategory implements Category {
    @Override
    public int calculate(Dice[] diceFromRoll) {
        Map<Dice, Integer> occurenceDiceMap = CategoryUtil.getOccurenceDiceMap(diceFromRoll);
        int scoreThreeOfAKind = (int) occurenceDiceMap.keySet().stream()
            .filter(dice->occurenceDiceMap.get(dice) == NumberCategory.THREE_OF_A_KIND)
            .mapToInt(dice->dice.getValue() * NumberCategory.THREE_OF_A_KIND)
            .findFirst()
            .orElse(0);

        int scoreOfPair = (int) occurenceDiceMap.keySet().stream()
            .filter(dice->occurenceDiceMap.get(dice) == NumberCategory.PAIR)
            .mapToInt(dice->dice.getValue() * NumberCategory.PAIR)
            .findFirst()
            .orElse(0);

        int scoreOfYatze =  (int) occurenceDiceMap.keySet().stream()
            .filter(dice->occurenceDiceMap.get(dice) == NumberCategory.YATZY)
            .mapToInt(dice->dice.getValue() * NumberCategory.YATZY)
            .findFirst()
            .orElse(0);

        if (scoreOfYatze>0){
            return scoreOfYatze;
        } else{
            return scoreOfPair > 0 && scoreThreeOfAKind > 0 ? scoreOfPair + scoreThreeOfAKind : 0;
        }
    }
}
