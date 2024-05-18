package org.codingdojo;


import org.codingdojo.yatzy1.categoryManagement.common.interfaces.Category;
import org.codingdojo.yatzy1.categoryManagement.common.factories.CategoryFactory;
import org.codingdojo.yatzy1.diceManagement.Dice;
import org.junit.jupiter.params.ParameterizedTest;
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
}
