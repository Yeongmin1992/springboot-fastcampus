package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class intArrayStreamTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        for(int num : arr) {
            System.out.println(num);
        }

        System.out.println();
        IntStream is = Arrays.stream(arr);
        is.forEach(n -> System.out.println(n));

        //스트림은 배열의 요소를 커서를 이동하여 소모하기 때문에 한번 위에 있는 is변수를 한번더 사용할 수 없다. 다시 Arrays.stream()을 호출하여 사용해야 함

        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
}
