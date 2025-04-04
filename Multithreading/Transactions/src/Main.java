import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Account> accounts = new HashMap<>();
        List<Account> accountList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringBuilder.append(i);
            Account account = new Account();
            account.setAccNumber(stringBuilder.toString());
            account.setMoney(random.nextLong((65_000 - 10_000 + 1) + 10_000));
            accounts.put(stringBuilder.toString(), account);
            accountList.add(account);
        }

        Bank bank = new Bank(accounts);
        System.out.println(bank.getSumAllAccounts());

        for (int i = 0; i < 4; i++) {
            threads.add(new Thread(() -> {
                for (int step = 0; step < accounts.size() - 1; step++){
                    long transferMoney = random.nextLong(0, 70_000);
                    String fromAccount = accountList.get(step).getAccNumber();
                    String toAccount = accountList.get(step + 1).getAccNumber();
                    bank.transfer(fromAccount, toAccount, transferMoney);
                }
            }));
        }
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(bank.getSumAllAccounts());

    }
}
