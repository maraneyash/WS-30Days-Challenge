import java.util.HashMap;
import java.util.Scanner;

public class RomanToDecimal {
    public static int romanToDecimal(String roman) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int decimalValue = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = romanValues.get(roman.charAt(i));
            if (currentValue >= prevValue) {
                decimalValue += currentValue;
            } else {
                decimalValue -= currentValue;
            }
            prevValue = currentValue;
        }

        return decimalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase();

        int decimalValue = romanToDecimal(romanNumeral);
        System.out.println("Decimal value: " + decimalValue);

        scanner.close();
    }
}
