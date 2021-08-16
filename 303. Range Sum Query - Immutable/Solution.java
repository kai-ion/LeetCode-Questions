import java.util.*;
public class Solution {
    static class NumArray {
        List<Integer> list = new ArrayList<>();
       public NumArray(int[] nums) {
           for(int i=0;i<nums.length;i++)
               list.add(nums[i]);
       }
       public int sumRange(int left, int right) {
           int sum = 0;
           for (int i = left; i <= right; i++) {
               sum += list.get(i);
           }
           return sum;
       }
   }

   //driver
   public static void main(String[] args) {
    int[] x = {-2, 0, 3, -5, 2, -1}; 
    int left = 0, right = 2;
    NumArray numArray = new NumArray(x);
    System.out.println(numArray);
    System.out.println(numArray.sumRange(left, right));
    }
    
}
