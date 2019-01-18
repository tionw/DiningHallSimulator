package hw4;

public class Customer {
   private int arrivalTime;
   private int serviceTime;
   protected ItemDistribution istrat;
   
   public Customer(int t, int max, ItemDistribution istrat) {
      arrivalTime = t;
      this.istrat = istrat;
      int howmanyItems = istrat.getItems(max);
      serviceTime = 2*howmanyItems + 10;
   }
   
   public void elapseOneSecond() {
     serviceTime --;
   }
   
   public boolean isFinished() {
     return serviceTime == 0;
   }
   
   public int arrivalTime() {
      return arrivalTime;
   }
   
}