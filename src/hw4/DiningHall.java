package hw4;
import java.util.*;

public class DiningHall {
    private static final int CUST_ARRIVAL_PCT = 15;    // There is a 15% chance a customer arrives each second.
    public int n=0;
    public int f=0;
    public int m;
    public String d;
    public String s;
    List<CashRegister> registers = new ArrayList<CashRegister>();
    
    public DiningHall(int normal, int fast, int maxitems, String dist, String sort) {
        this.n = normal;
        this.f = fast;
        m = maxitems;
        d = dist;
        s = sort;
        for (int i=0; i<normal; i++){
            CashRegister nreg = new CashRegister(i, "Normal");
            nreg.setcstrat(new NormalSpeed());
            registers.add(nreg);
        }
        for (int j=0; j<fast; j++){ 
            CashRegister freg = new CashRegister(j, "Fast");
            freg.setcstrat(new FastSpeed());
            registers.add(freg);
        }
    }
    
    public void elapseOneSecond(int t) {
        if (aCustomerArrives()) {
            CashRegister chosenRegister = smallestLine(); 
            if (d.equals("u"))
                chosenRegister.addCustomer(t, m, new Uniform());
            else
                chosenRegister.addCustomer(t, m, new Discrete());   
        }
        if (registers.size()!=0){
            for (int k=0; k<f+n; k++)
                registers.get(k).elapseOneSecond(t);
        }
    }
        
    
    public void printStatistics() {
        if (s.equals("u")){
            for (int k=0; k<n+f; k++) {
                CashRegister reg = registers.get(k);
                System.out.println(reg.statistics());
            }
        }
        else{
            if (s.equals("w")){
                Collections.sort(registers, new CompareByWaitTime());
                for (int y=0; y<n+f; y++) {
                    CashRegister reg = registers.get(y);
                    System.out.println(reg.statistics());
                }
            }
            else{
                Collections.sort(registers, new CompareByCustServed());
                for (int g=0; g<n+f; g++) {
                    CashRegister reg = registers.get(g);
                    System.out.println(reg.statistics());
                }
            }
        }
    }
    
    private boolean aCustomerArrives() {
        int n = (int) (Math.random() * 100);  // an integer between 0 and 99
        return n < CUST_ARRIVAL_PCT;
    }

    private CashRegister smallestLine() {
        CashRegister currentSmallest = registers.get(0);
        for (int r=1; r<n+f; r++) {
            CashRegister cr = registers.get(r);
            if (cr.size() < currentSmallest.size())
                currentSmallest = cr;
        }
        return currentSmallest; 
    }
}


