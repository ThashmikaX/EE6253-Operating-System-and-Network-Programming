package Threads;

public class ThreadHandler {
    public static void main(String[] args) {
        MultiThreading t1 = new MultiThreading(1);
        MultiThreading t2 = new MultiThreading(2);
        MultiThreading t3 = new MultiThreading(3);

        t1.start();
        t2.start();
        t3.start();
    }
    
}
