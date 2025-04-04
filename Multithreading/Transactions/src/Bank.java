
import java.util.HashMap;
import java.util.Random;

public class Bank {
    private final HashMap<String, Account> accounts;
    private final Random random = new Random();
    private long bankMoney = 0;

    public Bank (HashMap<String, Account> accounts){
        this.accounts = accounts;
        calculateBankMoney(accounts);
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        if (amount > 50_000) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    try {
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            fromAccount.setBlocked();
                            toAccount.setBlocked();
                            System.out.println("Пользователи заблокированы");
                        } else {
                            fromAccount.takeMoney(amount);
                            toAccount.receiveMoney(amount);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else {
            fromAccount.takeMoney(amount);
            toAccount.receiveMoney(amount);
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */

    private void calculateBankMoney(HashMap<String, Account> accounts) {
        for (String key : accounts.keySet()) {
           bankMoney += accounts.get(key).getMoney();
        }
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return bankMoney;
    }
}
