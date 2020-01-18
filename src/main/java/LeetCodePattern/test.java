package LeetCodePattern;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>(hs);
        String str1 = "abd";
        String str2 = "abd";
        String str3 = new String("abd");

        System.out.println(str1 == str3);
        test a=new test();
        test b=new test();
        test c=new test();
        test d=new test();
        System.out.println(d.getCount());
        System.out.println(a.nscount);
    }

    interface ExampleInterface1 {
        //By default - public static final. No other modifier allowed
//value1,value2,value3,value4 all are - public static final
        int value1 = 10;
        public int value2 = 15;
        public static int value3 = 20;
        public static final int value4 = 25;

        //private int value5 = 10;//COMPILER ERROR
        default void method5() {
            System.out.println("Method5");
        }
    }
        private static int count;
    private  int nscount;

    public int getNscount() {
        return nscount;
    }

    public void setNscount(int nscount) {
        this.nscount = nscount;
    }

    public test()
        {
            count++;
            nscount++;
        }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        test.count = count;
    }
}
