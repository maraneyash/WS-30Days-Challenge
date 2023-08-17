import java.util.Scanner;

public class FibonacciMembership {
    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static boolean isFibonacci(int num) {
        return isPerfectSquare(5 * num * num + 4) || isPerfectSquare(5 * num * num - 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        boolean result = isFibonacci(num);
        if (result)
            System.out.println(num + " is a member of the Fibonacci series.");
        else
            System.out.println(num + " is not a member of the Fibonacci series.");

        scanner.close();
    }
}
