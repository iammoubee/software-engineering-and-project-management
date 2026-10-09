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


day:2
topic:Race condition
**********************************

class CookingTask extends Thread {

    static int count = 0;

    public void run() {
        for (int i = 1; i <= 5; i++) {
            count++;
            System.out.println(getName() + " : " + i);
        }
    }
}

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        CookingTask t1 = new CookingTask();
        CookingTask t2 = new CookingTask();

        t1.setName("Cooking");
        t2.setName("Washing");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count = " + count);
    }
}

Day:3 
topic:static vs non static thread
************************************************************************

import java.util.concurrent.atomic.AtomicLong;

public class StaticVsNonStatic {

    static AtomicLong staticCount = new AtomicLong();

    static class Worker extends Thread {
        boolean useStatic;
        long localCount = 0;
        long endTime;

        Worker(boolean useStatic, long endTime) {
            this.useStatic = useStatic;
            this.endTime = endTime;
        }

        public void run() {
            while (System.nanoTime() < endTime) {
                for (int i = 0; i < 100; i++) {
                    if (useStatic) {
                        staticCount.incrementAndGet();
                    } else {
                        localCount++;
                    }
                }
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        int minutes = args.length > 0
                ? Integer.parseInt(args[0]) : 1;

        for (boolean useStatic : new boolean[]{true, false}) {
            staticCount.set(0);

            int threads = 2;
            Worker[] workers = new Worker[threads];

            long start = System.nanoTime();
            long end = start + minutes * 60_000_000_000L;

            for (int i = 0; i < threads; i++) {
                workers[i] = new Worker(useStatic, end);
                workers[i].start();
            }

            long total = 0;
            for (Worker w : workers) {
                w.join();
                total += w.localCount;
            }

            double seconds =
                    (System.nanoTime() - start) / 1e9;

            System.out.println(
                (useStatic ? "Static" : "Non-static")
                + " Counter"
            );

            System.out.println("Count: " +
                (useStatic ? staticCount.get() : total));

            System.out.printf("Time: %.2f seconds%n%n",
                    seconds);
        }
    }
}
day:4 
topic:test thread class method
****************************************************
public class ThreadMethods {

    public static void main(String[] args)
            throws InterruptedException {

        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread is running...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        });

        // 1. currentThread()
        System.out.println("Current: "
                + Thread.currentThread().getName());

        // 2. setName() and getName()
        t.setName("MyThread");
        System.out.println("Name: " + t.getName());

        // 3. setPriority() and getPriority()
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority: " + t.getPriority());

        // 4. setDaemon() and isDaemon()
        t.setDaemon(true);
        System.out.println("Daemon: " + t.isDaemon());

        // 5. start()
        t.start();

        // 6. isAlive()
        System.out.println("Alive: " + t.isAlive());

        // 7. getState()
        System.out.println("State: " + t.getState());

        // 8. yield()
        Thread.yield();
        System.out.println("Yield executed");

        // 9. sleep()
        Thread.sleep(500);

        // 10. interrupt()
        t.interrupt();

        // 11. isInterrupted()
        System.out.println("Interrupted: "
                + t.isInterrupted());

        // 12. join()
        t.join();

        // 13. isAlive() after completion
        System.out.println("Alive after join: "
                + t.isAlive());

        // 14. getState() after completion
        System.out.println("Final state: " + t.getState());

        // 15. activeCount()
        System.out.println("Active threads: "
                + Thread.activeCount());

        // 16. interrupted()
        System.out.println("Main interrupted: "
                + Thread.interrupted());

        // 17. holdsLock()
        Object lock = new Object();
        synchronized (lock) {
            System.out.println("Holds lock: "
                    + Thread.holdsLock(lock));
        }

        // 18. getStackTrace()
        System.out.println("Stack trace size: "
                + Thread.currentThread()
                        .getStackTrace().length);

        // 19. getThreadGroup()
        System.out.println("Thread group: "
                + Thread.currentThread()
                        .getThreadGroup().getName());

        // 20. dumpStack()
        Thread.dumpStack();

        System.out.println("Program finished");
    }
}

