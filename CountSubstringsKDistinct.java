import java.util.Scanner;

public class CountSubstringsKDistinct {
    public static int countSubstringsWithKDistinct(String s, int k) {
        int totalCount = 0;
        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int distinctCount = 0;
            for (int j = i; j < s.length(); j++) {
                if (charCount[s.charAt(j) - 'a'] == 0) {
                    distinctCount++;
                }
                charCount[s.charAt(j) - 'a']++;

                if (distinctCount == k) {
                    totalCount++;
                }
            }

            for (int j = 0; j < 26; j++) {
                charCount[j] = 0;
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        int result = countSubstringsWithKDistinct(inputString, k);
        System.out.println("Count of substrings with " + k + " distinct characters: " + result);

        scanner.close();
    }
}
