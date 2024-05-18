package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.common.factories.CategoryFactory;
import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LargeStraightCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, large_straight, 0", "2, 3, 4, 5, 4, large_straight, 0",
        "5, 3, 6, 2, 4, large_straight, 20", "2, 4, 6, 5, 3, large_straight, 20", "2, 4, 3, 4, 2, large_straight, 0",
        "2, 3, 4, 5, 6, large_straight, 20"})
    public void try_to_roll_a_large_straight(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}