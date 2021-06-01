package LeetCodePattern;

 class TestExam implements Runnable{
    public void foo()
     {
        System.out.println("Super");
    }

     @Override
     public void run() {
         System.out.println("Turing");
     }

     public static void main(String[] args) {
       Thread  t1=new Thread(new TestExam());
       t1.start();
       t1.start();
         System.out.println(t1.getState());
     }
 }
class child extends TestExam
{
    public void foo()
    {
        System.out.println("Sub");
    }


}
