import java.util.Scanner;

public class VowelConsonantCount {

    // Method to check character type
    public static String classifyChar(char ch) {
        // Convert uppercase to lowercase using ASCII logic
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // A(65) -> a(97)
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to count vowels and consonants, return int[]{vowelCount, consonantCount}
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String type = classifyChar(ch);

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int[] counts = countVowelsAndConsonants(text);

        System.out.println("Number of vowels     : " + counts[0]);
        System.out.println("Number of consonants : " + counts[1]);
    }
}
