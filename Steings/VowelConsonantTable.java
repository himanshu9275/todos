import java.util.Scanner;

public class VowelConsonantTable {

    // Same classification method
    public static String classifyChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
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

    // Method to analyze string and return 2D array [character, type]
    public static String[][] analyzeString(String text) {
        int n = text.length();
        String[][] result = new String[n][2];

        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = classifyChar(ch);
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("Char\tType");
        System.out.println("------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] analysis = analyzeString(text);
        displayTable(analysis);
    }
}
