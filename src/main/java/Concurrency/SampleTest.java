package Concurrency;



import java.util.stream.Stream;

public class SampleTest {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7)
                .skip(5)
                .forEach(num->System.out.print(num + " "));
    }
}