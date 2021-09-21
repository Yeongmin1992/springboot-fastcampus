package io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    public static void main(String[] args) throws IOException {

        RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");

        rf.writeInt(100);
        System.out.println("pos: " + rf.getFilePointer());
        rf.writeDouble(3.14);
        System.out.println("pos: " + rf.getFilePointer());
        // java에서 사용하는 modified UTF-8은 한국어 한글자당 3바이트씩 사용 & string은 마지막에 보이지 않는 null character 2바이트 사용
        rf.writeUTF("안녕하세요");
        System.out.println("pos: " + rf.getFilePointer());

        //위의 쓰는 과정에서 파일포인터가 끝으로 이동한 상태이기 때문에 파일포인터를 맨 앞으로 보내주어야 함
        rf.seek(0);

        int i = rf.readInt();
        double d = rf.readDouble();
        String str = rf.readUTF();

        System.out.println(i);
        System.out.println(d);
        System.out.println(str);
   }
}
