import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    static void print(Thread t) {
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isAlive());
        System.out.println(t.getState());
        System.out.println("*******");
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank(100);

        System.out.println(bank.getTotal());
        System.out.println("*******");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 20; i++) {
            executorService.submit(new AccountOperation(bank));
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("*******");
        System.out.println(bank.getTotal());


    }
}
