
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccount2 {

    private int balance;

    public BankAccount2(int balance) {       //konstruktor klasy zewnetrznej
        this.balance = balance;
    }

    //EVENTy
    public ActionListener createBalanceCounter(double interestRate) {
        //jesli mamy klasę w metodzie, to ta klasa jest lokalna
        class BalanceCounter implements ActionListener {

            private double interestRate;

            public BalanceCounter(double interestRate) {
                this.interestRate = interestRate;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int newBalance = (int) (BankAccount2.this.balance * interestRate);
                System.out.println("Changing amount balance from"
                        + balance        //BankAccount2.this.balance
                        + " to "
                        + newBalance);
                balance=newBalance;
            }
        }
        return new BalanceCounter(interestRate);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


}
