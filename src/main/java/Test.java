import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
       Character c='Z';
        //System.out.println( % 9);
        rotationalCipher("Zebra-493?",3);

    }
    static  String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder sb=new StringBuilder();
        for(char c:input.toCharArray())
        {
            if(Character.isLetter(c) && Character.isUpperCase(c))
            {
                char newC=(char) ((c-'A'+rotationFactor)%26+'A');
                sb.append(newC);
            }
            else if(Character.isLetter(c) && Character.isLowerCase(c))
            {
                char newC=(char) ((c-'a'+rotationFactor)%26+'a');
                sb.append(newC);
            }
            else if(Character.isDigit(c))
            {
                int newC=(Integer.valueOf(c+"")+rotationFactor)%10;
                sb.append(newC);
            }
            else
            {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
