package innerclass;

class OutClass {
    private int num = 10;
    private static int sNum = 20;

    class InClass{
        int iNum = 100;

        static int sInNum = 500;

        void inTest() {

            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + iNum + "(내부 크래스의 인스턴스 변수)");
        }

    }
}

public class InnerTest {

    public static void main(String[] args) {

    }
}
