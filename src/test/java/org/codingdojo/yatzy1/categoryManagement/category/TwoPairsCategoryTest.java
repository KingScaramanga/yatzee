package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.common.factories.CategoryFactory;
import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TwoPairsCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, two_pairs, 0", "1, 1, 2, 2, 4, two_pairs, 6",
        "1, 2, 6, 1, 6, two_pairs, 14", "2, 2, 1, 3, 3, two_pairs, 10", "2, 4, 3, 4, 2, two_pairs, 12",
        "2, 2, 6, 4, 4, two_pairs, 12"})
    public void try_to_roll_a_simple_double_pair(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, two_pairs, 0", "1, 1, 2, 2, 2, two_pairs, 6",
        "1, 1, 1, 1, 1, two_pairs, 4", "2, 2, 1, 2, 2, two_pairs, 8", "2, 2, 3, 3, 3, two_pairs, 10"})
    public void try_to_roll_a_complicate_double_pair(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}