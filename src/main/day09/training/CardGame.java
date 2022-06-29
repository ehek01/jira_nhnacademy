package day09.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("게임 참여자 수 > ");
        int numHands = s.nextInt();
        System.out.print("참여자 당 카드 수 > ");
        int cardsPerHand = s.nextInt();

        Card.Suit sui2 = Card.Suit.valueOf("SPADES");
        System.out.println("suit: " + sui2.ordinal());

        List<Card> deck = new ArrayList<>();
        Card.Suit[] values = Card.Suit.values();
        for (Card.Suit suit : values) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);

        if (numHands * cardsPerHand > deck.size()) {
            System.out.println("Not enough cards.");
            return;
        }
        for (int i = 0; i < numHands; i++)
            System.out.println(dealHand(deck, cardsPerHand));
    }

    public static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }
}

interface Displayable {
    @Deprecated
    String getDisplay();
}

class Card {
    // LIKE static nested class
    enum Suit implements Displayable {
        SPADES {
            @Override
            int order() {
                return 0;
            }

            @Override
            public String getDisplay() {
                return "♠️";
            }
        },
        DIAMONDS {
            @Override
            int order() {
                return 1;
            }

            @Override
            public String getDisplay() {
                return "💎";
            }
        }, CLUBS() {
            @Override
            int order() {
                return 3;
            }

            @Override
            public String getDisplay() {
                return "♣️";
            }
        }, HEARTS() {
            @Override
            int order() {
                return 4;
            }

            @Override
            public String getDisplay() {
                return "♥️";
            }
        };

        abstract int order();
    }

    enum Rank implements Displayable {
        ACE("ACE"), _2("2"), _3("3"), _4("4"), _5("5"), _6("6"), _7("7"), _8("8"), _9("9"), _10("10"),
        JACK("Jack"), QUEEN("Queen"), KING("King"),
        ;

        private final String display;

        Rank(String display) {
            this.display = display;
        }

        @Override
        public String getDisplay() {
            return display;
        }
    }

    @SuppressWarnings("FieldMayBeFinal")
    private Suit suit;
    @SuppressWarnings("FieldMayBeFinal")
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return suit.getDisplay() + rank.getDisplay();
    }
}
