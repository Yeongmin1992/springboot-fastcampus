package collection;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        // 오름차순을 내림차순으로
        return s1.compareTo(s2) * (-1);
    }
}

public class MemberTreeSetTest {

    public static void main(String[] args) {
        /*
        // String 클래스가 이미 Comparable 클래스를 구현 했기 때문에 정렬이되어져 나오는 것을 볼 수 있음
        TreeSet<String> set = new TreeSet<String>();

        set.add("홍길동");
        set.add("강감찬");
        set.add("이순신");

        System.out.println(set);
        */

        MemberTreeSet memberTreeSet = new MemberTreeSet();

        TreeMember memberKang = new TreeMember(1003, "강감찬");
        TreeMember memberLee = new TreeMember(1001, "이순신");
        TreeMember memberKim = new TreeMember(1002, "김유신");
        TreeMember memberHong = new TreeMember(1004, "홍길동");

        memberTreeSet.addMember(memberLee);
        memberTreeSet.addMember(memberKim);
        memberTreeSet.addMember(memberKang);
        memberTreeSet.addMember(memberHong);

        memberTreeSet.showAllMember();

        // comparable이 이미 구현되어 있는 상태에서 새로운 정렬 로직을 적용하기 위해 comparator를 사용하는 경우가 많음
        TreeSet set = new TreeSet<String>(new MyCompare());
        set.add("Park");
        set.add("Kim");
        set.add("Lee");

        System.out.println(set);

    }
}
