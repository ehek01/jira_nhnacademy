package day02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3]; // 판 배열 모든 메소드에서 참조 가능하도록 정적 변수로 선언.

    public static void main(String[] args) {
        // 알 초기화
        Arrays.stream(board).forEach(chars -> Arrays.fill(chars, ' '));
        startGame();
    }

    private static void startGame() {
        while (true) {
            if (playUser(board)) {
                System.out.println("user win !!");
                break;
            }
            if (playComputer()) {
                System.out.println("computer win!!");
                break;
            }
        }
    }

    private static boolean playComputer() {
        Random ran = new Random();
        int comX, comY;

        System.out.println("컴퓨터 턴");

        while (true) {
            comX = ran.nextInt(3);
            comY = ran.nextInt(3);

            if (board[comX][comY] == ' ') {
                board[comX][comY] = 'X';
                drawBoard(board);
                return winCheck(board);
            }
        }
    }

    private static boolean playUser(char[][] board) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("사용자 턴(x,y): ");

            int userX = scanner.nextInt();
            int userY = scanner.nextInt();

            if (board[userX][userY] == ' ') {
                board[userX][userY] = 'O';
                drawBoard(board);
                return winCheck(board);
            }

            System.out.println("이미 놓여있는 자리입니다. 다시 놓아주세요.");
        }
    }

    private static boolean winCheck(char[][] board) {
        int userRowCount = 0, comRowCount = 0;
        int userColumnCount = 0, comColumnCount = 0;

        for (int i = 0; i <= 2; i++) {
            // 가로, 세로
            for (int j = 0; j <= 2; j++) {
                if (board[i][j] == 'O') {
                    userRowCount++;
                } else if (board[i][j] == 'X') {
                    comRowCount++;
                }
                if (board[j][i] == 'O') {
                    userColumnCount++;
                } else if (board[j][i] == 'X') {
                    comColumnCount++;
                }
            }
            if (userRowCount == 3 || userColumnCount == 3 ||
                    comRowCount == 3 || comColumnCount == 3) return true;
            userRowCount = 0; userColumnCount = 0; comRowCount = 0; comColumnCount = 0;
        }
        return false;
    }

    static void drawBoard(char[][] board) {
        // 바둑판
        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }
}
