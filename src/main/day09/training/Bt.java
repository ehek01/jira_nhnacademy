package day09.training;

import java.util.List;

public class Bt {
    public static double sumInts(List<Integer> numberlist) {
        double sum = 0.0;
        for (Number n : numberlist)
            sum += n.doubleValue();
        return sum;
    }
    public static double sumDoubles(List<Double> numberlist) {
        double sum = 0.0;
        for (Number n : numberlist)
            sum += n.doubleValue();
        return sum;
    }

    public static double sumNumbers(List<? extends Number> numberlist) {
        double sum = 0.0;
        for (Number n : numberlist)
            sum += n.doubleValue();
        return sum;
    }

    public static <T extends Number> double sumNumbers2(List<T> numberlist) {
        double sum = 0.0;
        for (Number n : numberlist)
            sum += n.doubleValue();
        return sum;
    }

    public static void main(String args[]) {
        List<Integer> integerList = List.of(1, 2, 3);
        System.out.println("sum = " + sumNumbers(integerList));

        List<Double> doubleList = List.of(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumNumbers2(doubleList));
    }
}
