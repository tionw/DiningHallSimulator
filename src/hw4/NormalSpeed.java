package hw4;

import java.util.*;

public class NormalSpeed implements Cashier{
    public ArrayList<Object> elapseOneSecond(int currentTime, int numserved, List<Customer> custs, int totalWaitTime, Customer currentCust){
      ArrayList<Object> l1 = new ArrayList<Object>();
      if (currentCust == null)
         return l1;
      currentCust.elapseOneSecond();
      if (currentCust.isFinished()) {
         numserved++;
         totalWaitTime += currentTime - currentCust.arrivalTime();
         custs.remove(0);
         currentCust = custs.size() > 0 ? custs.get(0) : null;
      }
      l1.add(numserved);
      l1.add(totalWaitTime);
      l1.add(currentCust);
      l1.add(custs);
      return l1;
    }
    public String cashierType(){
        return "Normal Cashier";
    }
}
