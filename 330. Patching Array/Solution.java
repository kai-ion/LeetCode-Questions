

/**
 * Iterating the nums[], and keeps adding them up, and we are getting a running sum. At any position, if nums[i] > sum+1, them we are sure we have to patch 
a sum+1 because all nums before index i can't make sum+1 even add all of them up, and all nums after index i are all simply too large.
 */
class Solution {
    public int minPatches(int[] nums, int n) {
       long sum = 0;
       int count = 0;
       for (int x : nums) {
           if (sum >= n) break;
           while (sum+1 < x && sum < n) { 
               ++count;
               sum += sum+1;
           }
           sum += x;
       }
       while (sum < n) {
           sum += sum+1;
           ++count;
       }
       return count;
   }
}