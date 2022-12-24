import java.util.Scanner;

public class InputUK {
    double a, b;
    int n;
    public InputUK() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть нижню межу інтегрування: ");
        this.a = sc.nextDouble();
        System.out.print("Введіть верхню межу інтегрування: ");
        this.b = sc.nextDouble();
        System.out.print("Введіть крок інтегрування: ");
        this.n = sc.nextInt();
    }
}
