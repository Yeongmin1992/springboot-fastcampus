package innerclass;

class Outer2 {

    // 이런 방식으로 멤버변수 선언하는 것은 좋지 않다~! 생성자 활용할 것
    int outNum = 100;
    static int sNum = 200;

    // 매개변수 i 는 스택 메모리에 생성 -> 내부 클래스 안에서 변경이 불가하기 때문에 final로 선언해줌 -> final로 안해줘도 compiler가 final로 바꿔줌 -> 스택 메모리가 아닌 상수메모리에 쌓임 -> 스택 메모리에 있는 변수들과는 다르게 함수가 끝나도 남아있음
    Runnable getRunnable(final int i) {


        // 함수의 지역변수로 스택 메모리에 생성
        final int num = 10;
        // 지역 클래스는 함수 안에서만 사용되고 불림으로 한번만 사용하기 때문에 익명 클래스로 함수 선언과 동시에 리턴이 가능
        // class MyRunnable implements Runnable {

        return new Runnable() {

            int localNum = 1000;

            @Override
            public void run() {

                // 아래의 지역변수인 i와 num 수정 불가, 불러서 쓰는건 가능
                // i = 50;
                // num = 20;

                System.out.println("i = " + i);
                System.out.println("num = " +num);
                System.out.println("localNum = " +localNum);
                System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
                System.out.println("Outer2.Num = " + Outer2.sNum + "(외부 클래스 정적 변수)");
            }
        };
        // 익명 함수로 위에서 리턴을 해줌
        // return new MyRunnable();
    }

    // 아래의 방식으로도 anonymous inner class 실행 가능
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Runnable class");
        }
    };
}

public class AnounymousInnerTest {

    public static void main(String[] args) {

        Outer2 out = new Outer2();
        // class가 필요없어, 클래스 이름없이 함수 호출 가능
        Runnable runner = out.getRunnable(100);

        runner.run();

        out.runnable.run();

    }
}
