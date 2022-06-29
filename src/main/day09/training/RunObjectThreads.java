package day09.training;

public class RunObjectThreads {

    Object monitor = new Object();

    public static void main(String[] args) {
        RunObjectThreads r = new RunObjectThreads();
        r.checkThreadState();
    }

    void checkThreadState() {
        MonitorThread t = new MonitorThread(monitor);
        MonitorThread t2 = new MonitorThread(monitor);    // 2
        try {
            System.out.println("t.state after new: " + t.getState());
            t.start();
            t2.start();   // 2
            System.out.println("t.state after start: " + t.getState());
            Thread.sleep(100);
            System.out.println("t.state after 0.1 sec: " + t.getState());
            synchronized (monitor) {
//                monitor.notify();   // monitor 에 의해 wait 중인 스레드(t)를 깨운다
//                monitor.notify();    // 3
                monitor.notifyAll(); // 4
            }
            Thread.sleep(100);
            System.out.println("t.state after notify: " + t.getState());
            t.join();   // 스레드 종료 시 까지 대기
            System.out.println("t.state after join: " + t.getState());
            t2.join();    // 2
            System.out.println("t2.state after join: " + t2.getState()); // 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
