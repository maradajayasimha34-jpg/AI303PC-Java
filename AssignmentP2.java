import java.util.Scanner;

public class AssignmentP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter a character to search: ");
        char ch = sc.next().charAt(0);

        sentence = sentence.trim();

        String[] words = sentence.split("\\s+");

        System.out.println("\nWord Count : " + words.length);

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        System.out.println("First Word : " + firstWord);
        System.out.println("Last Word : " + lastWord);

        String firstWordUsingSubstring = sentence.substring(0, sentence.indexOf(" "));
        String lastWordUsingSubstring =
                sentence.substring(sentence.lastIndexOf(" ") + 1);

        System.out.println("First Word (substring): " + firstWordUsingSubstring);
        System.out.println("Last Word (substring): " + lastWordUsingSubstring);

        int firstIndex = sentence.indexOf(ch);
        int lastIndex = sentence.lastIndexOf(ch);

        System.out.println("First '" + ch + "' index : " + firstIndex);
        System.out.println("Last '" + ch + "' index : " + lastIndex);

        int comparison = firstWord.compareTo(lastWord);
        System.out.println("Comparison (first vs last word): " + comparison);

        char[] arr = sentence.toCharArray();
        System.out.println("First Character : " + arr[0]);
        System.out.println("ASCII Value : " + (int) arr[0]);

        System.out.println("Character using charAt(0): " + sentence.charAt(0));

        System.out.println("String.valueOf(first char): " +
                String.valueOf(arr[0]));

        sc.close();
    }
}