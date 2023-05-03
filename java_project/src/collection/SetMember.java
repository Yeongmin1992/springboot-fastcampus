package collection;

import java.util.Objects;

public class SetMember {

    private int memberId;
    private String memberName;

    public SetMember(int memberId, String memberName) {
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
        if(obj instanceof SetMember) {
            SetMember member = (SetMember) obj;
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

    // overriding toString method
    @Override
    public String toString() {
        return memberName + " ID is " + memberId + ".";
    }
}
