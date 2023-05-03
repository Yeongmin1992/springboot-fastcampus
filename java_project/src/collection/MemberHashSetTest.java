package collection;

public class MemberHashSetTest {

    public static void main(String[] args) {
        MemberHashSet memberHashSet = new MemberHashSet();

        SetMember memberLee = new SetMember(1001, "이순신");
        SetMember memberKim = new SetMember(1002, "김유신");
        SetMember memberKang = new SetMember(1003, "강감찬");

        memberHashSet.addMember(memberLee);
        memberHashSet.addMember(memberKim);
        memberHashSet.addMember(memberKang);
        memberHashSet.showAllMember();

        // HashSet이 관리할 SetMember 클래스에서 equals와 hashcode 함수를 구현해 주어야 해당 기능에 맞추어 중복을 제거함
        SetMember memberHong = new SetMember(1003, "홍길동");
        memberHashSet.addMember(memberHong);

        // 들어간 순서대로 나오지 않음
        memberHashSet.showAllMember();
    }
}
