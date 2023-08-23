import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseKElementsInQueue {
    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 0 || k > queue.size())
            return;

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> tempQueue = new LinkedList<>();

        for (int i = 0; i < k; i++)
            stack.push(queue.poll());

        while (!queue.isEmpty())
            tempQueue.offer(queue.poll());

        while (!stack.isEmpty())
            queue.offer(stack.pop());

        while (!tempQueue.isEmpty())
            queue.offer(tempQueue.poll());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the queue: ");
        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        System.out.println("Enter the elements of the queue:");
        for (int i = 0; i < n; i++)
            queue.offer(scanner.nextInt());

        System.out.print("Enter k (number of elements to reverse): ");
        int k = scanner.nextInt();

        reverseKElements(queue, k);

        System.out.println("Queue after reversing the first " + k + " elements:");
        while (!queue.isEmpty())
            System.out.print(queue.poll() + " ");

        scanner.close();
    }
}
