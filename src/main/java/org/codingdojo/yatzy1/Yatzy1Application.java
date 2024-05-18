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



