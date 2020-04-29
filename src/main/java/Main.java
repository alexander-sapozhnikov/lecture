import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

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
