package map;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {

    private HashMap<Integer, SetMember> hashMap;

    public MemberHashMap() {
        hashMap = new HashMap<>();
    }

    public void addMember(SetMember setMember) {
        hashMap.put(setMember.getMemberId(), setMember);
    }

    public boolean removeMember(int memberId) {
        if(hashMap.containsKey(memberId)) {
            hashMap.remove(memberId);
        }
        System.out.println("no element");
        return false;
    }

    public void showAllMember() {
        Iterator<Integer> ir = hashMap.keySet().iterator();

        while(ir.hasNext()) {
            int key = ir.next();
            SetMember setMember = hashMap.get(key);
            System.out.println(setMember);
        }
    }
}
