package day09.training;

public class SleepThread extends Thread {
    long millis;
    public SleepThread(long millis) {
        this.millis = millis;
    }
    @Override
    public void run() {
        System.out.println("Sleeping " + getName());
        try {
            Thread.sleep(millis);   // 특정 시간 동안 대기
            System.out.println("Stopping " + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
