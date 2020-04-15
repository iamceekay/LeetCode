package LeetCodePattern;

import java.util.*;
import java.io.*;

public class Sing {
    public static void main(String [] args) {
        // note:
        // this is just an example on how our system
        // takes input and output and automate the process
        // of marking this submission
        try {
            Scanner scan = new Scanner(System.in);

            // check if there is any more line
            if (scan.hasNextLine()) {
                // here's how you read the next line
                String string = scan.nextLine();
                ArrayList<String> arrList= new ArrayList<>();
                for(int k=0;k<Integer.parseInt(string);k++) {
                    arrList.add(scan.nextLine());
                }
                   for(String row:arrList){
                    int sum=0;
                    char[] rowCharArray=row.toCharArray();
                    for(int j=0;j<11;j++)
                    {
                        int temp=Integer.parseInt(String.valueOf(rowCharArray[j]));
                        if(j==1 || j==5 || j==9)

                            sum+=temp*3;

                        else if(j==2 || j==6)

                            sum+=temp*7;

                        else if(j==3 || j==7)

                            sum+=temp*9;

                        else sum+=temp;



                    }
                    if(sum%10==0) System.out.println("Y");
                    else System.out.println("N");
                }

                // here's how you output the result

            }

        } catch (Exception e) {
        }
    }
}