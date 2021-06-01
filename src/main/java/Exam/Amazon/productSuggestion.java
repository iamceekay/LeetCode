package Exam.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class productSuggestion {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            List<List<String>> result=new ArrayList<>();
            for(int i=1;i<=searchWord.length();i++)
            {
                ArrayList<String> list= new ArrayList<>();
                for(String prod:products)
                {
                    if(prod.length()>=i){
                        String temp=searchWord.substring(0,i) ;
                        String tempV= prod.substring(0,i);
                        if(tempV.equals(temp) && list.size()<3){
                            list.add(prod);
                        }
                    }
                }
                result.add(list);
            }
            return result;

        }
}
