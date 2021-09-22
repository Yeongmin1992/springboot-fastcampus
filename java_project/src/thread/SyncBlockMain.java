package thread;
// sycronized method 방식
class Bank1 {
    private int money = 10000;

    public void saveMoney(int save) {
        // saveMoney함수 안에서 Bank1 객체를 동기화 하겠다.
        synchronized (this) {
            int m = getMoney();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            setMoney(m + save);
        }
    }

    public synchronized void minusMoney(int minus) {

        int m = getMoney();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setMoney(m - minus);
    }

    public int getMoney() {
        return  money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

class Kim extends Thread {

    public void run() {
        // 메서드 쪽에서는 빼고, 쓰레드 쪽에서 동기화를 걸어줄 수도 있음
        synchronized (SyncMain.myBank) {
            System.out.println("start save");
            SyncMain.myBank.saveMoney(3000);
            System.out.println("saveMoney(3000) : " + SyncMain.myBank.getMoney());
        }
    }
}

class KimWife extends Thread {
    public void run() {
        System.out.println("start minus");
        SyncMain.myBank.minusMoney(1000);
        System.out.println("minusMoney(1000) : " + SyncMain.myBank.getMoney());
    }
}

public class SyncBlockMain {

    public static Bank1 myBank = new Bank1();

    public static void main(String[] args) {

        Park p = new Park();
        p.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ParkWife pw = new ParkWife();
        pw.start();
    }
}
