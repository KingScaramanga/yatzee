package org.codingdojo.yatzy1.diceManagement;

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
            throw new IllegalArgumentException("Wrong dice value " + value);
        }
    }

    public int getValue() {
        return rollValue;
    }
}
