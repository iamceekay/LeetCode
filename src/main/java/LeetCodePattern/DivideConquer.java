package LeetCodePattern;

public class DivideConquer {
    public static void main(String[] args) {
        System.out.println( longestCommonSubsequence2("aab","azb"));
    }

    public int rob(int[] nums) {
        int[] maxMoney=new int[nums.length];
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        if(nums.length>2)
        {
            maxMoney[0]=nums[0];
            maxMoney[1]=nums[1];
            for(int i=2;i<nums.length;i++)
                maxMoney[i]=Math.max(nums[i]+maxMoney[i-2],maxMoney[i-1]);
        }
        return maxMoney[nums.length-1];
    }
    public int findMinOperations(String s1, String s2) {
        return findMinOperationsAux(s1, s2, 0, 0);
    }//end of method

    private int findMinOperationsAux(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length()) // if we have reached the end of s1, then insert all the remaining characters of s2
            return s2.length() - i2;

        if (i2 == s2.length()) // if we have reached the end of s2, then delete all the remaining characters of s1
            return s1.length() - i1;

        if (s1.charAt(i1) == s2.charAt(i2)) // If the strings have a matching character, recursively match for the remaining lengths.
            return findMinOperationsAux(s1, s2, i1 + 1, i2 + 1);

        int c1 = 1 + findMinOperationsAux(s1, s2, i1 + 1, i2); // perform deletion
        int c2 = 1 + findMinOperationsAux(s1, s2, i1, i2 + 1); // perform insertion
        int c3 = 1 + findMinOperationsAux(s1, s2, i1 + 1, i2 + 1); // perform replacement

        return Math.min(c1, Math.min(c2, c3));
    }//end of method

    //LCS(aab,azb)
    //1+LCS(ab,zb)
    //1+Max(LCS(a,zb),lcs(ab,z)
    //1+
    



    public static int  longestCommonSubsequence(String text1, String text2) {
        return findLCSLengthAux(text1, text2, 0, 0);
    }//end of method


    private static int findLCSLengthAux(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length() || i2 == s2.length())//Base Case
            return 0;
        int c3 = 0;
        if (s1.charAt(i1) == s2.charAt(i2)) {//If current character in both the string matches, then increase the index by 1 in both the strings.
            //Char equal
            System.out.println(s1 + "::" + s2);
            System.out.println(s1.charAt(i1) + "::" + s2.charAt(i2));
            c3 = 1 + findLCSLengthAux(s1, s2, i1 + 1, i2 + 1);
        }

        int c1 = findLCSLengthAux(s1, s2, i1, i2 + 1);//Increase index of 2nd String
        int c2 = findLCSLengthAux(s1, s2, i1 + 1, i2);//Increase index of 1st String

        return Math.max(c3, Math.max(c1, c2));
    }
  /*  }
    This is what the DP table looks like filled out for the 2 strings
  "AGGTAB" and "GXTXAYB".

            ""  A  G  G  T  A  B
  ""  0  0  0  0  0  0  0
    G   0  0  1  1  1  1  1
    X   0  0  1  1  1  1  1
    T   0  0  1  1  2  2  2
    X   0  0  1  1  2  2  2
    A   0  1  1  1  2  3  3
    Y   0  1  1  1  2  3  3
    B   0  1  1  1  2  3  4
*/
    public static int longestCommonSubsequence2(String s1, String s2) {
        StringBuilder sb=new StringBuilder();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i<=s1.length(); i++) {

            for (int j = 1; j <=s2.length(); j++) {
              if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    sb.append(String.valueOf(s1.charAt(i-1)));
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }//end of inner loop
        }//end of loop
        return dp[s1.length()][s2.length()];

    }


   /* Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

    Example 1:
    Input:

            "bbbab"
    Output:
            4
    One possible longest palindromic subsequence is "bbbb".
    Example 2:
    Input:

            "cbbd"
    Output:
            2*/
    public int LongestPalindromicSubsequence(String st) {
        return LPSAux(st, 0, st.length() - 1);
    }// end of method


    private int LPSAux(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex) { //BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
            return 0;
        }
        if (startIndex == endIndex) { //BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
            return 1;
        }
        int count1 = 0;
        if (st.charAt(startIndex) == st.charAt(endIndex)) { //CASE#1 - If index pointed characters matches then we add 2 to the existing known palindrome length
            count1 = 2 + LPSAux(st, startIndex + 1, endIndex - 1);
        }
        int Count2 = LPSAux(st, startIndex + 1, endIndex); //CASE#2 - Skip one element from beginning
        int Count3 = LPSAux(st, startIndex, endIndex - 1); //CASE#3 - Skip one element from end
        return Math.max(count1,Math.max(Count2, Count3));
    }// end of method


    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return lps(s, 0, s.length()-1, dp);
    }
    private int lps(String s, int i, int j, int[][] dp){
        if(i > j)
            return 0;
        if(dp[i][j] != 0)
            return dp[i][j];
        if(i == j)
            dp[i][j] = 1;
        else if(s.charAt(i) == s.charAt(j))
            dp[i][j] =  2+lps(s, i+1, j-1, dp);
        else
            dp[i][j] = Math.max(lps(s, i+1, j, dp), lps(s, i, j-1, dp));
        return dp[i][j];
    }

    private int lps_aux(String string, int startIndex, int endIndex) {
        if (startIndex > endIndex) {//BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
            return 0;
        }
        if (startIndex == endIndex) {//BASE CASE - If both the index are at same position then its a palidrome as its 1 character.
            return 1;
        }
        int c1 = 0;
        if (string.charAt(startIndex) == string.charAt(endIndex)) {  //CASE#1 - If index pointed characters matches then we
            int remainingLength = endIndex - startIndex - 1;	   	 //add 2 to the existing known palindrome length only if
            //remaining string is a palindrome too
            if (remainingLength == lps_aux(string, startIndex + 1, endIndex - 1))
                c1 = remainingLength + 2;
        }
        int c2 = lps_aux(string, startIndex + 1, endIndex);//CASE#2 - Skip one element from beginning
        int c3 = lps_aux(string, startIndex, endIndex - 1);//CASE#3 - Skip one element from end
        return Math.max(c1, Math.max(c2, c3));//Take the max sized palindrome
    }// end of method

    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0;
        int end=0;
        int maxTarget=Integer.MIN_VALUE;
        if(s==null || n<1)
            return "";
        boolean[][] allValues=new boolean[n][n];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i;j<n;j++){
                if(j-i<3 && s.charAt(i)==s.charAt(j)) allValues[i][j]=true;
                else if(s.charAt(i)==s.charAt(j) && allValues[i+1][j-1] ) allValues[i][j]=true;
                if(allValues[i][j] && j-i+1>maxTarget)
                {
                    start =i;
                    end=j;
                    maxTarget=j-i+1;
                }
            }
        }


        return s.substring(start,end+1);
    }
}
