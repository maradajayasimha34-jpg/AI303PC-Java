import java.util.Arrays;
import java.util.Scanner;

public class ChunkArray {
    public static int[][] chunkArray(int[] nums, int chunk) {
        int flag = 0;
		int [][] ret = new int[nums.length/chunk][chunk];
		for(int i=0;i<nums.length;i+=chunk){
			for(int j=0;j<chunk;j++){
				ret[flag][j] = nums[i+j];
			}
			flag++;
		}
        return ret;
    }

    public static void main(String[] args){
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter size of array:");
            int size = s.nextInt();

            int[] nums = new int[size];
            System.out.println("Enter the elements of array:");
            for(int i=0;i<size;i++){
                nums[i]=s.nextInt();
            }
            System.out.println("Enter the chunk size:");
            int chunk = s.nextInt();
            int mat[][] = (chunkArray(nums, chunk));
            for(int i=0;i<mat.length;i++){
                System.out.println(Arrays.toString(mat[i]));
            }
        }
    }

}