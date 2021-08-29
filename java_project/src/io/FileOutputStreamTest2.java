package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {

    public static void main(String[] args) throws FileNotFoundException {

        // default 는 false로 덮어쓰기, true 주면 이어서 쓰기
        FileOutputStream fos = new FileOutputStream("output2.txt", true);
        try(fos) {

            byte[] bs = new byte[26];

            byte data = 65;
            for(int i = 0; i < bs.length; i++) {
                bs[i] = data++;
            }

            fos.write(bs);
            // index 2 즉, c 부터 10개 쓰겠다. -> fis.write(bs, 2, 10) -> C부터 L까지 나옴

        } catch (IOException e) {
            System.out.println(e);

        }
        System.out.println("end");
    }
}
