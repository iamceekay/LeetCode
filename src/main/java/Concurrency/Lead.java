package Concurrency;

public class Lead {

}
class Follower extends Lead{
    static int  test()
    {
       try {
           throw new ClassNotFoundException();
       } catch (ClassNotFoundException e) {
          throw new NullPointerException();
       }

    }


    public static void main(String[] args) {
        System.out.println(test());
    }
}
