import java.util.concurrent.atomic.AtomicLong;

public class Account {

    private AtomicLong money = new AtomicLong();
    private String accNumber;
    private boolean isBlocked;

    public boolean isAccountHaveAmount (long amount){
        return money.get() > amount;
    }

    public void takeMoney (long amount){
        if (isAccountHaveAmount(amount) && !isBlocked){
            money.set(money.get() - amount);
            System.out.println("Успешно");
        } else {
            if (!isAccountHaveAmount(amount)) {
                System.out.println("Недостаточно средств");
            } else {
                System.out.println("Счёт заблокирован");
            }
        }
    }

    public void receiveMoney(long amount){
        if (amount > 0  && !isBlocked) {
            money.addAndGet(amount);
            System.out.println("Успешно");
        } else {
            if (!isAccountHaveAmount(amount)) {
                System.out.println("Недостаточно средств");
            } else {
                System.out.println("Счёт заблокирован");
            }
        }
    }

    public void setBlocked () {
            isBlocked = true;
    }

    public long getMoney() {
        return money.get();
    }

    public void setMoney(long money) {
        this.money.set(money);
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
}
