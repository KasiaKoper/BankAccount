
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccount3 {

    private int balance;
    private double interestRate;

    public BankAccount3(int balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    //klasa anonimowa - robimy wtedy, gdy chcemy uzyc kodu tylko raz, w jednym miejscu naszej klasy

    public ActionListener createBalanceCounter() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newBalance = (int) (BankAccount3.this.balance * interestRate);
                System.out.println("Changing amount balance from"
                        + balance
                        + " to "
                        + newBalance);
                balance=newBalance;
            }
        };
    }

}
