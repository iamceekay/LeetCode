package Concurrency;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Collections;

import static java.lang.Integer.*;

public class TestingOnly {
    int x=5;
    int y=5;
    public static void main(String[] args) {
        int a=1;
        Integer b=1;
        System.out.println(a == b);
        System.out.println(b.compareTo(a));
        System.out.println(LocalDate.of(2019, 31, 12));
    }

    private void print(int i) {
        System.out.println(x+y);
        int y=4;
    }
}
