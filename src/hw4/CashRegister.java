package hw4;
import java.util.*;

public class CashRegister {
   protected int whoami;  // identifies the cash register
   protected List<Customer> custs = new LinkedList<Customer>();
   protected int numserved = 0;
   protected int totalWaitTime = 0;
   protected Customer currentCust = null;
   protected String regtype;
   protected Cashier cstrat;

   public CashRegister(int n, String type) {
      whoami = n;
      regtype = type;
   }
   
   public void addCustomer(int t, int max, ItemDistribution d) {
       Customer c = new Customer(t, max, d);
       custs.add(c);
       if (currentCust == null)
           currentCust = c;
   }

   public void elapseOneSecond(int currentTime) {
      ArrayList<Object> l1 = new ArrayList<Object>();
      l1 = cstrat.elapseOneSecond(currentTime, numserved, custs, totalWaitTime, currentCust);
      if (l1.size()!=0){
          numserved=(Integer)l1.get(0);
          totalWaitTime=(Integer)l1.get(1);
          currentCust = (Customer)l1.get(2);
          custs = (List<Customer>)l1.get(3);
      }
      return;
   }

   public int size() { 
      return custs.size(); 
   }

   public String statistics() {
      return "Register " + whoami
            + "\tRegister type = " + regtype
            + "\tNumber served = " + numserved
            + "\tAverage wait time = " + avgWaitTime(); 
   }

   public int avgWaitTime() { 
      if (numserved==0)
          return 0;
      return totalWaitTime / numserved; 
   }
   
   public void setcstrat(Cashier cstrat){
       this.cstrat = cstrat;
   }
   
   public int getNumserved(){
       return numserved;
   }

}
