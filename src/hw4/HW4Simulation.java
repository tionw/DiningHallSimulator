package hw4;

import java.util.Scanner;

public class HW4Simulation {
    private static final int SIMULATION_TIME = 100000;  // Simulate for 100,000 seconds.
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of normal cashiers: ");
        int normal = sc.nextInt();
        System.out.print("Enter number of fast cashiers: ");
        int fast = sc.nextInt();
        System.out.print("Enter max items per customer: ");
        int maxitems = sc.nextInt();
        System.out.print("Enter item distribution: (u)niform or (d)iscreet ");
        String dist = sc.next();
        System.out.print("Sort output by: (u)nsorted, (w)aittime, (c)ustomers served ");
        String sorttype = sc.next();
        DiningHall hall = new DiningHall(normal, fast, maxitems, dist, sorttype);
        for (int t=0; t<SIMULATION_TIME; t++) 
            hall.elapseOneSecond(t);
        hall.printStatistics();
        sc.close();
    }
}