package generic;

public class ConstrainedGenericPrinterTest {

    public static void main(String[] args) {

        Powder powder = new Powder();
        // It is needed to fix type when using generic class.
        // If you don't fix type, it is perceived as object type, but not recommended.
        // <> 를 다이아몬드 연산자라고 함
        ConstrainedGenericPrinter<Powder> powderPrinter = new ConstrainedGenericPrinter<>();
        powderPrinter.setMaterial(powder);

        // Enforcing type isn't needed cuz compiler replace the type of generic class as powder.
        Powder p = powderPrinter.getMaterial();

        System.out.println(powderPrinter.toString());
    }
}
