package Concurrency;

// you can also use imports, for example:import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class Solution {
    public static void main(String[] args) {
        String S="715K 2009-09-23 system.zip~\n" +
                " 179K 2013-08-14 to-do-list.xml~\n" +
                " 645K 2013-06-19 blockbuster.mpeg~\n" +
                "  536 2010-12-12 notes.html\n" +
                " 688M 1990-02-11 delete-this.zip~\n" +
                "  23K 1987-05-24 setup.png~\n" +
                " 616M 1965-06-06 important.html\n" +
                "  14M 1992-05-31 crucial-module.java~\n" +
                " 192K 1990-01-31 very-long-filename.dll~";
            String result = (new Solution()).solution ( S );
    }
    public String solution(String S) {
        // write your code in Java SE 8
        String[] ap=S.split(" ");
        DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        Date dateCheck = null;
        try {
            dateCheck = format.parse("1990-01-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<ap.length;i++)
        {
            if (ap[i].contains("~")) {
                Date date = null;
                try {
                    date = format.parse(ap[i - 1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String size = ap[i - 2];
                if (date.after(dateCheck) && sizeToNumber(size)) {
                    System.out.println(ap[i]);
                    min = Math.min(min, findSize(ap[i]));
                    System.out.println(min);
                }
            }
        }
        return String.valueOf(min);
    }
    private static int findSize(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.') return i;
        }
        return 0;
    }
    private static boolean sizeToNumber(String size) {
        StringBuilder sb=new StringBuilder();
        if(Character.isAlphabetic(size.charAt(size.length()-1)) )
        {
            if(size.charAt(size.length()-1)=='M') {
                for (int i = 0; i < size.length() - 1; i++)
                    sb.append(size.charAt(i));
                int val = Integer.valueOf(sb.toString());
                if (val >= 14) return false;
            }
            else if(size.charAt(size.length()-1)=='G') return false;
        }
        return true;
    }
}

