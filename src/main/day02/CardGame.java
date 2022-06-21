package day02;

import java.util.Random;

public class CardGame {
    /**
     * 무작위로 카드를 2장을 뽑아서 숫자가 큰 사람이 이김. 단 조커를 뽑으면 그 사람이 무조건 이김
     * 배열로 카드를 만들어서 사용해보기로:
     * 하트, 스페이스, 클로버, 다이아몬드세로: A, 2~10, J, Q, K조커 2개가 존재.무승부가 있을 수 있음(ex: 둘 다 조커)
     */
    public static void main(String[] args) {
        // 1~52
        int[][] card = {
                {1, 2, 3, 4}, // 문양
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13} // 숫자
        };

        int joker = 14; // 53~54
        int[][] player1 = new int[2][2];
        int[][] player2 = new int[2][2];

     //   SelectCard(player1,player2,card,joker);
    }
}
