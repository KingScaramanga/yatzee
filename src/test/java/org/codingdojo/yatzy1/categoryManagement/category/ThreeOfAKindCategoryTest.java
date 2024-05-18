package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.CategoryFactory;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ThreeOfAKindCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, three_of_a_kind, 0", "1, 1, 2, 2, 4, three_of_a_kind, 0",
        "1, 2, 2, 2, 6, three_of_a_kind, 6", "2, 2, 3, 3, 3, three_of_a_kind, 9", "2, 4, 3, 4, 2, three_of_a_kind, 0",
        "4, 4, 4, 4, 4, three_of_a_kind, 12"})
    public void try_to_roll_a_simple_double_pair(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}