package day01;

import java.util.Scanner;

public class UniCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input: ");

        if (scanner.hasNext()) {
            char result = scanner.next().charAt(0);
            System.out.println("\\u" + Integer.toHexString(result));
        }
    }
}
