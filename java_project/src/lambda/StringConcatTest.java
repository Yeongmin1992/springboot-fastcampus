package lambda;

public class StringConcatTest {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "World";

        StringConcatImpl strImpl = new StringConcatImpl();
        strImpl.makeString(s1, s2);

        StringConcat contcat = (s, v) -> System.out.println(s + "," + v);
        contcat.makeString(s1, s2);

        // 람다 함수를 사용하면 이 클래스의 예시에서와 같이 중간에 클래스를 만들고, 함수를 만드는 과정을 생략할 수 있다.
        // 이는 클래스가 없이 작동하는 것이 아니라 아래와 같은 익명의 내부 클래스가 만들어지는 것이다.
        StringConcat concat2 = new StringConcat() {
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s1 + "...." + s2);
            }
        };

        concat2.makeString(s1, s2);
    }

}
