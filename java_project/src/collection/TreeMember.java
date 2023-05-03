package collection;

public class TreeMember implements Comparable<TreeMember> {

    private int memberId;
    private String memberName;

    public TreeMember(int memberId, String memberName) {
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
        if(obj instanceof TreeMember) {
            TreeMember member = (TreeMember) obj;
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

    // 집어 넣을 member가 parameter로 들어오면 기존에 Tree에 들어가 있던 member 들과 비교한다.
    // 이와 같이 현재 코드에서 부르는게 아니라 시스템(JDK)에 의해 불려지는 함수를 callback 함수라고 한다.
    // 같으면 0, 크면 양수, 작으면 음수 반환하면 됨 -> 내림차순 하고 싶으면 반대로
    @Override
    public int compareTo(TreeMember member) {
        return this.memberId - member.memberId;
    }

    // overriding toString method
    @Override
    public String toString() {
        return memberName + " ID is " + memberId + ".";
    }
}
