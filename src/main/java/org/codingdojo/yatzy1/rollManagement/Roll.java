package org.codingdojo.yatzy1.rollManagement;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.util.LinkedList;
import java.util.List;

public class Roll {
    private final Dice[] dices;
    private final Category selectedCategory;

    public Roll(Dice[] dices, Category selectedCategory) {
        this.dices = new Dice[5];
        this.selectedCategory = selectedCategory;
    }

    public Dice[] getDices() {
        return this.dices;
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public int calculate(){
        return selectedCategory.calculate(dices);
    }
}
