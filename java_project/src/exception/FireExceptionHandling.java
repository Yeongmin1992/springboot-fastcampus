package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 inputStream 등을 사용할 경우 반드시 close를 해줘야 하는 경우가 있다.
 위의 경우에서 try, catch로 오류처리를 하다보면 try, catch문이 계속 생기고, null 오류와 같이 다른 오류가 생길 수 있다.
 하여, finally로 처리해주면 try가 실행될 경우 반드시 해당구문이 실행되어 깔끔하게 처리할 수 있다.
*/


public class FireExceptionHandling {

    public static void main(String[] args) {

        FileInputStream fis = null;
/*
        try {
            fis = new FileInputStream("a.txt");

            System.out.println("read");

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            try {
                fis.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        System.out.println("end");
        */

        try {
            fis = new FileInputStream("a.txt");

            System.out.println("read");

        } catch (FileNotFoundException e) {
                System.out.println(e);
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finally가 수행됨");
            }
        System.out.println("끝까지 다 수행됨");
        }
    }
