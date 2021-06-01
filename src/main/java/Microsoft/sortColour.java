package Microsoft;

import java.util.Arrays;
import java.util.Stack;


public class sortColour {
    public static void main(String[] args) {
        longestPalindrome("ABCCBUA");
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        System.out.println(longest);
        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public static String helper(String s, int begin, int end) {
        System.out.println("helper:::begin:"+begin+":End"+end);
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        System.out.println("helper:::"+s.substring(begin + 1, end));
        return s.substring(begin + 1, end);
    }

    private static void sortColour1Pass(int[] array) {
        int j=0,k=array.length-1;
        for(int i=0;i<=k;i++)
        {
            if(array[i]==0)
                swap(array[i],array[j++]);
            else if(array[i]==2)
                swap(array[i--],array[k--]);
        }
        System.out.println("One pass" + Arrays.toString(array));
    }

    private static void swap(int i, int j) {

    }

    private static void sortColour2Pass(int[] array) {
        int countr=0,countw=0,countb=0;
        int i=0;
        for(int a:array)
        {
            if(a==0) countr++;
            else if(a==1) countw++;
            else if(a==2) countb++;
        }
        while(i<array.length)
        {
            if(i<countr) array[i]=0;
            else if(i<countr+countb) array[i]=1;
            else array[i]=2;
            i++;
        }
        System.out.println("two pass" + Arrays.toString(array));
    }

}
