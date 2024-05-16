package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CategoryUtil {
    public static Map<Dice, Integer> getOccurenceDiceMap(Dice[] diceFromRoll){
        Map<Dice, Integer> occurenceDiceValueMap = new HashMap<>();
        Arrays.stream(diceFromRoll)
            .sorted(Comparator.comparingInt(Dice::getValue).reversed())
            .forEach(dice->{
                if (occurenceDiceValueMap.containsKey(dice)){
                    occurenceDiceValueMap.put(dice,occurenceDiceValueMap.get(dice)+1);
                } else {
                    occurenceDiceValueMap.put(dice,1);
                }
            });
        return occurenceDiceValueMap;
    }
}
