package Exam.Concurrency;

import lombok.Data;

@Data
public class Check {
    Integer in;
    String string;

    public Check(int i, String string) {
    }
}
@Data
class checkNew extends Check{
    String in;

    public checkNew(int i, String string) {
        super(i, string);
    }

    public static void main(String[] args) {
        checkNew a = (checkNew) new Check(1, "String");
    }
}
