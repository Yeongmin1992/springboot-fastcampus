package io;

import java.io.*;
import java.net.Socket;

public class FileCopyTest {

    public static void main(String[] args) throws IOException {
        long millisecond = 0;
/*

        // 한 바이트 씩 읽고 써서 느림
        try(FileInputStream fis = new FileInputStream("a.zip");
            FileOutputStream fos = new FileOutputStream("copy.zip")) {
*/

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.zip"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.zip"))) {

            millisecond = System.currentTimeMillis();

            int i;
            while((i = bis.read()) != -1) {
                bos.write(i);
            }

            millisecond = System.currentTimeMillis() - millisecond;

        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println(millisecond + " 소요되었습니다.");

        // 채팅과 같은 소캣 통신에서 아래와 같이 사용
        Socket socket = new Socket();

        // 한글을 사용하기 위해 InputStreamReader로 감싸주고, buffer를 사용하기 위해 BufferedReader로 감싸줌
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        br.readLine();
    }
}
