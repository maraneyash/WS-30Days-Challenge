import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class FirstNegativeInWindow {
    public static void printFirstNegatives(int[] arr, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            if (arr[i] < 0)
                deque.offerLast(i);
        }

        for (int i = k; i <= arr.length; i++) {
            if (!deque.isEmpty())
                System.out.print(arr[deque.peekFirst()] + " ");
            else
                System.out.print("0 ");

            if (i < arr.length) {
                while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                    deque.pollFirst();

                if (arr[i] < 0)
                    deque.offerLast(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        System.out.print("Enter the window size k: ");
        int k = scanner.nextInt();

        printFirstNegatives(arr, k);

        scanner.close();
    }
}
