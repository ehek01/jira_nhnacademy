package day03;

import java.util.Random;

class Card {
    private final Suit suit;
    private final Number number;

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit.display + number.value;
    }

    public Number getNumber() {
        return number;
    }

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    public static Card joker() {
        return new Card(new Suit("J",5), new Number(14));
    }
}

// spades, hearts, diamonds, clubs
class Suit {
    String display;
    int order;

    public Suit(String display, int order) {
        this.display = display;
        this.order = order;
    }
}

// Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King.
class Number {
    int value;

    public Number(int value) {
        this.value = value;
    }
}

class CardGame {
    public static void main(String[] args) {
        Card[] cards = new Card[52];
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];

        initCard(cards);

        selectCard(player1, player2, cards);

        viewCard(player1, 1);
        viewCard(player2, 2);

        System.out.println("-----------------------");

        getWinner(player1, player2);
    }

    private static void getWinner(Card[] player1, Card[] player2) {
        Card player1BigCard = choiceBigCard(player1[0], player1[1]);
        Card player2BigCard = choiceBigCard(player2[0], player2[1]);

        // 무승부가 나올 경우는 둘다 조커가 나올때 밖에 존재하지 않는다.
        if (player1BigCard.getNumber() == Card.joker().getNumber() &&
                player2BigCard.getNumber() == Card.joker().getNumber()) {
            System.out.println("둘다 조커가 나와서 무승부 입니다.");
        }

        if (choiceBigCard(player1BigCard, player2BigCard) == player1BigCard) {
            System.out.println("player1 win !!");
        } else if (choiceBigCard(player1BigCard, player2BigCard) == player2BigCard) {
            System.out.println("player2 win !!");
        }
    }

    private static Card choiceBigCard(Card card1, Card card2) {
        if (card1.getNumber().value > card2.getNumber().value) {
            return card1;
        } else if (card1.getNumber().value < card2.getNumber().value) {
            return card2;
        }

        if (card1.getSuit().order > card2.getSuit().order) {
            return card1;
        }

        return card2;
    }

    private static void viewCard(Card[] cards, int playerNo) {
        for (Card card : cards) {
            System.out.println("player" + playerNo + " card : " + card);
        }
    }

    private static void selectCard(Card[] player1, Card[] player2, Card[] cards) {
        Random random = new Random();
        int[] randomCount = new int[4];



        for (int i = 0; i < 4; i++) {
            randomCount[i] = random.nextInt(cards.length);
            // 중복체크
            for (int j = 0; j < i; j++) {
                if (randomCount[i] == randomCount[j]) {
                    i--;
                }
            }
        }

        if (isJoker()) {
            player1[0] = Card.joker();
            player1[1] = new Card(null, new Number(1));
        } else {
            player1[0] = cards[randomCount[0]];
            player1[1] = cards[randomCount[1]];
        }

        if (isJoker()) {
            player2[0] = Card.joker();
            player2[1] = new Card(null, new Number(1));
        } else {
            player2[0] = cards[randomCount[2]];
            player2[1] = cards[randomCount[3]];
        }


    }

    private static boolean isJoker() {
        Random random = new Random();
        int percent = random.nextInt(54);
        return percent == 52 || percent == 53;
    }

    private static void initCard(Card[] cards) {
        int count = 0;
        Suit[] suits = {
                new Suit("♠",1),
                new Suit("♦",2),
                new Suit("♥",3),
                new Suit("♣",4),
        };
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                cards[count] = new Card(suits[i], new Number(j));
                count++;
            }
        }
    }
}