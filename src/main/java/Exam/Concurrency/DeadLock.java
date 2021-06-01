package Exam.Concurrency;

public class DeadLock {
    private Object lock1=new Object();
    private Object lock2=new Object();
    public void firStMethod()
    {
        synchronized (lock1)
        {
            System.out.println(Thread.currentThread().getName() +" I am in first");
            secondMethod();
        }
    }

    private void secondMethod() {
        synchronized (lock2)
        {
            System.out.println(Thread.currentThread().getName() +" I am in second");
            thirdMethod();
        }
    }

    private void thirdMethod() {
        synchronized (lock1)
        {
            System.out.println(Thread.currentThread().getName() +" I am in third");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock=new DeadLock();
        Runnable task1=()->{deadLock.firStMethod();};
        Runnable task2=()->{deadLock.secondMethod();};
        Thread t1=new Thread(task1);
        Thread t2=new Thread(task2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
