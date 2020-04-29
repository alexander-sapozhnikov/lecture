
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AccountOperation implements Runnable {

    private final Bank bank;
    private final Random random;

    public AccountOperation(Bank bank) {
        this.bank = bank;
        random = ThreadLocalRandom.current();
    }

    @Override
    public void run() {
            Thread t = Thread.currentThread();
            System.out.println(t.getId());

            for (int i = 0; i < bank.countOfAccounts(); ++i){
                int amount = random.nextInt(80);
                int a = random.nextInt(bank.countOfAccounts());
                int b = random.nextInt(bank.countOfAccounts());
                bank.transfer(a, b, amount);
            }
    }


}
