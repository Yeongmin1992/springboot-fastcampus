package stream;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// ReduceTest1와 같은 결과 다른방법
public class ReduceTest {
    public static void main(String[] args) {

        String greetings[] = {"안녕하세요~~~", "hello", "Good morning", "반값습니다^^"};

        String str = Arrays.stream(greetings).reduce(new CompareString()).get();
        System.out.println(str);
    }
}
