public class Integration {
    public static double f(double x) {
        return x*x; //межі: від 0 до 3. Прямує до 9
        //return Math.cos(x); //межі: від 0 до 2. Результат близький до 0.91
        //return 1/x; //межі: від 1 до 3. Результат близький до 1.1
    }
    public double integrate(double a, double b, int n) {
        double h = (b - a) / (n - 1);

        double sum = 1.0 / 3.0 * (f(a) + f(b));

        for (int i = 1; i < n - 1; i += 2) {
            double x = a + h * i;
            sum += 4.0 / 3.0 * f(x);
        }

        for (int i = 2; i < n - 1; i += 2) {
            double x = a + h * i;
            sum += 2.0 / 3.0 * f(x);
        }

        return sum * h;
    }
}





