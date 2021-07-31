package equals;

public class EqualsTest {

    /*
    * equals가 true로 나오려면 해쉬코드 값이 같아야 하기 때문에
    * equals와 hashCode를 모두 Override하여 재정의 해줘야 한다.
    */

    public static void main(String[] args) throws CloneNotSupportedException {

        Student std1 = new Student(100, "Lee");
        Student std2 = new Student(100, "Lee");
        Student std3 = std1;

        // 두개는 다른 객체이기 때문에 false가 나옴
        System.out.println(std1 == std2);

        // equals도 기본적으로는 주소값을 비교하기 때문에 false 나옴 -> Override 하여 재정의 필요
        System.out.println(std1.equals(std2));

        // 두개는 주소값이 같음으로 true
        System.out.println(std1 == std3);

        // false
        System.out.println(std1.hashCode());
        System.out.println(std2.hashCode());

        String str1 = new String("abc");
        String str2 = new String("abc");

        // true
        System.out.println(str1.equals(str2));

        // 서로 같은 값 나옴
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        // interger는 해쉬값이 정수값으로 그대로 나옴
        Integer i = 100;
        System.out.println(i.hashCode());

        // hashCode를 Override로 재정의 하여 변경했어도 identityHashCode 함수로 진짜 해쉬 값을 볼 수 있음
        System.out.println(System.identityHashCode(std1));
        System.out.println(System.identityHashCode(std2));

        // clone()은 생성자와는 다르게 현재 상태 그대로의 객체를 복사
        std1.setStudentName("Kim");
        Student copyStudent = (Student) std1.clone();
        System.out.println(copyStudent);
    }
}
