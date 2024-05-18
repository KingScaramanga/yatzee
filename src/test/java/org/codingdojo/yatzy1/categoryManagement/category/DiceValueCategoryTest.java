package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.CategoryFactory;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class DiceValueCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, threes, 3", "1, 2, 1, 1, 1, ones, 4",
        "1, 2, 6, 1, 6, sixes, 12", "2, 2, 2, 2, 2, twos, 10", "5, 2, 2, 2, 2, fives, 5",
        "2, 2, 2, 4, 4, fours, 8", "2, 2, 2, 5 , 5, fours, 0"})
    public void roll_every_dice_value_strategy(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);

        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}