package GoldmanSach;

import java.io.*;

public class ThreadClass extends Thread{
    @Override
    public void run() {
        try(BufferedReader br=new BufferedReader(new FileReader(new File("C:\\Users\\Dell\\Desktop\\Sample.txt"))))
        {
            String line=null;

            while (br.readLine()!=null)
            {
                line=br.readLine();
                System.out.println(Thread.currentThread().getName()+"::"+line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       Thread thread1= new ThreadClass();
        Thread thread2= new ThreadClass();
        Thread thread3= new ThreadClass();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
