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

    }

    private static void viewCard(Card[] cards, int playerNo) {
        for (Card card : cards) {
            System.out.println("player" + playerNo + " : " + card);
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

        player1[0] = cards[randomCount[0]];
        player1[1] = cards[randomCount[1]];
        player2[0] = cards[randomCount[2]];
        player2[1] = cards[randomCount[3]];
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