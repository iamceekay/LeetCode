package Exam.Concurrency;

public class SumExample {
    long startRange;
    long endRange;
    long counter=0;
   static long MAX_NUM=Integer.MAX_VALUE;

    public SumExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }
    public void add()
    {
        for(long i=startRange;i<endRange;i++)
        {
            counter+=i;
        }
    }
    static public void Onethread()
    {
        long start=System.currentTimeMillis();
        SumExample s= new SumExample(1,MAX_NUM);
        s.add();
        long end=System.currentTimeMillis();
        System.out.println(s.counter+" Time Single "+(end-start));
    }
    static public void twothread() throws InterruptedException {
        long start=System.currentTimeMillis();
        SumExample s1= new SumExample(1,MAX_NUM/2);
        SumExample s2= new SumExample((MAX_NUM/2)+1,MAX_NUM);
        Runnable task1=()->{
            s1.add();
        };
        Runnable task2=()->{
            s2.add();
        };
        Thread t1=new Thread(task1);
        Thread t2=new Thread(task2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long finalCount=s1.counter+s2.counter;
        long end=System.currentTimeMillis();
        System.out.println(finalCount+" Multiple thread "+(end-start));
    }
   static public void runTest() throws InterruptedException {
        Onethread();
        twothread();
    }

    public static void main(String[] args) throws InterruptedException {
        runTest();
    }
}
