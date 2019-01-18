package hw4;
import java.util.*;

public class CompareByCustServed implements Comparator<CashRegister>{
    public int compare(CashRegister a, CashRegister b){
        return b.getNumserved()-a.getNumserved();
    }    
}