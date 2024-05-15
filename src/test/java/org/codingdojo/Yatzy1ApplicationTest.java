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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class Yatzy1ApplicationTest {

    @ParameterizedTest
    @CsvSource({ "1, 2, 3, 4, 5, threes, 3" })
    public void create_a_roll_from_given_parameters_with_category_three_that_return_3(
        String firstDice, String secondDice, String thirdDice, String fourthDice, String fifthDice, String categoryName, String expectedResult){

        Dice[] dicesFromParameters = new Dice[5];
        dicesFromParameters[0] = new Dice(Integer.parseInt(firstDice));
        dicesFromParameters[1] = new Dice(Integer.parseInt(secondDice));
        dicesFromParameters[2] = new Dice(Integer.parseInt(thirdDice));
        dicesFromParameters[3] = new Dice(Integer.parseInt(fourthDice));
        dicesFromParameters[4] = new Dice(Integer.parseInt(fifthDice));

        Category parametersStrategy = CategoryFactory.createCategoryStrategy(categoryName);

        Roll rollFromParameters = new Roll(dicesFromParameters, parametersStrategy);

        assertEquals(Integer.parseInt(expectedResult), rollFromParameters.calculate());
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

    @Test
    public void chance_scores_sum_of_all_dice(){
        int expected = 15;
        int actual = Yatzy1Application.chance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, Yatzy1Application.chance(3,3,4,5,1));
    }

    @Test
    public void yatzy_scores_50(){
        int expected = 50;
        int actual = Yatzy1Application.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
        assertEquals(50, Yatzy1Application.yatzy(6,6,6,6,6));
        assertEquals(0, Yatzy1Application.yatzy(6,6,6,6,3));
    }

    @Test
    public void test_1s(){
        assertTrue(Yatzy1Application.ones(1,2,3,4,5) == 1);
        assertEquals(2, Yatzy1Application.ones(1,2,1,4,5));
        assertEquals(0, Yatzy1Application.ones(6,2,2,4,5));
        assertEquals(4, Yatzy1Application.ones(1,2,1,1,1));
    }

    @Test
    public void test_2s(){
        assertEquals(4, Yatzy1Application.twos(1,2,3,2,6));
        assertEquals(10, Yatzy1Application.twos(2,2,2,2,2));
    }

    @Test
    public void test_threes(){
        assertEquals(6, Yatzy1Application.threes(1,2,3,2,3));
        assertEquals(12, Yatzy1Application.threes(2,3,3,3,3));
    }

    @Test
    public void fours_test(){
        assertEquals(12, new Yatzy1Application(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy1Application(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy1Application(4,5,5,5,5).fours());
    }

    @Test
    public void fives(){
        assertEquals(10, new Yatzy1Application(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy1Application(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy1Application(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_test(){
        assertEquals(0, new Yatzy1Application(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy1Application(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy1Application(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair(){
        assertEquals(6, new Yatzy1Application().score_pair(3,4,3,5,6));
        assertEquals(10, new Yatzy1Application().score_pair(5,3,3,3,5));
        assertEquals(12, new Yatzy1Application().score_pair(5,3,6,6,5));
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
