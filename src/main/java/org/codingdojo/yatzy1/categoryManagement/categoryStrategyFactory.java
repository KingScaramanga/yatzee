package org.codingdojo.yatzy1.categoryManagement;

public class categoryStrategyFactory {
    public CategoryStrategy createCategoryStrategy(String categoryName){
        return switch (categoryName) {
            case "chance" -> new chanceStrategy();
            case "ones" -> new DiceValueStrategy(1);
            case "twos" -> new DiceValueStrategy(2);
            case "threes" -> new DiceValueStrategy(3);
            case "fours" -> new DiceValueStrategy(4);
            case "fives" -> new DiceValueStrategy(5);
            case "sixes" -> new DiceValueStrategy(6);
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
