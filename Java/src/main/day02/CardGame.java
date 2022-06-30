package day02;

import java.util.Random;

public class CardGame {
    public static void main(String[] args) {
        int[][] player1 = new int[2][2];
        int[][] player2 = new int[2][2];

        for (int i = 0; i < 2; i++) {
            player1[i] = selectCard();
            player2[i] = selectCard();

            // p1 카드와 p2카드 비교
            if (isDuplication(player1[i], player2[i])) {
                i--;
                continue;
            }
            // 첫번째 카드와 두번째 카드비교
            if (i == 1 && (isDuplication(player1[i], player1[i - 1]) || isDuplication(player2[i], player2[i - 1]))) {
                i--;
            }
        }


        viewCard(player1, 1);
        viewCard(player2, 2);

        System.out.println("---------------------------------");

        getWinner(player1, player2);
    }

    private static void viewCard(int[][] player1, int playerNo) {
        for (int i = 0; i < 2; i++) {
            System.out.println(playerNo + "번 플레이어 : " + getCardSuit(player1[i][0]) + getCardNumber(player1[i][1]));
        }
    }

    private static String getCardNumber(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "A";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "Joker";
        }
        return null;
    }

    private static String getCardSuit(int suitNumber) {
        switch (suitNumber) {
            case 1 :
                return "♥";
            case 2 :
                return "♦";
            case 3 :
                return "♣";
            case 4 :
                return "♠";
        }

        return "";
    }

    private static boolean isDuplication(int[] player1Card, int[] player2Card) {
        return player1Card == player2Card;
    }

    private static int[] selectCard() {
        Random random = new Random();
        int[] card = new int[2];

        if (isJoker()) {
            card[1] = 14;
            return card;
        }

        card[0] = random.nextInt(4) + 1;
        card[1] = random.nextInt(13) + 1;

        return card;
    }

    private static void getWinner(int[][] player1, int[][] player2) {
        int[] player1Card;
        int[] player2Card;

        player1Card = choiceBigCard(player1[0], player1[1]);
        player2Card = choiceBigCard(player2[0], player2[1]);

        System.out.println("1번 플레이어가 고른 카드 : " + getCardSuit(player1Card[0]) + getCardNumber(player1Card[1]));
        System.out.println("2번 플레이어가 고른 카드 : " + getCardSuit(player2Card[0]) + getCardNumber(player2Card[1]));

        System.out.println("-----------------------------------");

        if (choiceBigCard(player1Card, player2Card) == player1Card) {
            System.out.println("1번 플레이어 승리 !!");
            return;
        }

        System.out.println("2번 플레이어 승리 !!");
    }

    private static int[] choiceBigCard(int[] card1, int[] card2) {
        if (card1[1] > card2[1]) {
            return card1;
        } else if (card1[1] < card2[1]) {
            return card2;
        }

        // 숫자가 같을경우 (문양비교)
        if (card1[0] > card2[0]) {
            return card1;
        }

        return card2;
    }

    private static boolean isJoker() {
        Random random = new Random();
        int percent = random.nextInt(54);
        return percent == 52 || percent == 53;
    }
}
