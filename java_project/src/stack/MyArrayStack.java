package stack;
import array.MyArray;

public class MyArrayStack {

    // 멤버 변수와 같은 경우는 아래와 같이만 써놔도 initialize가 된다. 객체인 경우 null, int인 경우 0, boolean은 false
    MyArray arrayStack;
    int top;

    public MyArrayStack() {
        top = 0;
        arrayStack = new MyArray();
    }

    public MyArrayStack(int size) {
        top = 0;
        arrayStack = new MyArray(size);
    }

    public void push(int data) {
        if(isFull()) {
            System.out.println("stack is full");
            return;
        }
        arrayStack.addElement(data);
        top++;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("stack is empty");
            return MyArray.ERROR_NUM;
        }
        return arrayStack.removeElement(--top);
    }

    public boolean isFull() {

        // 현재 배열로 stack을 구현하고 있음으로, 배열이 full 상태인지를 top이 배열의 사이즈와 같은지를 비교하여 확인
        if(top == arrayStack.ARRAY_SIZE) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(top == 0) {
            return true;
        }
        return false;
    }
}
