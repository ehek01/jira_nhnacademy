package day09.training;

public class Dual {
    private StringBuilder sb = new StringBuilder();

    //    private Object lock = new Object();
//    private Object monitor = new Object();
    public static void main(String[] args) {
        Dual dual = new Dual();
        dual.humanVsOrc();
    }

    void attack(String weapon) {
        sb.append(weapon);
    }

    public void humanVsOrc() {
        Thread human = new Thread(new Worrier("🗡️️", this));
        Thread orc = new Thread(new Worrier("🪓", this));


        orc.start();
        human.start();

        try {
            orc.join();     // 스레드가 종료될 때까지 대기
            human.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    static class Worrier implements Runnable {
        private String weapon;
        private Dual dual;
        static final Object monitor = new Object();

        public Worrier(String weapon, Dual dual) {
            this.weapon = weapon;
            this.dual = dual;
        }

        @Override
        public void run() {
            for (int i = 0; i < 400; i++) {
                attack();
            }
        }

        public void attack() {
            synchronized (monitor) {
                dual.attack(this.weapon);
            }
        }
    }
}