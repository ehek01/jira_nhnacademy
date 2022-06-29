package day09.training;

public class ThreadAndException {
    public static void main(String[] args) {
        Thread t = new Thread(new ExceptionalRunner());
        System.out.println("Before call thread");
        t.start();
//        new ExceptionalRunner().run();    // 이 주석을 제거하면?
        System.out.println("After call thread");
    }
}

class ExceptionalRunner implements Runnable {
    @Override
    public void run() {
        System.out.println("ExceptionalRunner run");
        throw new RuntimeException("Unknown Exception.");
    }
}
