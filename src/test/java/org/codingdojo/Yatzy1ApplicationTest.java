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
    public void two_Pair(){
        assertEquals(16, Yatzy1Application.two_pair(3,3,5,4,5));
        assertEquals(16, Yatzy1Application.two_pair(3,3,5,5,5));
    }

    @Test
    public void three_of_a_kind(){
        assertEquals(9, Yatzy1Application.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, Yatzy1Application.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, Yatzy1Application.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd(){
        assertEquals(12, Yatzy1Application.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, Yatzy1Application.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, Yatzy1Application.three_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight(){
        assertEquals(15, Yatzy1Application.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy1Application.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy1Application.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight(){
        assertEquals(20, Yatzy1Application.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy1Application.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy1Application.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse(){
        assertEquals(18, Yatzy1Application.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy1Application.fullHouse(2,3,4,5,6));
    }
}
