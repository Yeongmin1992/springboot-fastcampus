package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest3 {

    public static void main(String[] args) {

        int i;
        try (FileInputStream fis = new FileInputStream("input2.txt")) {

            byte[] bs = new byte[10];

            //while((i = fis.read(bs, 1, 9)) !- -1) { 이런 식으로 9개만 읽는 식으로 활용도 가능
            while((i = fis.read(bs)) != -1) {

                //for(int ch : bs) { 이렇게 읽으면, buffer에 기존 자료가 남아 있어 마지막은  UVWXYZ의 6개가 출력 되어야 하나 이전 buffer에서 남아있던 QRST까지 포함되어 출력됨
                // 그래서 새로 읽은 애들만 나타나도록 아래와 같이 처리해 줌
                for(int j = 0; j < i; j++) {
                    System.out.print((char)bs[j]);
                }
                System.out.println(" : " + i + "바이트 읽음");
            }
        } catch (IOException e) {
            System.out.println(e);;
        }
    }
}
