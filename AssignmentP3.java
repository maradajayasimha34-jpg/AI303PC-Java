import java.util.Arrays;

public class AssignmentP3 {

    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverse = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reverse);
    }

    public static boolean isAnagram(String str1, String str2) {
        String s1 = str1.replaceAll("\\s+", "").toLowerCase();
        String s2 = str2.replaceAll("\\s+", "").toLowerCase();

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {

        String str1 = "A man a plan a canal Panama";
        String str2 = "listen";
        String str3 = "silent";

        String cleaned = str1.replaceAll("[^a-zA-Z0-9]", "");

        boolean palindrome = isPalindrome(str1);

        boolean anagram = isAnagram(str2, str3);

        boolean valid = cleaned.matches("[a-zA-Z0-9]+");

        boolean containsPlan = str1.toLowerCase().contains("plan");

        String report = String.format(
                "[Palindrome: %b | Anagram: %b]",
                palindrome,
                anagram);

        String output = String.join("\n",
                "Palindrome Check : \"" + str1 + "\" -> " + palindrome,
                "Anagram Check : \"" + str2 + "\" & \"" + str3 + "\" -> " + anagram,
                "Regex Validation : " + valid,
                "Contains 'plan' : " + containsPlan,
                "Formatted Report : " + report);

        System.out.println(output);

        String s1 = new String("Java");
        String s2 = new String("Java");

        String i1 = s1.intern();
        String i2 = s2.intern();

        System.out.println("\nHashCode 1 : " + i1.hashCode());
        System.out.println("HashCode 2 : " + i2.hashCode());
        System.out.println("HashCodes equal for interned strings : "
                + (i1.hashCode() == i2.hashCode()));
    }
}