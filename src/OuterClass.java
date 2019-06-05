
/* klasa zewnętrzna widzi metody klasy wewnętrznej,
    ale klasa wewnętrzna NIE widzi metod klasy zewnetrznej
 */

public class OuterClass {           //klasa zewnetrzna

    //klasa wewnetrzna
    public static class InnerClass{


    }


    //metoda zwracajaca obiekt klasy wewnetrznej
    public InnerClass instance(){
        return new InnerClass();
    }



}
