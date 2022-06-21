package day02;

import java.util.Scanner;

public class Accumulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;
        char operator;

        while (true) {
            System.out.println("어떤 연산을 하실건가요? (+,-,*,/)");
            operator = scanner.next().charAt(0); // 연산자 입력받음
            System.out.println("수를 입력하세요.");
            num1 = scanner.nextInt();
            num2 = scanner.nextInt();
            System.out.printf("%d %c %d = %d입니다.%n", num1, operator, num2, Calculate(num1, num2, operator));
        }
    }

    static int Calculate(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }

        return result;
    }
}
