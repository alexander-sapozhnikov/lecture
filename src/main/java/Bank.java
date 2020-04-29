import java.util.Arrays;

public class Bank {

    private volatile int[] accounts;

    public Bank(int count) {
        accounts = new int[count];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = 100;
        }
    }

    public synchronized int getTotal() {
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            sum += accounts[i];
        }
        return sum;
    }

    public synchronized int getAccount(int i) {
        return accounts[i];
    }

    public synchronized void setAccount(int i, int amount) {
        synchronized (accounts){
        accounts[i] = amount;}
    }

    public int countOfAccounts() {
        return accounts.length;
    }

    public void transfer(int a, int b, int amount) {
        //a -> b
        synchronized (accounts) {
            printThread(Thread.currentThread());
            System.out.print("Transfer from " + a);
            System.out.print(" to "+ b);
            System.out.println(" sum  " + amount);
            if (getAccount(a) >= amount) {
                this.setAccount(a, getAccount(a) - amount);
                this.setAccount(b, getAccount(b) + amount);
            }
        }
    }

    private void printThread(Thread t){
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isAlive());
        System.out.println(t.getState());
        System.out.println("--------");
    }

    @Override
    public String toString() {
        return Arrays.toString(accounts);
    }
}
