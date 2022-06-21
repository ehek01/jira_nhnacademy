package day01;

public class Swap {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("a: " + a + ", b: " + b);

        a = a+b; // 합산 값 저장
        b = a-b; // 합산값에 기존 b값을 뺀 값을 넣으면 기존 a값이 들어간다
        a = a-b; // b 값에는 기존 a값이 할당되어 있기 때문에 합산값에서 빼면 기존 b값이 들어간다.

        System.out.println("After swap. a: " + a + ", b: " + b);
    }
}