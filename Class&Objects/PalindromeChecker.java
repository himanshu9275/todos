class PalindromeChecker {
    String text;

    // Method to check palindrome
    boolean isPalindrome() {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = cleaned.length() - 1;

        while (i < j) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + text + "\" is NOT a Palindrome.");
        }
    }
}

public class PalindromeCheckerTest {
    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker();
        pc.text = "Level";

        pc.displayResult();
    }
}
