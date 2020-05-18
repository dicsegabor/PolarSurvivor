package SwingMVC.Model;

import java.util.Random;

public class RandomGenerator {

    private int chance;

    public RandomGenerator(int chance){

        if(chance > 100)
            this.chance = 100;

        else if(chance < 0)
            this.chance = 0;

        else
            this.chance = chance;
    }

    public boolean getJudgment(){

        return new Random().nextInt(100) < chance;
    }

    public static int getRandomInt(int range){

        return new Random().nextInt(range);
    }

    public static boolean getRandomBooelan(){

        return new Random().nextBoolean();
    }
}
