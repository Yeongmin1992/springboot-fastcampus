package collection;

public class MemberArrayListTest {

    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();

        Member memberLee = new Member(1001, "이순신");
        Member memberKim = new Member(1002, "김유신");
        Member memberKang = new Member(1003, "강감찬");
        Member memberHong = new Member(1004, "홍길동");

       memberArrayList.addMember(memberLee);
       memberArrayList.addMember(memberKim);
       memberArrayList.addMember(memberKang);
       memberArrayList.addMember(memberHong);

       // 들어간 순서대로 나옴
        memberArrayList.showAllMember();
        memberArrayList.removeMember(memberKim.getMemberId());
        memberArrayList.showAllMember();
    }
}
