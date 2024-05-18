package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1Application;
import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.CategoryFactory;
import org.codingdojo.yatzy1.diceManagement.Dice;
import org.codingdojo.yatzy1.rollManagement.Roll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class Yatzy1ApplicationTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 7, 10})
    public void try_a_inconsistent_dice(int diceValue){
        Exception exception = assertThrows(IllegalArgumentException.class,
            ()->new Dice(diceValue) );

        String expectedMessage = "Wrong dice value";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @ValueSource(strings = {"CHANCE", "YATZY", "ONES", "TWOS", "THREES", "FOURS", "FIVES", "SIXES",
        "PAIR", "THREE_OF_A_KIND", "FOUR_OF_A_KIND", "SMALL_STRAIGHT", "LARGE_STRAIGHT", "TWO_PAIRS", "FULL_HOUSE"})
    public void try_each_valid_category(String categoryName){
        assertInstanceOf(Category.class, CategoryFactory.createCategoryStrategy(categoryName));
    }
    @ParameterizedTest
    @ValueSource(strings = {"seventh", "", " "})
    public void roll_with_an_invalid_category(String categoryName){
        Exception exception = assertThrows(RuntimeException.class,
            ()->CategoryFactory.createCategoryStrategy(categoryName) );

        String expectedMessage = "Unknown category";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, threes, 3" })
    public void create_a_roll_from_given_parameters_with_category_three_that_return_3(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);

        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, threes, 3", "1, 2, 1, 1, 1, ones, 4",
        "1, 2, 6, 1, 6, sixes, 12", "2, 2, 2, 2, 2, twos, 10", "5, 2, 2, 2, 2, fives, 5",
        "2, 2, 2, 4, 4, fours, 8"})
    public void roll_every_dice_value_strategy(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);

        Roll rollFromParameters = new Roll(firstDice, secondDice, thirdDice, fourthDice, fifthDice, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
    }

    @Test
    public void fullHouse(){
        assertEquals(18, Yatzy1Application.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy1Application.fullHouse(2,3,4,5,6));
    }
}
