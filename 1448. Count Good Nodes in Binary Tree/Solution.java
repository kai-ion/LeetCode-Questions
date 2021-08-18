import java.util.*;
public class Solution {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    int count = 0;
    public int goodNodes(TreeNode root) 
    {
        util(root , Integer.MIN_VALUE);
        return count;
    }
    void util(TreeNode root , int max)
    {
        if(root==null)
            return;
        
        if(root.val>=max)
            count++;
        
        util(root.left , Math.max(max , root.val));
        util(root.right , Math.max(max , root.val));
    }
}
    
