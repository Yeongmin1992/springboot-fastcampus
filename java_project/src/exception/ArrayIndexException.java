package exception;

// exception 처리를 해주면 비정상 종료가 되지 않고, 이후의 로직을 실행할 수 있다.
public class ArrayIndexException {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        try {
                for (int i = 0; i <= 5; i++) {
                    System.out.println(arr[i]);
                }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }

        System.out.println("here!!!");
    }
}
