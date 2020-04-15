package GoldmanSach;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
      /*int[] arr=new int[]{1,2,3,4,5};
        leftRotate(arr);
        rightRotate(arr);
        char set[] = {'1', '2', '3','4','5'};*/
        System.out.println(1%12);
        System.out.println(1%10);
       // printSubsets(set);

        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");
        */// Writing output to STDOUT

        //Scanner
        //----------------
       /* Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] array = new int[a];
        for (int i = 0; i< array.length; i++) {
                array[i] = s.nextInt();
        }

        int b = s.nextInt();
        for(int i=1;i<=b;i++)
        {
            String caseVal=s.next();
            if(caseVal.equals("Increment"))
            {

                int inc=s.nextInt();
                array[inc-1]++;
            }
            else if(caseVal.equals("Update"))
            {
                int inc=s.nextInt();
                int val=s.nextInt();
                array[inc-1]=val;
            }
            else if(caseVal.equals("Left"))
            {
                leftRotate(array);

            }
            else if(caseVal.equals("Right"))
            {

                rightRotate(array);

            }
            else if(caseVal.equals("?"))
            {

                int inc=s.nextInt();
                System.out.println(array[inc-1]);
            }
        }*/

       // -----------
       /* for(int i=0;i<a;i++)
        {
            String temp= array[i];
            System.out.println(temp);
            if(temp!=null && temp.matches("[0-9]+"))
            {
                System.out.println("Valid Format");

            }
            else if(temp!=null && temp.matches("[a-zA-Z]*$"))
            {
                System.out.println("Its a String");
            }
            else
            {
                System.out.println("Its an AlphaNumeric");
            }
        }// Reading input from STDIN
        // Writing output to STDOUT



        // Write your code here

    }*/
    }

    private static int findMax(int[] arr) {
        int b[]=new int[arr.length];
        b=Arrays.copyOf(arr,arr.length);
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(i<arr.length-1 && b[i]>b[i+1])
            {
                while (b[i]>b[i+1])
                {
                    b[i]--;
                }

            }
            sum+=b[i];
            b[i]=arr[i];

        }
        return sum;
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
        System.out.println(Arrays.toString(inputArray));
    }

    public static void printSubsets(char set[])
    {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }
    static void leftRotate(int arr[],
                           int k)
    {
        /* To get the starting point of
        rotated array */
        int n=arr.length;
        int mod = k % n;
        int[]temp=new int[arr.length];
        // Prints the rotated array from
        // start position
        for(int i = 0; i < n; ++i)
            temp[i]=arr[(i + mod) % n];
        arr=Arrays.copyOf(temp,n);
    }
}
