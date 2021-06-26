
import java.util.Arrays;

public class ProductTwoNumber {
    public static void main(String[] args) {
        byte[] array=null;
        System.out.println(array.length);
    }

    private static void productTwoNumber(int[] array1, int[] array2) {
        int m = array1.length, n = array2.length;
        StringBuilder sb = new StringBuilder();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) // i=1
        {
            for (int j = n - 1; j >= 0; j--) //j=0
            {
                int mul = array1[i] * array2[j]; // 10
                int p1 = i + j;    //1
                int p2 = i + j + 1;  //2
                result[p1] += mul / 10; //result[0,0,1,4]
                result[p2] += mul % 10; //[ 0 0 1 4int mul=array1[i]*array2[j]; // 10

            }

        }
        for(int a:result)
        {
            boolean checkZero=true;
            if(a==0 && checkZero)
            continue;
            else
            {
                sb.append(a);
                checkZero=false;
            }
        }
        System.out.println(sb.toString());
    }
}
