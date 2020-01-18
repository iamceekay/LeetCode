package Concurrency;

import java.util.concurrent.*;

public class ExecutorRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable task=()-> System.out.println("i am thread"+Thread.currentThread().getName());
        //ExecutorService service= Executors.newSingleThreadExecutor();
        Callable<String> taskC=()->{
           // throw new IllegalStateException("Threead Callable current"+Thread.currentThread().getName());
            System.out.println("Threead Callable current"+Thread.currentThread().getName());
            return "12";
        };
        ExecutorService service= Executors.newFixedThreadPool(4);
        for (int i=0;i<10;i++)
        {
           // service.execute(task);
            Future<String> future = service.submit(taskC);
            //System.out.println(future.get());
        }

        service.shutdown();
    }
}
