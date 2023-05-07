package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;
// BinaryOperator를 구현하는 방법
class CompareString implements BinaryOperator<String>{

    @Override
    public String apply(String s1, String s2) {
        if ( s1.getBytes().length >= s2.getBytes().length ) return s1;
        else return s2;
    }
}

public class ReduceTest2 {
    public static void main(String[] args) {

        String greetings[] = {"안녕하세요~~~", "hello", "Good morning", "반값습니다^^"};

        String str = Arrays.stream(greetings).reduce(new CompareString()).get();
        System.out.println(str);
    }
}


