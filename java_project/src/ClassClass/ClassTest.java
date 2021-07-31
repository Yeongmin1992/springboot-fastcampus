package ClassClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // new 대신 아래와 같은 방법으로 객체를 생성할 수 있으나, 잘 안쓰는 방법(로컬에 Person클래스가 없을때 사용)
        Class c1 = Class.forName("ClassClass.Person");

        Person person = (Person) c1.newInstance();

        person.setName("Lee");
        System.out.println(person);

        Class c2 = person.getClass();
        Person p = (Person) c2.newInstance();
        // 디폴트 생성자를 호출하기 때문에 name에 null이 들어감
        System.out.println(p);

        /*
        local에 Person이 없을때 이러한 방식으로 생성
         */
        // String 타입의 파라미터를 받는다는 것을 지정
        Class[] parameterTypes = {String.class};
        // 해당 클래스에서 String을 받는 생성자를 반환해 줌
        Constructor cons = c2.getConstructor(parameterTypes);

        Object[] initargs = {"Kim"};
        Person kimPerson = (Person)cons.newInstance(initargs);
        System.out.println(kimPerson);

        //위의 코드는 아래의 역할을함
        Person kim2 = new Person("kim");
    }
}
