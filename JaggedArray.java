import java.util.Scanner;

public class JaggedArray {
    public static void main(String[] args) {
        int[][] jaggedArray = new int[3][];
        
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println("Enter the size of row " + (i + 1) + ":");
            int size = s.nextInt();
            jaggedArray[i] = new int[size];
            System.out.println("Enter the elements of row " + (i + 1) + ":");
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = s.nextInt();
            }
        }

        System.out.println("Jagged array contents:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
        s.close();
    }
}
