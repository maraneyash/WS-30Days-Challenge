import java.util.Scanner;

public class CountOccurrences {
    public static int countOccurrences(int[] arr, int x) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == x)
                count++;
            else if (arr[i] > x)
                break;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the sorted array: ");
        int size = input.nextInt();

        int[] sortedArray = new int[size];
        System.out.println("Enter " + size + " sorted elements:");
        for (int i = 0; i < size; i++) {
            sortedArray[i] = input.nextInt();
        }

        System.out.print("Enter the value of element x: ");
        int x = input.nextInt();

        input.close();

        int occurrences = countOccurrences(sortedArray, x);
        System.out.println("Number of occurrences of " + x + " in the array: " + occurrences);
    }
}
