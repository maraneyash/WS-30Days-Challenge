import java.util.Scanner;

public class ArrayRotation {

    public static void rotateArray(int[] arr, int n) {

        int length = arr.length;
        n %= length;

        reverseArray(arr, 0, length - 1);

        reverseArray(arr, 0, n - 1);

        reverseArray(arr, n, length - 1);
    }

    public static void reverseArray(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++)
            arr[i] = input.nextInt();

        System.out.print("Enter the value of n (number of rotations): ");
        int n = input.nextInt();

        input.close();

        rotateArray(arr, n);

        System.out.println("Rotated Array:");
        for (int num : arr)
            System.out.print(num + " ");
    }
}
