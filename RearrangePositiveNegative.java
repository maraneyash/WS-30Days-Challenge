import java.util.Arrays;
import java.util.Scanner;

public class RearrangePositiveNegative {

    public static void rearrangePositiveNegative(int[] arr) {

        int n = arr.length;
        int[] temp = new int[n];
        int negativeIndex = 0;
        int positiveIndex = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                temp[negativeIndex++] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0)
                temp[negativeIndex + positiveIndex++] = arr[i];
        }

        System.arraycopy(temp, 0, arr, 0, n);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++)
            arr[i] = input.nextInt();

        input.close();

        System.out.println("Original array: " + Arrays.toString(arr));

        rearrangePositiveNegative(arr);

        System.out.println("Rearranged array: " + Arrays.toString(arr));
    }
}
