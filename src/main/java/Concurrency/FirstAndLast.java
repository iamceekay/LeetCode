package Concurrency;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class FirstAndLast {
    public static void main(String[] args) throws ParseException {
      //  searchRange(new int[]{5,7,7,8,8,10,10,12},8);
       // System.out.println(test(6, 20));
        String s="715K 2009-09-23 system.zip~\n" +
                " 179K 2013-08-14 to-do-list.xml~\n" +
                " 645K 2013-06-19 blockbuster.mpeg~\n" +
                "  536 2010-12-12 notes.html\n" +
                " 688M 1990-02-11 delete-this.zip~\n" +
                "  23K 1987-05-24 setup.png~\n" +
                " 616M 1965-06-06 important.html\n" +
                "  14M 1992-05-31 crucial-module.java~\n" +
                " 192K 1990-01-31 very-long-filename.dll~";
        String[] ap=s.split(" ");
        DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        Date dateCheck = format.parse("1990-01-31");
        int min=Integer.MAX_VALUE;
        for(int i=0;i<ap.length;i++) {
            if (ap[i].contains("~")) {
                // System.out.println(ap[i-1]);
                Date date = format.parse(ap[i - 1]);
                String size = ap[i - 2];
                if (date.after(dateCheck) && sizeToNumber(size)) {
                    System.out.println(ap[i]);
                    min = Math.min(min, findSize(ap[i]));
                    System.out.println(min);
                }


            }
        }
        System.out.println(min);
        String.valueOf(min);
    }

    private static int findSize(String s) {
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

    public static int test(int A, int B) {
        // write your code in Java SE 8
        int count=0;
        while(A<=B)
        {
            int number=(int) Math.sqrt(A);
            if(number*(number+1)==A) count++;
            A++;
        }
        return count;

    }

    public static int[] searchRange(int[] nums, int target) {
        // Binary Search get the index;
        // Start search from there with start point;
        // Find next greater element
        int start=binarySearch(nums,0,target);
        int end=binarySearch(nums,start,target+1)-1;
        if(start<=end)
            return new int[]{start,end};
        return new int[]{-1,-1};

    }
    //5,7,7,8,8,10,10,12= 4
    //
    public static int binarySearch(int[] nums,int start,int target)
    {
        int end=nums.length-1;
        int first=nums.length;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            System.out.println(mid);
            if(nums[mid] >=target)
            {
                first=mid;
                end=mid-1;
            }
            else start=mid+1;;
        }
        return first;

    }
}
