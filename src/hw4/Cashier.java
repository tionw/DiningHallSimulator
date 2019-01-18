package hw4;
import java.util.*;

public interface Cashier {
    ArrayList<Object> elapseOneSecond(int currentTime, int numserved, List<Customer> custs, int totalWaitTime, Customer currentCust);
    String cashierType();
}
