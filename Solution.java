import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int i=0;
        int j = 0;
        int[] ret = new int[2];
        for(i=0;i<nums.length;i++){
            for(j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    if(i!=j){
                        ret[0]=i;
                        ret[1]=j;
                    }
                    
                }
            }
        }
       
        return ret;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = s.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<size;i++){
            nums[i]=s.nextInt();
        }
        System.out.println("Enter the target:");
        int target = s.nextInt();
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}