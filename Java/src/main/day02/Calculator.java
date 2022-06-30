package day02;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int result;
        Scanner scanner = new Scanner(System.in);

        System.out.println("어떤 연산을 하실 건가요? (+,-,*,/)");
        char operator = scanner.next().charAt(0); // 연산자 입력받음

        System.out.println("피 연산자 2수를 입력하세요.");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

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
                System.out.println("올바른 연산자를 입력해주십시오.");
                return;
        }
        System.out.printf("%d %c %d = %d 입니다.", num1, operator, num2, result);
    }
}
