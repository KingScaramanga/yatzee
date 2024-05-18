package org.codingdojo.yatzy1.categoryManagement;

import org.codingdojo.yatzy1.categoryManagement.category.*;
import org.codingdojo.yatzy1.categoryManagement.enums.AllowedCategory;

import org.codingdojo.yatzy1.diceManagement.Dice;

public class CategoryFactory {
    public static Category createCategoryStrategy(String categoryName) {
        AllowedCategory category = CategoryUtil.getAllowedCategory(categoryName);

        return switch (category) {
            case CHANCE -> new ChanceCategory();
            case ONES -> new DiceValueCategory(Dice.FACE_ONE);
            case TWOS -> new DiceValueCategory(Dice.FACE_TWO);
            case THREES -> new DiceValueCategory(Dice.FACE_THREE);
            case FOURS -> new DiceValueCategory(Dice.FACE_FOUR);
            case FIVES -> new DiceValueCategory(Dice.FACE_FIVE);
            case SIXES -> new DiceValueCategory(Dice.FACE_SIX);
            case PAIR -> new PairCategory();
            case TWO_PAIRS -> new TwoPairsCategory();
            case THREE_OF_A_KIND -> new ThreeOfAKindCategory();
            case FOUR_OF_A_KIND -> new FourOfAKindCategory();
            case SMALL_STRAIGHT -> new SmallStraightCategory();
            case LARGE_STRAIGHT -> new LargeStraightCategory();
            case FULL_HOUSE -> new FullHouseCategory();
            case YATZY -> new YatzyCategory();
        };

    }
}
