package day01;

import java.util.Scanner;

public class NameCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input name: ");
        String name = scanner.nextLine();
        System.out.print("input email: ");
        String email = scanner.nextLine();
        System.out.print("input mobile: ");
        String mobile = scanner.nextLine();

        System.out.println("OK");
        System.out.printf("  name:%20s%n", name);
        System.out.printf(" email:%20s%n", email);
        System.out.printf("mobile:%20s%n", mobile);
    }
}
