package Exam;

import java.util.*;


class Main {
    public static void main(String[] args) throws java.lang.Exception {
       /* *//*Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            if(a==42) break;
            System.out.println(a);*//*
        // int[] a=new int[]{ 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        //kthsmallest(a,9);
        solve(new ArrayList<>(Arrays.asList(-1, -2, -3, 4, 5 )));
       // solve(new int[]{285, 223, 327, 320, 107, 127, 266, 277, 324, 282, 322, 260, 257, 87, 288, 321, 269, 86, 69, 206, 66, 165, 160, 67, 316, 216, 161, 118, 330, 337, 274, 145, 256, 318, 250, 187, 273, 68, 105, 193, 314, 137, 77, 336, 287, 120, 334, 278, 281, 279, 289, 299, 291, 307, 190, 212, 286, 113, 227, 226, 301, 300, 174, 270, 123, 317, 275, 338, 202, 205, 70, 101, 344, 271, 102, 312, 157, 224, 201, 106, 88, 292, 305, 343, 246, 328, 138, 148, 315, 254, 108, 229, 346, 350, 255, 304, 247, 302, 208, 85, 158, 63, 225, 147, 172, 64, 78, 89, 258, 109, 323, 237, 80, 191, 110, 283, 83, 221, 296, 111, 72, 71, 155, 140, 95, 252, 126, 90, 91, 114, 228, 163, 303, 197, 162, 248, 75, 339, 116, 92, 209, 198, 139, 112, 276, 143, 306, 319, 180, 173, 325, 184, 335, 326, 156, 240, 293, 115, 261, 340, 290, 351, 58, 117, 341, 241, 329, 311, 119, 232, 121, 192, 135, 308, 213, 182, 313, 253, 146, 103, 214, 124, 331, 332, 230, 349, 194, 333, 259, 211, 284, 294, 342, 166, 309, 195, 73, 264, 164, 233, 98, 345, 74, 136, 239, 122, 231, 167, 175, 183, 93, 125, 84, 263, 200, 347, 132, 295, 128, 129, 177, 130, 280, 94, 234, 168, 297, 141, 104, 142, 207, 262, 131, 298, 144, 76, 154, 310, 57, 348, 59, 60, 265, 152, 61, 153, 62, 236, 65, 242, 235, 79, 176, 149, 133, 81, 82, 96, 169, 97, 210, 170, 99, 268, 151, 100, 251, 134, 150, 267, 159, 171, 272, 178, 196, 179, 203, 181, 185, 186, 188, 189, 199, 243, 204, 215, 217, 218, 238, 219, 220, 222, 244, 245, 249});
            // Creating empty priority queue
            PriorityQueue<Integer> pQueue = new PriorityQueue<>();

            // Adding items to the pQueue using add()
            pQueue.add(10);

            pQueue.add(20);

            pQueue.add(15);

        pQueue.add(5);

        pQueue.add(12);
        System.out.println("Queue---------");
        while(pQueue.size()>0)
        {
            System.out.println(pQueue.poll());
        }
        System.out.println("Queue End---------");*/

        for(int i = 1; i < 15; i *= 2)
        {
            System.out.println(i);
        }
        for(int i = 15; i > -1; i /= 2)
        {
            System.out.println("----"+i);
        }
      // minimizeString("abaacbac");
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int a : nums)
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        for (int a : hm.keySet())
            if (hm.get(a) == 1) return a;
        return -1;

    }

    public static int kthsmallest(final int[] A, int B) {
        int counter = 0;
        TreeSet<Integer> hs = new TreeSet<>();
        for (int a : A)
            hs.add(a);
        for (int a : hs) {
            counter++;
            if (counter == B) return a;
        }
        System.out.println(hs);
        return -1;
    }

    public static int solve(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
            sum += A[i];
        }
        System.out.println("min" + min);
        System.out.println("max" + max);
        System.out.println("sum" + sum);
        int maxSum = max * (max + 1);
        maxSum = maxSum / 2;
        int minSum = min * (min - 1);
        minSum = minSum / 2;
        System.out.println(maxSum - minSum);
        return maxSum - minSum == sum ? 1 : 0;
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> negative = new ArrayList<Integer>();
        ArrayList<Integer> positive = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int a : A) {
            if (a < 0) negative.add(a);
            else positive.add(a);
        }
        System.out.println(positive);
        System.out.println(negative);
        int i = 0, j = 0;
        while (i < negative.size() || j < positive.size()) {
            if (i < negative.size())
                result.add(negative.get(i++));
            if (j < positive.size())
                result.add(positive.get(j++));
        }
        System.out.println(result);
        return result;
    }
    //-abaacbac
    //bCount=2
    //a
    //aa
    //aaa
    //aaabbc
    //aaabbca
    //aaabbcac

    //----
    // a b a b b a a b
    // bcount=4
    //a
    //aa
    //aaa
    //aaaa
    //aaaabbbb
    static String minimizeString(String s) {
        char[] str=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int n=s.length();
            int bCount = 0;
            for (int i = 0; i < n; i++)
                if (str[i] == 'b')
                    bCount++;
            boolean bval = false;
            for (int i = 0; i < n; i++)
            {
                if (str[i] == 'c' && !bval)
                {
                    bval = true;
                    for (int j = 0; j < bCount; j++)
                        sb.append("b");
                }
                if (str[i] != 'b')
                    sb.append(str[i]);

            }
            if (!bval)
                for (int j = 0; j < bCount; j++)
                    sb.append("b");
        return sb.toString();
        }

    }

