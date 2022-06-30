package day02;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
        double[] heart = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        double[] diamond = {2.1, 3.1, 4.1, 5.1, 6.1, 7.1, 8.1, 9.1, 10.1, 11.1, 12.1, 13.1, 14.1};
        double[] clover = {2.2, 3.2, 4.2, 5.2, 6.2, 7.2, 8.2, 9.2, 10.2, 12.2, 12.2, 13.2, 14.2};
        double[] spade = {2.3, 3.3, 4.3, 5.3, 6.3, 7.3, 8.3, 9.3, 10.3, 13.3, 13.3, 13.3, 14.3};
        double[] joker = {100, 100};
        double[] player = new double[2];
        double[] computer = new double[2];

        do {
            double[][] cards = {heart, diamond, clover, spade, joker};
            playerGetCards(cards, player);
            playerGetCards(cards, computer);
        } while (isPlayerWinner(player, computer).equals("draw"));
    }

    private static void playerGetCards(double[][] cards, double[] player) {
        for (int i = 0; i < player.length; i++) {
            player[i] = getCard(cards);
        }
    }

    private static double getCard(double[][] cards) {
        Random percent = new Random();
        if (isGettalbeJoker()) {
            double joker1 = cards[4][0];
            double joker2 = cards[4][1];
            if (joker1 != 0) {
                cards[4][0] = 0;
                return joker1;
            } else if (joker2 != 0) {
                cards[4][1] = 0;
                return joker2;
            }
        }
        int head = percent.nextInt(4);
        int card = percent.nextInt(13);
        double selectedCard = cards[head][card];
        if (selectedCard == 0) {
            return getCard(cards);
        } else {
            cards[head][card] = 0;
        }
        return selectedCard;
    }

    private static boolean isGettalbeJoker() {
        Random random = new Random();
        int percent = random.nextInt(54);
        return percent == 52 || percent == 53;
    }

    private static String isPlayerWinner(double[] player, double[] computer) {
        double result = 0;
        for (int i = 0; i < player.length; i++) {
            result = player[i] - computer[i];
        }
        seePlayersCards(player, true);
        seePlayersCards(computer, false);
        if (result < 0) {
            System.out.println("컴퓨터 승리");
            return "computer";
        }
        if (result > 0) {
            System.out.println("사용자 승리");
            return "player";
        }
        return "draw";
    }

    private static void seePlayersCards(double[] player, boolean isPlayer) {
        String name = isPlayer ? "사용자" : "컴퓨터";
        System.out.print(name + " : " );
        for (double v : player) {
            System.out.print(getCardRank(v) + "  ");
        }
        System.out.println();
    }

    private static String getCardRank(double card) {
        double factorialPart = (int) card - card;

        if (card == 100) {
            return "JOKER";
        }

        String cardNumber = getCardNumber(card);
        if (factorialPart == 0) {
            return "♥" + cardNumber;
        } else if (factorialPart == 1) {
            return "♦" + cardNumber;
        } else if (factorialPart == 2) {
            return "♣" + cardNumber;
        } else {
            return "♠" + cardNumber;
        }
    }

    private static String getCardNumber(double card) {
        switch ((int) card) {
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
                return "A";
        }
        return null;
    }
}
