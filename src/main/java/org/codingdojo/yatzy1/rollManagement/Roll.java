package org.codingdojo.yatzy1.rollManagement;

import org.codingdojo.yatzy1.categoryManagement.CategoryStrategy;
import org.codingdojo.yatzy1.diceManagement.Dice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Roll {
    private final List<Dice> dices;
    private final CategoryStrategy selectedCategory;

    public Roll(List<Dice> dices, CategoryStrategy selectedCategory) {
        this.dices = new LinkedList<Dice>(dices);
        this.selectedCategory = selectedCategory;
    }

    public List<Dice> getDices() {
        return new LinkedList<>(this.dices);
    }

    public CategoryStrategy getSelectedCategory() {
        return selectedCategory;
    }

    public int calculate(){
        return selectedCategory.calculate(dices);
    }
}
