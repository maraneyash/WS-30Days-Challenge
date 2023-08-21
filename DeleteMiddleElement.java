import java.util.Scanner;
import java.util.Stack;

public class DeleteMiddleElement {
    public static void deleteMiddle(Stack<Integer> stack, int current, int size) {
        if (stack.isEmpty() || current == size / 2) {
            stack.pop();
            return;
        }

        int temp = stack.pop();
        deleteMiddle(stack, current + 1, size);

        stack.push(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }

        int size = stack.size();
        deleteMiddle(stack, 0, size);

        System.out.println("Stack after deleting middle element:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        scanner.close();
    }
}
