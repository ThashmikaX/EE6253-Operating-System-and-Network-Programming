package Threads;


public class MultiThreading extends Thread {

    private int ThreadNumber;

    public MultiThreading(int t) {
        this.ThreadNumber = t;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " is from " + ThreadNumber);

            if (ThreadNumber == 2) {
                throw new RuntimeException();
            }

            try {
                Thread.sleep(1000);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
