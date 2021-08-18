package exception;

// AutoCloseable은 exeption 여부와 관련없이 close() 메소드를 실행한다.
public class AutoCloseableObj implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("closing...");
    }
}
