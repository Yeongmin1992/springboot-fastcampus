package map;

import java.util.HashMap;

public class MemberHashMapTest {

    public static void main(String[] args) {
        MemberHashMap memberHashMap = new MemberHashMap();

        MapMember memberLee = new MapMember(1001, "이순신");
        MapMember memberKim = new MapMember(1002, "김유신");
        MapMember memberKang = new MapMember(1003, "강감찬");

        memberHashMap.addMember(memberLee);
        memberHashMap.addMember(memberKim);
        memberHashMap.addMember(memberKang);

        memberHashMap.showAllMember();

        // 직접 구현한 toString이 아닌 HashMap의 toString 사용
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1001, "Lee");
        hashMap.put(1002, "Kim");
        hashMap.put(1003, "Kang");

        System.out.println(hashMap);
    }
}
