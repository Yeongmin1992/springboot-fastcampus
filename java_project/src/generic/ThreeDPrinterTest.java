package generic;

public class ThreeDPrinterTest {

    public static void main(String[] args) {

        Powder powder = new Powder();
        ThreeDPrinter3 printer = new ThreeDPrinter3();

        printer.setMaterial(powder);

        // This is the weakness of Object type parameter.
        // Cuz return type of getMaterial method is Object, it is required to enforce type.
        Powder p = (Powder) printer.getMaterial();
    }
}
