package day02;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userCount, diceCount;

        System.out.println("참가자 수를 입력하세요.");
        userCount = scanner.nextInt();
        System.out.println("사용하실 주사위 갯수를 입력하세요.");
        diceCount = scanner.nextInt();

        int[] userDiceSum = new int[userCount]; // 유저가 돌린 주사위값을 전부 합산할 배열

        PlayGame(userDiceSum,diceCount,userCount);
    }
    static void PlayGame(int[] userDiceSum, int diceCount, int userCount) {
        int winnerDice;
        int winner = 0;
        int drawCount =0;
        Random random = new Random();
        System.out.println("주사위를 굴렸습니다.");

        // 주사위 굴리는 작업
        // user 수당 dice 갯수만큼(2중 for 문)
        for (int i = 0; i < userCount ; i++) {
            for (int j = 0; j < diceCount; j++) {
                userDiceSum[i] += random.nextInt(6)+1;
            }
        }

        winnerDice = userDiceSum[0]; // 첫번째 주사위로 초기값을 설정해주고, 비교해서 바꿔나감.

        // 주사위합산 값 비교
        for (int i = 0; i < userCount; i++) {
            if(userDiceSum[i] > winnerDice) {
                winnerDice = userDiceSum[i];
                winner = i;
            }
            System.out.printf("user%d의 결과값은 %d 입니다.%n", i+1, userDiceSum[i]);
        }

        if (drawCheck(userDiceSum, winner)) {
            System.out.println("무승부 입니다.");
            return;
        }
        System.out.printf("승리자는 user%d 입니다!!", winner+1);
    }

    private static boolean drawCheck(int[] userDiceSum, int winner) {
        for (int i = 0; i < userDiceSum.length; i++) {
            if (i != winner && userDiceSum[winner] == userDiceSum[i]) {
                return true;
            }
        }
        return false;
    }
}
