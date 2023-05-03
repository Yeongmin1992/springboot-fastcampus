package collection;

import java.util.Comparator;

// TreeMember에서 구현한 Comparable말고 Comparator로 구현도 가능
public class TreeMemberComparator implements Comparator<TreeMemberComparator> {

    private int memberId;
    private String memberName;

    public TreeMemberComparator(){}

    public TreeMemberComparator(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TreeMemberComparator) {
            TreeMemberComparator member = (TreeMemberComparator) obj;
            if(this.memberId == member.getMemberId()) {
                return true;
            }
            else return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return memberId;
    }

    @Override
    public int compare(TreeMemberComparator member1, TreeMemberComparator member2) {
        return (member1.memberId - member2.memberId);
    }

    // overriding toString method
    @Override
    public String toString() {
        return memberName + " ID is " + memberId + ".";
    }
}
