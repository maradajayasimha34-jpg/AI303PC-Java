import java.util.Scanner;

class Lab2Prog4 {

    public static void main(String... arg) {
        int[] x = new int[5];
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < x.length; i++) {
            x[i] = s.nextInt();
        }

        for (int v : x)
            System.out.print(v + "  ");

    }
}
