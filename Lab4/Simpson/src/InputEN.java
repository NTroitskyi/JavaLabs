import java.util.Scanner;

public class InputEN {
    double a, b;
    int n;
    public InputEN() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lower limit of integration: ");
        this.a = sc.nextDouble();
        System.out.print("Enter the upper limit of integration: ");
        this.b = sc.nextDouble();
        System.out.print("Enter the integration step: ");
        this.n = sc.nextInt();
    }
}
