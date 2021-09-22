package thread;

import javax.swing.table.TableCellRenderer;

// 이미  상속을 받은 클래스는 다른 클래스를 받을 수 없으므로 Runnable을 구현하여 사용
class RunnableThread implements Runnable {

    public void run() {

        int i;
        for(i = 1; i <= 200; i++) {
            System.out.print(i + "\t");
        }
    }

}

public class RunnableThreadTest {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread() + "start");

        MyThread runnable = new MyThread();

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();

        System.out.println(Thread.currentThread() + "end");

        // 간단하게 만들 경우는 아래와 같은식으로 thread 만들기 가능
        Runnable run = new Runnable() {
            @Override
            public void run() {

                System.out.println("run");
            }
        };

        run.run();
    }
}
