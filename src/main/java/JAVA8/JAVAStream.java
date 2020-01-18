package JAVA8;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JAVAStream {
    public static void main(String[] args) {
        IntStream.range(1,14).forEach(System.out::println);
        IntStream.range(1,14).skip(5).forEach(x->System.out.println(x));
        Stream.of("Nehh","he","hii").sorted((s1,s2)->Integer.compare(s1.length(),s2.length())).forEach(System.out::println);
        System.out.println();
    }
}
