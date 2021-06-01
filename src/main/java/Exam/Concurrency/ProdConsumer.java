package Exam.Concurrency;

import java.util.Arrays;

class ProdConsumer {
    private static int[] buffer=new int[10];
    private  static int count=0;
    static Object lock=new Object();
static class Consumer
{
    void consume() throws InterruptedException {
        synchronized (lock){
            if(isEmpty(buffer))
                lock.wait();
            else {
                //System.out.println("Consuming"+Arrays.toString(buffer));
                count=count-1;
                buffer[count] = 0;
                lock.notify();
            }
        }
    }

    private boolean isEmpty(int[] buffer) {
        return count==0;
    }
}
    static class producer
    {
        void produce() throws InterruptedException {
            synchronized (lock){
                if(isFull(buffer))
                    lock.wait();
                else {
                    //System.out.println(Arrays.toString(buffer));
                    buffer[count++] = 1;
                    lock.notify();
                }
            }
        }

        private boolean isFull(int[] buffer) {
            return count==buffer.length;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        producer producer=  new producer();
        Consumer consumer=  new Consumer();
        Runnable producerTask=()->{
            try {
                for(int i=0;i<10;i++)
                producer.produce();
                System.out.println("Done Producing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable consumerTask=()->{
            try {
                for(int i=0;i<10;i++)
                consumer.consume();
                System.out.println("Done Consuming");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1=new Thread(producerTask);
        Thread t2=new Thread(consumerTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
