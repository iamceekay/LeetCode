package Exam.Concurrency;

import java.util.Random;

public class RaceCondition {
    int randInt;
    Random random=new Random(System.currentTimeMillis());
    void printer()
    {
        int i=10000;
        while(i!=0) {
            synchronized (this) {
                if (randInt % 5 == 0)
                    if (randInt % 5 != 0)
                        System.out.println(randInt);
            }
        }
        i--;
    }
    void modifier()
    {
        int i=10000;
        while(i!=0) {
            synchronized (this) {
                randInt = random.nextInt(1000);
                i--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition rc=new RaceCondition();
        Runnable task1=()->{rc.printer();};
        Runnable task2=()->{rc.modifier();};
        Thread t1=new Thread(task1);
        Thread t2=new Thread(task2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
