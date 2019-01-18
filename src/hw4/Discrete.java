package hw4;
import java.util.*;

public class Discrete implements ItemDistribution {
    public int getItems(int max){
        Random rand = new Random();
        int r = rand.nextInt(3);
        if (r==2)
            return 1;
        if (r==1)
            return Math.round(max/2);
        else
            return max;
    }
}