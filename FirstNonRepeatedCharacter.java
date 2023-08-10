import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatedCharacter {

    public static char findFirstNonRepeatedChar(String str) {

        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (char c : str.toCharArray())
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);

        for (char c : str.toCharArray()) {
            if (charFrequencyMap.get(c) == 1)
                return c;
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        char result = findFirstNonRepeatedChar(inputString);

        if (result != '\0')
            System.out.println("First non-repeated character: " + result);
        else
            System.out.println("No non-repeated character found.");

        scanner.close();
    }
}
