import java.util.Scanner;

public class NthRoot {
    public static boolean isInteger(double num) {
        return Math.floor(num) == num;
    }

    public static int nthRoot(int n, int m) {
        double root = Math.pow(m, 1.0 / n);
        if (isInteger(root)) {
            return (int) root;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = scanner.nextInt();

        System.out.print("Enter M: ");
        int m = scanner.nextInt();

        int result = nthRoot(n, m);
        if (result != -1) {
            System.out.println("The " + n + "th root of " + m + " is: " + result);
        } else {
            System.out.println("No integer " + n + "th root found for " + m);
        }

        scanner.close();
    }
}
