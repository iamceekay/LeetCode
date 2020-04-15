package GoldmanSach;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadRunnable {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Dell\\Desktop\\Sample.txt")))) {
                String line = null;

                while (br.readLine() != null) {
                    line = br.readLine();
                    System.out.println(Thread.currentThread().getName() + "::" + line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

       /* Thread thread = new Thread(runnable);
        thread.start();
*/
        Executor executor=Executors.newFixedThreadPool(3);
        executor.execute(runnable);
        ConcurrentHashMap<Integer,String> hmc  =new ConcurrentHashMap<>();
    }
}
