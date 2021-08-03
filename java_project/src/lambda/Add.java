package lambda;
// 람다함수로 구현할 interface는 내부에 함수를 한게만 가져야한다. 람다함수는 이름을 갖지 안기 때문. 아래의 어노테이션으로 함수형 인터페이스라는 것을 명시해줌
@FunctionalInterface
public interface Add {

    int add(int x, int y);
}
