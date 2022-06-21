package day02;

import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            lotto[i] = random.nextInt(45) + 1;

            // 로또배열에 들어가있는 숫자들과 이번에 들어온 숫자를 비교해서 같은수가 있다면,
            // i값을 감소시킴으로써 해당 배열자리에 새 숫자를 할당할 수 있도록 i값을 감소시켰다.
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                }
            }
        }

        for (int param : lotto) {
            System.out.print(param + " ");
        }
    }
}
