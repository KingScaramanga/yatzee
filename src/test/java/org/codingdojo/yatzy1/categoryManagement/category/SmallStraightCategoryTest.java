package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.CategoryFactory;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SmallStraightCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, small_straight, 15", "1, 1, 2, 2, 4, small_straight, 0",
        "5, 3, 1, 2, 4, small_straight, 15", "2, 4, 6, 5, 3, small_straight, 0", "2, 4, 3, 4, 2, small_straight, 0",
        "4, 4, 4, 4, 4, small_straight, 0"})
    public void try_to_roll_a_small_straight(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}