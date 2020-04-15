package GoldmanSach;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass2 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] array = new int[a];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
        }

        int b = s.nextInt();
        for (int i = 1; i <= b; i++) {
            String caseVal = s.next();
            switch (caseVal) {
                case "Increment": {

                    int inc = s.nextInt();
                    array[inc - 1]++;
                    break;
                }
                case "Update": {
                    int inc = s.nextInt();
                    int val = s.nextInt();
                    array[inc - 1] = val;
                    break;
                }
                case "Left": {
                    leftRotate(array);
                    break;
                    //leftRotate(array,1);

                }
                case "Right": {

                    // rightRotate(array);
                    rotate(array, 1);
                    break;

                }
                case "?": {

                    int inc = s.nextInt();
                    System.out.println(array[inc - 1]);
                    break;
                }
                default: {
                    System.out.println("No Value");
                }
            }
        }
    }

        public static void leftRotate(int inputArray[])
        {
            int temp = inputArray[0];

            for (int j = 0; j < inputArray.length-1; j++)
            {
                inputArray[j] = inputArray[j+1];
            }

            inputArray[inputArray.length - 1] = temp;

        }
        public  static void rightRotate(int[] inputArray)
        {
            int temp = inputArray[inputArray.length-1];

            for (int j = inputArray.length-1; j > 0; j--)
            {
                inputArray[j] = inputArray[j-1];
            }

            inputArray[0] = temp;

        }
        public static void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public static void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        static void leftRotate(int arr[],int k)
        {

            int n=arr.length;
            int mod = k % n;
            int[]temp=new int[arr.length];
            for(int i = 0; i < n; ++i)
                temp[i]=arr[(i + mod) % n];
            arr=Arrays.copyOf(temp,n);
        }
    }
