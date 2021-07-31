package String;

import java.io.BufferedReader;

public class StringBuilderTest {

    public static void main(String[] args) {

        String java = new String("java");
        String android = new String("android");

        // 해시코드 값 동일. 계속 연결하여도 가변한다.
        StringBuilder buffer = new StringBuilder(java);
        System.out.println(System.identityHashCode(java));
        buffer.append(android);
        System.out.println(System.identityHashCode(java));

        String test = buffer.toString();
        System.out.println(test);


    }
}
