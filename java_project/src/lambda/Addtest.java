package lambda;

public class Addtest {

    public static void main(String[] args) {

        // implements 없이 Interface에서 지정해놓은 함수를 구현하여 사용 가능
        Add addM = (x, y) -> {return x + y;};

        // 반환문이 한줄인 경우 return과 중괄호 생략가능 -> 자세한 내용은 강의자료 참고
        Add addA = (x, y) -> x + y;

        System.out.println(addM.add(2, 3));

    }
}
