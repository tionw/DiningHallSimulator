package hw4;
import java.util.*;

public class CompareByWaitTime implements Comparator<CashRegister>{
    public int compare(CashRegister a, CashRegister b){
        return a.avgWaitTime()-b.avgWaitTime();
    }    
}