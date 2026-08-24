import java.util.Scanner;

public class AssignmentP4 {

    public static String toTitleCase(String name) {
        String[] words = name.trim().toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1))
                  .append(" ");
        }

        return result.toString().trim();
    }

    public static String maskEmail(String email) {
        int at = email.indexOf("@");
        if (at <= 3)
            return email;

        String first = email.substring(0, 3);
        String stars = "*".repeat(at - 3);

        return first + stars + email.substring(at);
    }

    public static String reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse())
                  .append(" ");
        }

        return result.toString().trim();
    }

    public static int countVowels(String sentence) {
        int count = 0;

        for (char c : sentence.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Sentence: ");
        String sentence = sc.nextLine();

        String formattedName = toTitleCase(fullName);

        String maskedEmail = maskEmail(email);

        boolean validEmail = email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

        String reversed = reverseWords(sentence);

        int vowels = countVowels(sentence);

        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println("\n------ OUTPUT ------");
        System.out.println("Formatted Name : " + formattedName);
        System.out.println("Masked Email : " + maskedEmail);
        System.out.println("Valid Email : " + validEmail);
        System.out.println("Reversed Words : " + reversed);
        System.out.println("Vowel Count : " + vowels);

        System.out.println("\nString Comparison");
        System.out.println("Using == : " + (s1 == s2));
        System.out.println("Using equals() : " + s1.equals(s2));

        sc.close();
    }
}