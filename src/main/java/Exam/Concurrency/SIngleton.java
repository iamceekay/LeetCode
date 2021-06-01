package Exam.Concurrency;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

   synchronized Singleton getInstance()
    {
        if(instance==null)
        {
            instance=new Singleton();
        }
        return instance;
    }

}
