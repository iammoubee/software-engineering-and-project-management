4/10/2026
day:1
topic:Multithreading
******************************************
class Cooking extends Thread {

    int count = 0;

    public void run() {

        System.out.println("This is a cooking class");

        while (true) {
            System.out.println("Cooking...");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Cooking T1 = new Cooking();
        Cooking T2 = new Cooking();
        Cooking T3 = new Cooking();

        T1.start();
        T2.start();
        T3.start();
    }
}

topic:Static
***************************************
class Test {
    static int count = 0;

    void increment() {
        count++;
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();

        t1.increment();
        t2.increment();

        System.out.println(t1.count);
        System.out.println(t2.count);
    }
}
topic:Non static
*****************************************
class Test {
    int count = 0;

    void increment() {
        count++;
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();

        t1.increment();
        t2.increment();

        System.out.println(t1.count);
        System.out.println(t2.count);
    }
}
