package org.codingdojo.yatzy1.categoryManagement.category;


import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.CategoryFactory;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class PairCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, pair, 0", "1, 1, 1, 1, 1, pair, 2",
        "1, 2, 6, 1, 6, pair, 12", "2, 2, 1, 2, 2, pair, 4", "2, 2, 2, 2, 2, pair, 4",
        "2, 2, 2, 4, 4, pair, 8"})
    public void try_to_roll_a_pair(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}