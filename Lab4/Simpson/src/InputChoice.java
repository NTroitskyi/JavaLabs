import java.util.Scanner;

public class InputChoice {
    int choice;
    public InputChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Оберіть якою мовою ви бажаєте отримати результат:");
        System.out.println("1 - Українська\n2 - Англійська");
        System.out.println("(Select the language in which you want to receive the result:)");
        System.out.println("(1 - Ukrainian)\n(2 - English)");
        System.out.println();
        System.out.print("Ваш вибір (Your choice): ");
        this.choice = sc.nextInt();
    }
}
