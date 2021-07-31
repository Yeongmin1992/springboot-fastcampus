package array;

/*
* 직접 배열을 만들어 봅니다.
* */
public class MyArray {

    int[] intArr;           // int array
    int count;              // 개수

    public int ARRAY_SIZE;
    public static final int ERROR_NUM = -999999999;

    public MyArray() {
        count = 0;
        ARRAY_SIZE = 10;
        intArr = new int[ARRAY_SIZE];
    }

    public MyArray(int size) {
        count = 0;
        ARRAY_SIZE = size;
        intArr = new int[size];
    }

    public void addElement(int num) {
        if(count >= ARRAY_SIZE) {
            System.out.println("not enough memory");
            return;
        }
        intArr[count++] = num;
    }

    public void insertElement(int position, int num) {
        int i;

        // index error
        if(position < 0 || position > count) {
            System.out.println("Inseert Error");
            return;
        }

        // 배열이 꽉 찬 경우
        if(count >= ARRAY_SIZE) {
            System.out.println("Not Enough Memory");
            return;
        }

        // 제일 끝의 요소부터 새로운 요소를 집어 넣을 포지션 바로 뒤의 요소까지 한칸씩 뒤로 미루기
        for(i = count - 1; i >= position; i++) {
            intArr[i+1] = intArr[i];
        }

        // position의 위치에 새로운 요소 num을 넣고 요소 수를 하나 늘려줌줌
       intArr[position] = num;
        count++;
    }

    public int removeElement(int position) {
        int ret = ERROR_NUM;

        // 배열이 비어있는 경우
        if(isEmpty()) {
            System.out.println("Array is empty");
            return ret;
        }

        // 삭제할 리스트의 인덱스 오류
        if(position < 0 || position > count -1) {
            return ret;
        }

        // 오류가 없을 경우 반환할 값을 할당하여 리턴
        ret = intArr[position];

        for(int i = position; i < count - 1; i++) {
            intArr[i] = intArr[i + 1];
        }
        count --;
        return ret;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        if(count == 0) {
            return true;
        }
        return  false;
    }

    public int getElement(int position) {
        if(position < 0 || position > count-1) {
            System.out.println("검색 위치 오류. 현재 리스트 개수는 " + count + "개 입니다.");
            return ERROR_NUM;
        }
        return intArr[position];
    }

    public void printAll() {
        if(count == 0) {
            System.out.println("출력할 내용이 없습니다.");
            return;
        }

        for(int i = 0; i < count; i++) {
            System.out.println(intArr[i]);
        }
    }

    public void removeAll() {
        for(int i=0; i<count; i++) {
            intArr[i] = 0;
        }
        count = 0;
    }


}
