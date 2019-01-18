package hw4;

import java.util.*;

public class Uniform implements ItemDistribution {
    public int getItems(int max){
        Random rand = new Random();
        int n = rand.nextInt(max)+1;
        return n;
    }
}