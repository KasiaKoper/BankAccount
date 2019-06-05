
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccount1 {

    private int balance;

    public BankAccount1(int balance) {       //konstruktor klasy zewnetrznej
        this.balance = balance;
    }

    //wywolanie klasy wewn standardowej
    public class BalanceCounter implements ActionListener {
        private double interestRate;

        public BalanceCounter(double interestRate){
            this.interestRate=interestRate;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int newBalance = (int) (BankAccount1.this.balance + balance * interestRate);
            System.out.println("Changing account balance from " + balance + " to " + newBalance);
            BankAccount1.this.balance = newBalance;
        }

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
