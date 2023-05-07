package stream;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// reduce는 stream에 적용할 함수를 커스텀할 때 사용
public class ReduceTest {
    public static void main(String[] args) {

        String greetings[] = {"안녕하세요~~~", "hello", "Good morning", "반값습니다^^"};

        System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) ->

                {
                    if (s1.getBytes().length >= s2.getBytes().length) return s1;
                    else return s2;
                }
        ));
    }
}