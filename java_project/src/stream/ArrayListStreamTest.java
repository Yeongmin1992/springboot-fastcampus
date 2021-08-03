package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        sList.add("Tomas");
        sList.add("Edward");
        sList.add("Jack");

        // int와 같은 타입의 스티림은 intStream과 같은 객체로 반환 되고, 리스트의 스트림은 아래와 같이 지정해 줘야 함
        Stream<String> stream = sList.stream();
        stream.forEach(s -> System.out.println(s));

        sList.stream().sorted().forEach(s -> System.out.print(s + "\t"));

        System.out.println();

        sList.stream().map(s -> s.length()).forEach(n -> System.out.print(n + "\t"));

        System.out.println();

        sList.stream().filter(s -> s.length() >= 5).forEach(n -> System.out.print(n + "\t"));
    }

}
