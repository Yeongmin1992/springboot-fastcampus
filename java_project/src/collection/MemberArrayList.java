package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {

    private ArrayList<Member> arrayList;

    public MemberArrayList() {
        arrayList = new ArrayList<>();
    }

    // 초기에 사이즈 지정도 가능
    public MemberArrayList(int size) {
        arrayList = new ArrayList<>(size);
    }

    public void addMember(Member member) {
        arrayList.add(member);
    }

    public boolean removeMember(int memberId) {
    /*
        for(int i=0; i<arrayList.size(); i++) {
            Member member = arrayList.get(i);

            int tempId = member.getMemberId();
            if(tempId == memberId) {
                arrayList.remove(i);
                return true;
            }
        }
    */

        // iterator 사용해서
        // Set과 같이 get이 구현되지 않은 collection에서 많이 사용용
       Iterator<Member> ir = arrayList.iterator();

        while(ir.hasNext()) {
            // 요소를 반환하고, 포인터는 next로 이동
            Member member = ir.next();

            int tempId = member.getMemberId();
            if(tempId == memberId) {
                arrayList.remove(member);
                return true;
            }
        }

        System.out.println(memberId + " doesn't exist");
        return false;

    }

    public void showAllMember() {
        for (Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println();
    }

}
