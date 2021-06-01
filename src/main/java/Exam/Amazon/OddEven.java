package Exam.Amazon;

public class OddEven implements Runnable {
    @Override
    public void run() {
        // TODO Auto-generated method stub

        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                if (i % 2 == 0 && Thread.currentThread().getName().equals("t2")) {
                    try {
                        notifyAll();
                        System.out.println("Even Thread : " + i);
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else if (i % 2 != 0 && Thread.currentThread().getName().equals("t1")) {
                    try {
                        notifyAll();
                        System.out.println("Odd Thread : " + i);
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {

        OddEven obj = new OddEven();
        Thread t1 = new Thread(obj, "t1");
        Thread t2 = new Thread(obj, "t2");
        t1.start();
        t2.start();

    }
}
