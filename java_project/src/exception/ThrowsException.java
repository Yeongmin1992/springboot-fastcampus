package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

    public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(fileName);
        // 클래스명을 동적으로 처리
        Class c = Class.forName(className);
        return c;
    }

    public static void main(String[] args) {
        ThrowsException test = new ThrowsException();

        try {
            test.loadClass("a.txt", "java.lang.String");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } // 위의 오류 이외의 모든 오류를 잡고 싶을 때(최상위 exception 사용, 가장 위에 쓰면 안됨!)
          catch (Exception e) {

          }

        /*
         아래처럼 Multi Catch도 가능

        try {
            test.loadClass("a.txt", "java.lang.String");
        } catch (FileNotFoundException | FileNotFoundException e) {
            System.out.println(e);
        }
         */

        System.out.println("end");
    }
}
