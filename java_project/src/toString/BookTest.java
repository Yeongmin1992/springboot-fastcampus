package toString;

class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // toString 재정의
    @Override
    public String toString() {
        return title + "," + author;
    }
}

public class BookTest {

    public static void main(String[] args) {

        Book book = new Book("데미안", "헤르만 헤세");

        // toString의 기본설정대로 object_class.Book@776ec8df와 같이 클래스명@메모리 위치의 가상 값 형식으로 나옴
        System.out.println(book);

        // String의 to String은 Overriding으로 재정의가 되어있어 test를 출력해줌
        String str = new String("test");
        System.out.println(str);

    }
}
