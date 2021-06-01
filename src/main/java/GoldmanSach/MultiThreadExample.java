package GoldmanSach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
 class MultiThreadExample {

    static AtomicInteger atomicNumber = new AtomicInteger(1);

    static public void main(String[] args) {
        Runnable print=()->
        {
            while(atomicNumber.get()<=10) {
                synchronized (atomicNumber) {
                    if (atomicNumber.get() % 2 == 0 && (Thread.currentThread().getName().equals("EVEN"))) {
                        System.out.println("Even:" + atomicNumber.getAndIncrement());
                    } else
                        System.out.println("Odd:" + atomicNumber.getAndIncrement());
                }
            }
        };
        Thread t1=new Thread(print);
        t1.setName("EVEN");
        t1.start();
        Thread t2=new Thread(print);
        t2.setName("ODD");
        t2.start();


      /* Runnable print2=()->{
            int i=0;
            while (i<=10)
            {
                synchronized (this){
                    if(i%2==0 && Thread.currentThread().getName().equals("t2")) {
                        try {
                            notifyAll();
                            System.out.println("Even::" + i);
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        try {
                            notifyAll();
                            System.out.println("odd::"+i);
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };*/
       /* Thread t11=new Thread(print2);
        t11.setName("t1");
        t11.start();
        Thread t12=new Thread(print2);
        t12.setName("t2");
        t12.start();*/
    }
}
