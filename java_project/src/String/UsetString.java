package String;

public class UsetString {

    public static void main(String[] args) {

        /*
        String 클래스는 한번 지정되면 불변
        첫 번째 java와 두 번째 java의 해시코드 값이 다르다.
        따라서, 메모리를 많이 잡아먹기 때문에 StringBuilder(쓰레드가 하나일 때) 혹은 StringBuffer(쓰레드가 여러개일때 동기화 기능 제공)을
        사용한다.
         */

        // 힙메모리에 인스턴스로 생성. 같은 방식으로 새로운 인스턴스를 생성할 경우 둘은 다른 것이됨
        String str1 = new String("abc");

        // 상수풀에 있는 주소를 참조하는 방법
        String str2 = "abc";

        String java = new String("java");
        String android = new String("android");

        System.out.println(System.identityHashCode(java));
        java = java.concat(android);

        System.out.println(System.identityHashCode(java));

    }
}
