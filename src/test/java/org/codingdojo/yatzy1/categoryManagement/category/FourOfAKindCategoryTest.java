package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.CategoryFactory;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FourOfAKindCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, four_of_a_kind, 0", "1, 1, 2, 2, 4, four_of_a_kind, 0",
        "1, 2, 2, 2, 6, four_of_a_kind, 0", "2, 3, 3, 3, 3, four_of_a_kind, 12", "4, 4, 4, 4, 4, four_of_a_kind, 16",
        "4, 4, 4, 4, 4, four_of_a_kind, 16"})
    public void try_to_roll_four_of_a_kind(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}