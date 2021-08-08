package innerclass;

class OutClass {
    private int num = 10;
    private static int sNum = 20;
    private InClass inclass;

    public OutClass() {
        inclass = new InClass();
    }

    // 인스턴스 내부 클래스
    // private 없이 inner class를 만드는 경우는 거의 없지만, private 으로 생성하지 않을 경우 outer class를 사용하여 외부에서 접근 가능
    private class InClass{
        int iNum = 100;

        // inner class는 outer class가 생성된 후 생성됨으로, static 변수 사용 불가 -> 사용하려면 정적 내부 클래스 안에서 사용해야 한다는데 사용 되네...?
        static int sInNum = 500;

        void inTest() {

            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + iNum + "(내부 크래스의 인스턴스 변수)");
            System.out.println("InClass sInNum = " + sInNum + "(내부 크래스의 스태틱 변수)");
        }
    }

    public void usingClass() {
        inclass.inTest();
    }

    // 정적 내부 클래스
    static class InStaticClass {

        int iNum = 100;
        static int sInNum = 200;

        // 정적 내부 클래스는 외부 클래스 없이 생성이 가능 흠으로, 외부 클래스의 인스턴스 변수 사용 불가
        void inTest() {

            // System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + iNum + "(내부 크래스의 인스턴스 변수)");
            System.out.println("InClass sInNum = " + sInNum + "(내부 크래스의 인스턴스 변수)");
        }

        static void sTest() {

            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            // static 클래스의 static 메서드는 static class가 생성되지 않아도 호출될수 있기 때문에 내부클래스의 인스턴스 변수는 사용 불가
            // System.out.println("InClass inNum = " + iNum + "(내부 크래스의 인스턴스 변수)");
            System.out.println("InClass sInNum = " + sInNum + "(내부 크래스의 인스턴스 변수)");

        }

    }
}

public class InnerTest {

    public static void main(String[] args) {

        /* 내부 클래스 테스트
        // 이렇게 생성을 하면 내부적으로 알아서 inner class를 생성
        OutClass outClass = new OutClass();
        outClass.usingClass();

        // inner class를 brivate으로  생성하지 않았을 경우 아래와 같이 외부클래스에서 호출 가능
        // OutClass.InClass inner = outClass.new InClass();
        // inner.inTest();
*/

        // 인스턴스 클래스와는 다르게 아래의 방식으로 바로 생성 가능
         OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
         sInClass.inTest();

        System.out.println();

        // 클래스 생성과 무관하게 정적 메소드 바로 호출
        OutClass.InStaticClass.sTest();
    }
}
