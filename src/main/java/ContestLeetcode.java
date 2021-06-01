import java.util.*;

public class ContestLeetcode {
    public static void main(String[] args) {
        // System.out.println(threeSum(new int[]{1, 3, 5, 7, 6, 11,13,15}));
        // System.out.println("        hello         ");
       System.out.println(countGoodSubstrings1("aababcabc"));
        System.out.println(minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }

    private static int countGoodSubstrings1(String s) {
        int count=0;
        for(int i=0;i<=s.length()-3;i++)
        {
            if(s.charAt(i)!=s.charAt(i+1) && s.charAt(i+1)!= s.charAt(i
                    +2) && s.charAt(i)!=s.charAt(i+2)) count++;
        }
        return count;
    }

    public static int countGoodSubstrings(String s) {
        int k=3,count=0;
        for(int i=0;i<=s.length()-k;i++)
            if(countChar(s.substring(i,i+k))) count++;

        return count;

    }
    public static boolean countChar(String s){
        HashSet<Character> hs= new HashSet<>();
        for(char c:s.toCharArray())
        {
            if(hs.contains(c)) return false;
            else hs.add(c);
        }
        return true;
    }
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        int i=0,j=nums.length-1;
        while(i<j)
        {
            max= Math.max(max,nums[i++]+nums[j--]);
        }
        return max;

    }


    private static List<List<Integer>>  threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int target=30-nums[i]-nums[j];
                if(hs.contains(target))
                {
                    List<Integer> ls=Arrays.asList(nums[i],nums[j],target);
                    Collections.sort(ls);
                    res.add(ls);
                }

            }
            hs.add(nums[i]);
        }
        return new ArrayList<>(res);
    }
}
