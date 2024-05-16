package org.codingdojo.yatzy1.categoryManagement;

import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class YatzyCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, yatzy, 0", "1, 1, 1, 1, 1, yatzy, 50",
        "1, 2, 6, 1, 6, yatzy, 0", "2, 2, 1, 2, 2, yatzy, 0", "2, 2, 2, 2, 2, yatzy, 50",
        "2, 2, 2, 4, 4, yatzy, 0"})
    public void try_to_roll_a_yatzy(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}