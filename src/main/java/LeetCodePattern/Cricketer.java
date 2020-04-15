package LeetCodePattern;

public class Cricketer {
    private int count;
    public Cricketer()
    {
        count++;
    }

    public  int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Cricketer c1=new Cricketer();
        Cricketer c2=new Cricketer();
        Cricketer c3=new Cricketer();
        System.out.println(c1.getCount());
        System.out.println(c2.getCount());
        System.out.println(c3.getCount());
    }
}
