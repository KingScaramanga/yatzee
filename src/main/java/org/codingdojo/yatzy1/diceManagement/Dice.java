package org.codingdojo.yatzy1.diceManagement;

import java.util.Objects;

public class Dice {
    private final int rollValue;
    public static final int FACE_ONE = 1;
    public static final int FACE_TWO = 2;
    public static final int FACE_THREE = 3;
    public static final int FACE_FOUR = 4;
    public static final int FACE_FIVE = 5;
    public static final int FACE_SIX = 6;

    public Dice(int value) {
        this.rollValue = value;
        if (value<0 || value>6){
            throw new IllegalArgumentException(new StringBuilder("Wrong dice value ").append(value).toString() );
        }
    }

    public int getValue() {
        return rollValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return rollValue == dice.rollValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollValue);
    }
}
