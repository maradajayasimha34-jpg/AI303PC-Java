import java.util.Scanner;

public class AssignmentP1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        str = str.trim();

        if (str.isEmpty()) {
            System.out.println("EMPTY STRING");
            return;
        }

        if (str.equalsIgnoreCase("admin")) {
            System.out.println("RESERVED WORD");
            return;
        }

        str = str.replace("_", " ");

        String lower = str.toLowerCase();

        if (lower.startsWith("temp") && lower.endsWith("user")) {
            str = str.concat(" FLAGGED");
        }
        System.out.println("Processed String: " + str);

        sc.close();
    }
}