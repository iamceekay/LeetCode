package Concurrency;

import java.io.*;
import java.util.*;


class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String str = br.readLine();

        String out_ = modifyString(N, str);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static String modifyString(int N, String str){

        int a[]=new int[str.length()];
        int j=0;
        for(char c: str.toCharArray()){
            a[j++]=(int)c;
        }
        List<Integer> prime=new ArrayList<>();
        List<Integer> composite=new ArrayList<>();
        for(int i: a){
            if(checkprime(i)){
                prime.add(i);
            }else{
                composite.add(i);
            }
        }
        Collections.sort(prime);
        Collections.sort(composite);
        String st="";
        for(int i: prime){
            st+=(char)i;
        }

        StringBuilder sb=new StringBuilder();
        for(int i: composite){
            sb.append((char)i);
        }

        return st+sb.reverse().toString();


    }
    static boolean checkprime(int i){
        for(int x=2;x<i/2;x++){
            if(i%x==0){
                return false;
            }
        }
        return true;
    }
}
