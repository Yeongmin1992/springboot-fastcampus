package collection;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {

    private HashSet<SetMember> hashSet;

    public MemberHashSet() {
        hashSet = new HashSet<>();
    }


    // 초기에 사이즈 지정도 가능
    public MemberHashSet(int size) {
        hashSet = new HashSet<>(size);
    }


    public void addMember(SetMember member) {
        hashSet.add(member);
    }

    public boolean removeMember(int memberId) {
    /*
        for(int i=0; i<HashSet.size(); i++) {
            Member member = HashSet.get(i);

            int tempId = member.getMemberId();
            if(tempId == memberId) {
                HashSet.remove(i);
                return true;
            }
        }
    */

        // iterator 사용해서
        // Set과 같이 get이 구현되지 않은 collection에서 많이 사용용
       Iterator<SetMember> ir = hashSet.iterator();

        while(ir.hasNext()) {
            // 요소를 반환하고, 포인터는 next로 이동
            SetMember member = ir.next();

            int tempId = member.getMemberId();
            if(tempId == memberId) {
                hashSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + " doesn't exist");
        return false;

    }

    public void showAllMember() {
        for (SetMember member : hashSet) {
            System.out.println(member);
        }
        System.out.println();
    }

}
