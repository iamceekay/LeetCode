package Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayandString {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=  new HashMap<>();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target-nums[i]))
            {
                res[0]=i;
                res[1]=hm.get(target-nums[i]);
            }

            hm.put(nums[i],i);
        }
        return res;
    }

   public boolean isPalindrome(String s) {
       s=s.replaceAll("[^A-Za-z0-9]","").toUpperCase();
       int i=0;
       int j=s.length()-1;
       while(i<j)
           if(s.charAt(i++)!=s.charAt(j--)) return false;
       return true;
   }
    public boolean isPalindromeOptimised(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(!Character.isLetterOrDigit(s.charAt(i))) i++;
            else if(!Character.isLetterOrDigit(s.charAt(j))) j--;
            else if(Character.toLowerCase(s.charAt(i++))!=Character.toLowerCase(s.charAt(j--)))
                return false;
        }
        return true;
    }
        public int myAtoi(String str) {
            if (str == null || str.length() == 0)
                return 0;
            str = str.trim();
            if (str.equals("")) return 0;
            char firstChar = str.charAt(0);
            int sign = 1, start = 0, len = str.length();
            long sum = 0;
            if (firstChar == '+') {
                sign = 1;
                start++;
            } else if (firstChar == '-') {
                sign = -1;
                start++;
            }
            for (int i = start; i < len; i++) {
                if (!Character.isDigit(str.charAt(i)))
                    return (int) sum * sign;
                sum = sum * 10 + str.charAt(i) - '0';
                if (sign == 1 && sum > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }

            return (int) sum * sign;
        }
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while(i<j)
        {
            swap(i++,j--,s);
        }

    }
    public void swap(int i,int j,char[] s)
    {
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }

    public String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }


    class Solution {
        public void reverseEachWord(char[] s) {
            int n = s.length;
            int start = 0, end = 0;

            while (start < n) {
                // go to the end of the word
                while (end < n && s[end] != ' ') ++end;
                // reverse the word
                reverse(s, start, end - 1);
                // move to the next word
                start = end + 1;
                ++end;
            }
        }
        public void reverseWords(char[] s) {
            // reverse the whole string
            reverse(s, 0, s.length - 1);

            // reverse each word
            reverseEachWord(s);
        }
        public void reverse(char[] s, int left, int right) {
            while (left < right) {
                char tmp = s[left];
                s[left++] = s[right];
                s[right--] = tmp;
            }
        }
    }
    public String longestPalindrome(String s)
    {
        if(s==null || s.isEmpty()) return s;
        if(s.length()==1) return s;
        String longest=s.substring(0,1);
        for(int i=0;i<s.length();i++)
        {
            String temp=expand(s,i,i);
            if(temp.length() > longest.length())
            {
                longest=temp;
            }
            temp=expand(s,i,i+1);
            if(temp.length() > longest.length())
            {
                longest=temp;
            }
        }
        return longest;
    }
    public String expand(String s,int start,int end)
    {
        while(start>=0 && end <s.length() && s.charAt(start)==s.charAt(end))
        {
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm= new HashMap<>();

        for(String str:strs)
        {
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String sorted=new String(arr);
            if(!hm.containsKey(sorted))
            {
                hm.put(sorted,new ArrayList<String>());
            }
            hm.get(sorted).add(str);
        }
        return new ArrayList<List<String>>(hm.values());

    }

    public int trap(int[] height) {
        int[] leftMax=new int[height.length];
        int[] rightMax=new int[height.length];
        int left=0,right=0,sum=0;
        for(int i=0;i<height.length;i++ )
        {
            left=Math.max(left,height[i]);
            leftMax[i]=left;
        }
        for(int i=height.length-1;i>=0;i-- )
        {
            right=Math.max(right,height[i]);
            rightMax[i]=right;
        }
        for(int i=0;i<height.length;i++ ){
            sum+=Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return sum;

    }


}
