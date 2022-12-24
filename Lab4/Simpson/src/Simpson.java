public class Simpson {
    public static void main(String[] args) {
        InputChoice ch = new InputChoice();

        if (ch.choice == 1) {
            InputUK uk = new InputUK();
            Integration intg = new Integration();
            System.out.print("Результат: ");
            System.out.println(intg.integrate(uk.a, uk.b, uk.n));
        }
        else {
            InputEN en = new InputEN();
            Integration intg = new Integration();
            System.out.print("Result: ");
            System.out.println(intg.integrate(en.a, en.b, en.n));
        }
    }
}

