package LeetCodePattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class SlidingWindow {
    public static void main(String[] args) {
        HashSet<Integer> hs= new LinkedHashSet<>();
    }
    /*209. Minimum Size Subarray Sum
    Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    Example:

    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: the subarray [4,3] has the minimal length under the problem constraint.*/

    public int minSubArrayLen(int s, int[] nums) {
        int i=0,j=0,n=nums.length,sum=0,min=Integer.MAX_VALUE;
        while(i<n)
        {
            sum+=nums[i];
            while(sum>=s)
            {
                min=Math.min(min,i-j+1);
                sum=sum-nums[j];
                j++;
            }
            i++;
        }
        return min==Integer.MAX_VALUE?0:min;

    }

    /*3. Longest Substring Without Repeating Characters
    Given a string, find the length of the longest substring without repeating characters.

    Example 1:

    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs =   new HashSet<>();
        int i=0,j=0,n=s.length(),max=Integer.MIN_VALUE;
        while(i<n)
        {
            char c=s.charAt(i);
            if(hs.add(c)){
                max=Math.max(max,i-j+1);
                i++;
            }
            else
            {
                hs.remove(s.charAt(j));
                j++;
            }


        }
        return max==Integer.MIN_VALUE ? 0 :max;

    }

    /*424. Longest Repeating Character Replacement
    Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.

    In one operation, you can choose any character of the string and change it to any other uppercase English character.

    Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

            Note:
    Both the string's length and k will not exceed 104.

    Example 1:

    Input:
    s = "ABAB", k = 2

    Output:
            4

    Explanation:
    Replace the two 'A's with two 'B's or vice versa.


    Example 2:

    Input:
    s = "AABABBA", k = 1

    Output:
            4

    Explanation:
    Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.*/
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);

            int lettersToChange = (right - left + 1) - mostFreqLetter;
            if(lettersToChange > k){
                freq[s.charAt(left) - 'A']--;
                left++;
                mostFreqLetter--;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
   /* 1004. Max Consecutive Ones III
    Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

    Return the length of the longest (contiguous) subarray that contains only 1s.



            Example 1:

    Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    Output: 6
    Explanation:
            [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
            Example 2:

    Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
    Output: 10
    Explanation:
            [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.*/

    public int longestOnes(int[] A, int K) {
        int left = 0, right;
        for (right = 0; right < A.length; right++) {
            // If we included a zero in the window we reduce the value of K.
            // Since K is the maximum zeros allowed in a window.
            if (A[right] == 0) K--;
            // A negative K denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (K < 0) {
                // If the left element to be thrown out is zero we increase K.
                if (A[left] == 0) K++;
                left++;
            }
        }
        return right - left;
    }
}
