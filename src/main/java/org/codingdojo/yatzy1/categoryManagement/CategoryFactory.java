package org.codingdojo.yatzy1.categoryManagement;

import org.codingdojo.yatzy1.diceManagement.Dice;

public class CategoryFactory {
    public static Category createCategoryStrategy(String categoryName) {
        AllowedCategory category = AllowedCategoryUtil.getAllowedCategory(categoryName);

        return switch (category) {
            case CHANCE -> new ChanceCategory();
            case ONES -> new DiceValueCategory(Dice.FACE_ONE);
            case TWOS -> new DiceValueCategory(Dice.FACE_TWO);
            case THREES -> new DiceValueCategory(Dice.FACE_THREE);
            case FOURS -> new DiceValueCategory(Dice.FACE_FOUR);
            case FIVES -> new DiceValueCategory(Dice.FACE_FIVE);
            case SIXES -> new DiceValueCategory(Dice.FACE_SIX);
        /*case "pair" -> new PairStrategy();
        case "two pairs" -> TwoPairsStrategy();
        case "three of a kind" -> ThreeOfAKindStrategy();
        case "four of a kind" -> FourOfAKindStrategy();
        case "Small straight" -> SmallStraightStrategy();
        case "Large straight" -> LargeStraightStrategy();
        case "Full house" -> FullHouseStrategy();*/
            default -> throw new IllegalArgumentException("Unknown category provided : " + categoryName);
        };

    }
}
