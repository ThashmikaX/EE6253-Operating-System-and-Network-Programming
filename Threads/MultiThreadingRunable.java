package Threads;

public class MultiThreadingRunable implements Runnable {

    private int ThreadNumber;

    public MultiThreadingRunable(int t) {
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

//this method called implementing the runnable interface
//this is the best method, other method is extending the thread class
