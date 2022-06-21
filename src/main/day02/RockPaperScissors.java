package day02;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        int user = 0, computer = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (user == computer) {
            System.out.print("가위(1) 바위(2) 보(3): ");
            user = scanner.nextInt();
            computer = random.nextInt(3) + 1;

            switch (user) {
                case 1:
                    System.out.println("당신은 가위(1)입니다.");
                    break;
                case 2:
                    System.out.println("당신은 바위(2)입니다.");
                    break;
                case 3:
                    System.out.println("당신은 보(3)입니다.");
                    break;
            }
            switch (computer) {
                case 1:
                    System.out.println("컴퓨터는 가위(1)입니다.");
                    break;
                case 2:
                    System.out.println("컴퓨터는 바위(2)입니다.");
                    break;
                case 3:
                    System.out.println("컴퓨터는 보(3)입니다.");
                    break;
            }

            Play(user, computer);

            if (user == computer) {
                System.out.println("비겼습니다. 다시 합니다.");
            }
        }
    }

    static void Play(int user, int computer) {
        if (user > computer) {
            System.out.println("이겼습니다!");
        } else if (user < computer) {
            System.out.println("졌습니다 ㅠㅠ");
        }
    }
}
