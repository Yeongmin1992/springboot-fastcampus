package map;

public class MemberHashMapTest {

    public static void main(String[] args) {
        MemberHashMap memberHashMap = new MemberHashMap();

        SetMember memberLee = new SetMember(1001, "이순신");
        SetMember memberKim = new SetMember(1002, "김유신");
        SetMember memberKang = new SetMember(1003, "강감찬");

        memberHashMap.addMember(memberLee);
        memberHashMap.addMember(memberKim);
        memberHashMap.addMember(memberKang);
        memberHashMap.showAllMember();

    }
}
