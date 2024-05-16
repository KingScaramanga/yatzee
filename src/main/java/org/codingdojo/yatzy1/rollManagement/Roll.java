package org.codingdojo.yatzy1.rollManagement;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.diceManagement.Dice;

public class Roll {
    private final Dice[] dices;
    private final Category selectedCategory;

    public Roll(String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, Category selectedCategory ){
        Dice[] dices = new Dice[5];
        dices[0] = new Dice(Integer.parseInt(firstDice));
        dices[1] = new Dice(Integer.parseInt(secondDice));
        dices[2] = new Dice(Integer.parseInt(thirdDice));
        dices[3] = new Dice(Integer.parseInt(fourthDice));
        dices[4] = new Dice(Integer.parseInt(fifthDice));

        this.dices = dices;
        this.selectedCategory = selectedCategory;
    }

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
