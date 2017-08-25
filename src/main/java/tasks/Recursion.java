package tasks;

public class Recursion {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.factorial(5));
    }

    public int factorial(int n) {
        int result;

        if (n == 1) {
            return 1;
        }

        result = factorial(n - 1) * n;
        return result;
    }
}
