package org.codingdojo.yatzy1.categoryManagement.category;

import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.CategoryFactory;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ChanceCategoryTest {
    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, chance, 15", "1, 2, 1, 1, 1, chance, 6",
        "1, 2, 6, 1, 6, chance, 16", "2, 2, 2, 2, 2, chance, 10", "5, 2, 2, 2, 2, chance, 13",
        "2, 2, 2, 4, 4, chance, 14"})
    public void chance_scores_sum_of_all_dice(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);
        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }
}