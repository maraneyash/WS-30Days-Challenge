import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountPairsWithSumK {
    public static int countPairsWithSum(int[] arr, int K) {

        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        for (int num : arr) {
            int complement = K - num;
            if (frequencyMap.containsKey(complement)) {
                count += frequencyMap.get(complement);

                if (complement == num)
                    count--;
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++)
            arr[i] = input.nextInt();

        System.out.print("Enter the value of sum k: ");
        int k = input.nextInt();

        input.close();

        int pairsCount = countPairsWithSum(arr, k);
        System.out.println("Number of pairs with sum " + k + ": " + pairsCount);
    }
}
