package decorator;

public class Latte extends Decorator{
    // 얘가 상속하는 Decorator 클래스가 기본생성자가 없어서 아래와 같이 해준다... Decorator에 기본 생성자를 추가하는 것이 아니고..?
    public Latte(Coffee coffee) {
        super(coffee);
    }

    public void brewing() {
        super.brewing();
        System.out.print(" Adding Milk ");
    }
}
