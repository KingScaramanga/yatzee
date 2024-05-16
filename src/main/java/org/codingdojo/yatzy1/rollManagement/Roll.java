package org.codingdojo.yatzy1.rollManagement;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

public class Roll {
    private final Dice[] dices;
    private final Category selectedCategory;

    public Roll(Dice[] dices, Category selectedCategory) {
        this.dices = dices;
        this.selectedCategory = selectedCategory;
    }

    public Dice[] getDices() {
        return this.dices;
    }

    public int calculate(){
        return selectedCategory.calculate(dices);
    }
}
