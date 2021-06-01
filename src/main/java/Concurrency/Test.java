package Concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    static Test t;
   static int count=0;

   @Override
   protected void finalize() throws Throwable {
      count++;
      t=this;
   }

   public static void main(String[] args) throws InterruptedException {
     Test t1=new Test();
     t1=null;
     System.gc();
     Thread.sleep(1000);
     t=null;
      System.gc();
      Thread.sleep(1000);
      System.out.println(count);

     // SELECT o.CONTINENT, FLOOR(AVG(i.POPULATION)) FROM CITY AS i JOIN COUNTRY AS o ON i.COUNTRYCODE=o.CODE GROUP BY o.CONTINENT;


   }
}
