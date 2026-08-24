import java.util.Arrays;

public class ArrayComparision {
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
public static void main(String[] args){
        int[][] arr1 = {{1,2,3,4,5},{6,7,8,9,10}};
        int[][] arr2 = {{1,2,3,4,5},{6,7,8,8,10}};
         //System.out.println(arrComp(arr1,arr2));
        System.out.println(Arrays.deepEquals(arr1, arr2));
    }
    
}