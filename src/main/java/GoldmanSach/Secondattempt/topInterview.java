package GoldmanSach.Secondattempt;


import java.util.*;

public class topInterview {
    public static void main(String[] args) {

    }
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, List<Integer>> hm = new TreeMap<>();
        for (int[] item : items) {
            if (!hm.containsKey(item[0]))
                hm.put(item[0], new ArrayList<Integer>());
            hm.get(item[0]).add(item[1]);
        }
        int[][] result = new int[hm.size()][2];
        int resCounter = 0;
        for (int a : hm.keySet()) {
            List<Integer> val = hm.get(a);
            Collections.sort(val);
            Collections.reverse(val);
            int lengthList = val.size() > 5 ? 5 : val.size();
            int sum = 0;
            for (int i = 0; i < lengthList; i++) {
                sum += val.get(i);
            }
            int res = sum / lengthList;
            result[resCounter][0] = a;
            result[resCounter++][1] = res;

        }
        return result;
    }
    public int[][] highFivepq(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> hm= new TreeMap<>();
        for(int[] a:items)
        {
            if(!hm.containsKey(a[0]))
            {
                hm.put(a[0],new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq=hm.get(a[0]);
            pq.add(a[1]);
            if(pq.size()>5)
                pq.poll();
        }
        int[][] res=new int[hm.size()][2];
        int start=0;
        for(int a:hm.keySet())
        {
            PriorityQueue<Integer> pq= hm.get(a);
            int length=pq.size();
            int sum=0;
            while(pq.size()>0)
                sum+=pq.poll();
            sum=sum/length;
            res[start][0]=a;
            res[start++][1]=sum;


        }
        return res;


    }
    public int trap(int[] height) {
        int h=height.length;
        int a=0;
        int b=h;
        int leftMax=0,rightmax=0,sum=0;
        while(a<=b)
        {
            leftMax=Math.max(leftMax,height[a]);
            rightmax=Math.max(rightmax,height[b]);
            if(leftMax<rightmax)
                sum+=leftMax-height[a++];
            else sum+=rightmax-height[b--];

        }
        return sum;
    }
    //s = 7, nums = [2,3,1,2,4,3]
    public int minSubArrayLen(int s, int[] a) {
        int start=0;
        int second=0;
        int end=a.length;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(start<end)
        {
            sum+=a[start++];
            while(sum>=s)
            {
                min=Math.min(min,start-second);
                sum-=a[second++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res=0.0;
        ArrayList<Integer> list=   new ArrayList<>();
        for(int num:nums1)
            list.add(num);
        for(int num:nums2)
            list.add(num);
        Collections.sort(list);
        int size=list.size();
        if(size%2==0) {
            res = list.get(size / 2) + list.get((size / 2) - 1);
            res = res / 2;
        }
        else
        res=list.get(size/2);
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int max=0;
        if(heights.length==1) return heights[0];
        for(int i=0;i<heights.length;i++)
        {
            int min=Integer.MAX_VALUE;
            min=Math.min(min,heights[i]);
            for(int j=i;j<heights.length;j++)
            {
                min=Math.min(min,heights[j]);
                max=Math.max(max,(j-i+1)*min);

            }
        }
        return max;

    }
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hm=  new HashMap<Character,Integer>();
        int i=0;
        for(char c:s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(char c:s.toCharArray())
        {
            if(hm.get(c)==1) return i;
            i++;
        }
        return -1;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=  new HashMap<>();
        for(String str:strs)
        {
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String res=arr.toString();
            if(hm.containsKey(res))
            {
                hm.get(res).add(str);
            }
            else
            {
                List<String> list=  new ArrayList<String>();
                list.add(str);
                hm.put(res,list);
            }
        }
        return new ArrayList<List<String>>(hm.values());
    }
}
