package log;

public class Student {

    private String studentName;
    MyLogger myLogger = MyLogger.getLogger();

    // 생성자에서는 throws를 하지 않는다. -> StudentNameFormatException 클래스에서 IllegalArgumentException 클래스를 상속 받으면 throws 를 하지 않아도 된다.(런타임 에러이기 때문)
    public Student(String studentName) {
        if (studentName == null) {
            throw new StudentNameFormatException("name must not be null");
        }
        if( studentName.split(" ").length > 3)
            throw new StudentNameFormatException("이름이 너무 길어요");

        this.studentName = studentName;
    }

    public String getStudentName() {
        myLogger.fine("begin getStudentName()");

        return studentName;
    }
}
