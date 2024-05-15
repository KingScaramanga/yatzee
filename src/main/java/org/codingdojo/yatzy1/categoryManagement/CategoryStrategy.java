package org.codingdojo.yatzy1.categoryManagement;

import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.List;

public interface CategoryStrategy {
    int calculate(List<Dice> dices);
}
