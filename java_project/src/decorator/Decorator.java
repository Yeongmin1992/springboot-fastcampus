package decorator;

// 이 클래스는 데코레이터용으로 혼자 쓰일 일은 없고, 상속을 하기 위한 용도로만 사용 -> Decorator의 생성자에는 반드시 무언가 들어가야 한다!
public abstract class Decorator extends Coffee{

    Coffee coffee;

    public Decorator(Coffee coffee) {

        this.coffee = coffee;
    }

    @Override
    public void brewing() {

        coffee.brewing();
    }
}
