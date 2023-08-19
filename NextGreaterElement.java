import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int[] nextGreaterElements = findNextGreaterElements(arr);

        System.out.println("Next Greater Elements:");
        for (int element : nextGreaterElements)
            System.out.print(element + " ");

        scanner.close();
    }

    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()])
                nextGreater[stack.pop()] = arr[i];

            stack.push(i);
        }

        while (!stack.isEmpty())
            nextGreater[stack.pop()] = -1;

        return nextGreater;
    }
}
