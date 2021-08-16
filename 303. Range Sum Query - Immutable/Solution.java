import java.util.*;
public class Solution {
    /**
     * Naive solution
     */
    /*static class NumArray {
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
   }*/

   /**
    * Prefix solution
    precalculate sums when first declaring array, then subtract left and right pointers
    Time:
        Constructor: O(N)
        sumRange(left, right): O(1)
    Space: O(1)
    */
   static class NumArray {
    int[] preSum;
   public NumArray(int[] nums) {
       preSum = nums;
       for(int i = 1;i < nums.length;i++)
           preSum[i] = preSum[i-1] + nums[i];
   }
   public int sumRange(int left, int right) {
       if (left == 0) return preSum[right];
       return preSum[right]-preSum[left-1];
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
