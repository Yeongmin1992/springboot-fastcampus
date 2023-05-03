package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {

    private TreeSet<TreeMember> treeSet;

    public MemberTreeSet() {
        treeSet = new TreeSet<>();
    }

    // comparable을 구현한 경우엔 필요 없지만 comparator를 구현한 경우에는 어떤 것을 구현했는지 명시해주어야 한다.
/*    public MemberTreeSet() {
        treeSet = new TreeSet<TreeMemberComparator>(new TreeMemberComparator());
    }*/

    public void addMember(TreeMember member) {
        treeSet.add(member);
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
       Iterator<TreeMember> ir = treeSet.iterator();

        while(ir.hasNext()) {
            // 요소를 반환하고, 포인터는 next로 이동
            TreeMember member = ir.next();

            int tempId = member.getMemberId();
            if(tempId == memberId) {
                treeSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + " doesn't exist");
        return false;

    }

    public void showAllMember() {
        for (TreeMember member : treeSet) {
            System.out.println(member);
        }
        System.out.println();
    }

}
