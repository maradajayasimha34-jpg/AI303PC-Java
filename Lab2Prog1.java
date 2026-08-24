import java.util.Scanner;

class Lab2Prog1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a number");
        int x = s.nextInt();

        System.out.println("Enter another number");
        int y = s.nextInt();

        int check = x / y;
        System.out.println(check);
    }
}
