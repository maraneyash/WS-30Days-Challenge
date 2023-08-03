import java.util.*;

public class SubarrayWithGivenSum {
    public static int[] findSubarrayWithSum(int[] arr, int targetSum) {

        int n = arr.length;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            while (currentSum > targetSum) {
                currentSum -= arr[left];
                left++;
            }

            if (currentSum == targetSum) {
                int[] subarray = Arrays.copyOfRange(arr, left, right + 1);
                return subarray;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++)
            arr[i] = input.nextInt();

        System.out.print("Enter the value of target sum: ");
        int targetSum = input.nextInt();

        input.close();

        int[] subarray = findSubarrayWithSum(arr, targetSum);
        if (subarray.length > 0)
            System.out.println("Subarray with sum " + targetSum + ": " + Arrays.toString(subarray));
        else
            System.out.println("No subarray found with sum " + targetSum);
    }
}
