package SnakeAndLadder;

import java.util.Random;

public class Dice {
    private final int minValue ;
    private final int maxValue ;
    public Dice(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    public int roll(){
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);

        // 0- 1(not included) * (difference) + minvalue
        // 0.2 * 6 = 1.2 , 1.2+ 1 = 2.2 = [2]
        // 0.9 * 6 = 5.4 , 5.4+ 1 = 6.4 = [6]

    }

}
