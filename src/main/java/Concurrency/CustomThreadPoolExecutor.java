package Concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {
    private final BlockingQueue<Runnable> workerQueue;
    private final Thread[] workerThreads;

    public CustomThreadPoolExecutor(int numThreads) {
        workerQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numThreads];
        int i = 0;
        for (Thread t : workerThreads) {
            t = new Worker("Custom Pool Thread " + ++i);
            t.start();
        }
    }

    public void addTask(Runnable r) {
        try {
            workerQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        public void run() {
            while (true) {
                try {
                    workerQueue.take().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutor(3);
      threadPoolExecutor.addTask(() -> System.out.println("First print task"));
      threadPoolExecutor.addTask(() -> System.out.println("Second print task"));
        threadPoolExecutor.addTask(() -> System.out.println("third print task"));
        threadPoolExecutor.addTask(() -> System.out.println("fourth print task"));
        threadPoolExecutor.addTask(() -> System.out.println("fifth print task"));
    }

}