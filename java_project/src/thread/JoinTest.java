package thread;

public class JoinTest extends Thread {

    int start;
    int end;
    int total;

    public JoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public void run() {

        int i;
        for (i = start; i <= end; i++) {

            total += i;
        }
    }

    public static void main(String[] args) {

        // main thread, jt1, jt2 총 3개의 쓰레드가 있다!!
        System.out.println(Thread.currentThread() + "start");

        JoinTest jt1 = new JoinTest(1, 50);
        JoinTest jt2 = new JoinTest(51, 100);

        jt1.start();
        jt2.start();

        // 아래와 같이 join을 걸어주면 main thread가 not runnable 상태가 되어 jt1과 jt2의 동작이 끝난 후 runnable 상태가 되어 실행됨
        try {
            jt1.join();
            jt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int lastTotal = jt1.total + jt2.total;

        System.out.println("ht1.total = " + jt1.total);
        System.out.println("ht2.total = " + jt2.total);
        System.out.println("lastTotal = " + lastTotal);

        System.out.println(Thread.currentThread() + "end");
    }
}
