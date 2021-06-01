package Exam.Concurrency;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class prodConsumerBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<Integer> sharedQ =new LinkedBlockingDeque<>();
        Producer p=new Producer(sharedQ);
        Consumer q=new Consumer(sharedQ);
        p.start();
        q.start();
        p.join();
        q.join();

    }
    static class Producer extends Thread{
        private BlockingDeque<Integer> sharedQueue;

        public Producer(BlockingDeque<Integer> sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
           for(int i=0;i<10;i++)
           {
               System.out.println(getName() +" prod"+ i);
               try {
                   sharedQueue.put(i);
                   Thread.sleep(200);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
    static class Consumer extends Thread{
        private BlockingDeque<Integer> sharedQueue;

        public Consumer(BlockingDeque<Integer> sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
           while (true)
           {
               try {
                   Integer item= sharedQueue.take();
                   System.out.println(getName()+"Consumed"+item);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}
