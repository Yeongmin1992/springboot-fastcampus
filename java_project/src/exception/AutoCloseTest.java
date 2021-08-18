package exception;

public class AutoCloseTest {

    public static void main(String[] args) {

        AutoCloseableObj obj = new AutoCloseableObj();

        try(obj) {
            // 강제 오류 발생
            throw new Exception();
        }catch(Exception e) {
            System.out.println("exception");
        }

        System.out.println("end");
    }
}
