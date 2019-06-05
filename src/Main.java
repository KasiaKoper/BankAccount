
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Main {

    /*BankAccount 1,2,3 robią to samo, tylko innymi sposobami
     **/

    public static void main(String[] args) {

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass instanceA = outerClass.instance();           //korzystamy z metody tworzącej obiekt klasy wewnętrznej
        //OuterClass.InnerClass instanceAA = outerClass.new InnerClass();     //bezposrednio tutaj tworzymy nowy obiekt klasy wewnetrznej (drugi sposob, ale rzadziej uzywany)
        //ale tak robimy tylko, jesli klasa wewnetrzna jest publiczna?

        OuterClass.InnerClass instanceB = new OuterClass.InnerClass();        //tak mozemy tworzyc tylko, gdy klasa wewnetrzna jest statyczna

        initWindow();

    }


    private static void task1() {
        initWindow();
        BankAccount1 accoount = new BankAccount1(1000);
        BankAccount1.BalanceCounter counter = accoount.new BalanceCounter(1.2);

        Timer timer = new Timer(1000, counter);
        timer.setInitialDelay(0);
        timer.start();
    }

    private static void task2() {
        initWindow();
        BankAccount2 accoount = new BankAccount2(1000);
        Timer timer = new Timer(1000,accoount.createBalanceCounter(1.2) );
        timer.setInitialDelay(0);
        timer.start();
    }

    private static void task3() {
        initWindow();
        BankAccount3 accoount = new BankAccount3(1000,1.2);
        Timer timer = new Timer(1000,accoount.createBalanceCounter());
        timer.setInitialDelay(0);
        timer.start();
    }

    private static void task4() {

        //1 sposob, ale nieoptymalny, bo interfdace funkcyjny ma zawsze TYLKO jedna metode wiec mozna to skrócić

//        FunctionalInterface fi=new FunctionalInterface() {
//            @Override
//            public void init() {
//                System.out.println("init");
//            }
//        };

        //lub sposob z lambdami, wywolujemy tu metode anonimowa (jedyna metode w interface funkcyjnym)

        FunctionalInterface fi=()-> System.out.println("init");

    }


    //twOrzymy PRZYCISK
    private static void initWindow() {
        JFrame frame = new JFrame("Bank Account");

        //WĄTKI - żeby aplikacja wykonywala nam zadania w tle, a sama dalej dzialala
        //ponizsze polecenie jest konieczne zeby aplikacja sie nie zaciela, zeby uzywala wątkowości
        //exit on close zamyka nam wątek przy zamknieciu okna
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //dodaje przycisk
        JButton button = new JButton("Close");

        //dodajemy event do przycisku
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        //rozmiary przycisku
        button.setBounds(0, 0, 150, 150);
        button.setMargin(new Insets(10, 10, 10, 10));
        frame.getContentPane().add(button, BorderLayout.CENTER);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
