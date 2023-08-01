import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {

            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = input.nextInt();
        }

        System.out.print("Enter the value of element k: ");
        int k = input.nextInt();

        input.close();

        int kthLargest = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + kthLargest);
    }
}
