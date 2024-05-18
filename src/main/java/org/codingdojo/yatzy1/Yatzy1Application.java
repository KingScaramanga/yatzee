package org.codingdojo.yatzy1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codingdojo.yatzy1.categoryManagement.Category;
import org.codingdojo.yatzy1.categoryManagement.CategoryFactory;
import org.codingdojo.yatzy1.diceManagement.Dice;
import org.codingdojo.yatzy1.rollManagement.Roll;


public class Yatzy1Application {

    private static final Logger logger = LogManager.getLogger(Yatzy1Application.class);

    public static void main(String[] args){
        logger.info("Welcome to Yatze1");

        if (args.length<6){
            logger.error("Yatze1 need 6 parameters to start properly");
        } else{
            try {
                logger.info(new StringBuilder("Dice Roll {").append(args[0]).append(",")
                    .append(args[1]).append(",")
                    .append(args[2]).append(",")
                    .append(args[3]).append(",")
                    .append(args[4]).append("}")
                    .append(" and chosen category : ").append(args[5])
                );
                Dice[] diceFromRoll = new Dice[5];

                diceFromRoll[0] = new Dice(Integer.parseInt(args[0]));
                diceFromRoll[1] =  new Dice(Integer.parseInt(args[1]));
                diceFromRoll[2] =  new Dice(Integer.parseInt(args[2]));
                diceFromRoll[3] =  new Dice(Integer.parseInt(args[3]));
                diceFromRoll[4] =  new Dice(Integer.parseInt(args[4]));

                String categoryName = args[5];

                Category selectedCategory = CategoryFactory.createCategoryStrategy(categoryName);
                Roll diceRoll = new Roll(diceFromRoll, selectedCategory);

                logger.info(new StringBuilder("Roll's score : ").append(diceRoll.calculate()));

            } catch (Exception ex){
                logger.error(ex.getMessage());
            }
        }

    }

    protected int[] dice;

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[_1-1]++;
        tallies[_2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }


    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



