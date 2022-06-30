package day09.training;

public class DaemonThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread t = new DaemonThread();
//        t.setDaemon(false);   // 데몬 스레드가 아니면 어떻게 작동될까?
        t.start();
        // 프로그램 종료
    }

    public DaemonThread() {
        super();
//        this.setDaemon(true);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {

        }
    }
}
