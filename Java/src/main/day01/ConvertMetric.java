package day01;

import java.util.Scanner;

public class ConvertMetric {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("cm으로 변경할 inch를 입력하세요.");
        int inch = scanner.nextInt();
        System.out.printf("%d inch는 %.2f cm입니다.%n", inch, inch * 2.54f);

        System.out.println("inch로 변경할 cm를 입력하세요.");
        int cm = scanner.nextInt();
        System.out.printf("%d cm는 %.2f inch입니다.%n", cm, cm / 2.54f);
    }
}
