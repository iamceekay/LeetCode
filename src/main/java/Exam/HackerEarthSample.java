package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HackerEarthSample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] NK = br.readLine().split(" ");
            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[N];
            for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
            {
                arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }

           // int out_ = Solution(N, K, arr);
            //System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    }
