package org.codingdojo.yatzy1.categoryManagement;

import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PairCategory implements Category {
    @Override
    public int calculate(Dice[] dices) {

        Map<Dice, Integer> occurenceDiceValueMap = new HashMap<>();
        Arrays.stream(dices)
            .sorted(Comparator.comparingInt(Dice::getValue).reversed())
            .forEach(dice->{
                if (occurenceDiceValueMap.containsKey(dice)){
                    occurenceDiceValueMap.put(dice,occurenceDiceValueMap.get(dice)+1);
                } else {
                    occurenceDiceValueMap.put(dice,1);
                }
            });
        return occurenceDiceValueMap.keySet()
                .stream()
                .filter(key -> occurenceDiceValueMap.get(key) > 1)
                .max(Comparator.comparingInt(Dice::getValue))
                .map(dice -> dice.getValue() * 2)
                .orElse(0);
    }
}
