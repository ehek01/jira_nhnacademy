package day09.training;

public class TickTock {
    public static void main(String[] args) {
        TickTock clock = new TickTock();
//        clock.single();
        clock.multi();
    }

    private void multi() {
        Thread tick = new Thread(new Tick());
        Thread tock = new Thread(new Tock());
        tick.start();
        tock.start();
    }

    private void single() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.print("Tick ");
            } else {
                System.out.print("Tock ");
            }
            try {
                Thread.sleep(1_000);     // 1초 동안 잠들어요
            } catch (InterruptedException e) {
            }
        }
    }
}

class Tick implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print("Tick ");
            try {
                Thread.sleep(2_000); // 2초 동안 잠들어
            } catch (InterruptedException e) {
            }
        }
    }
}

/*
0    1    2    3    4    5
Tick ____ Tick ____ Tick ____ ...
____ Tock ____ Tock ____ Tock ...
0         2         4
     1         3         5
 */
class Tock implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
        }
        for (int i = 0; i < 5; i++) {
            System.out.print("Tock ");
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
            }
        }
    }
}
