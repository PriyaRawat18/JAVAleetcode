/*Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 */

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
class Solution {
    
    public boolean helper(TreeNode l, TreeNode r ){
        if(r==null && l==null) return true;
        if((r==null && l!= null )||(l==null &&  r!= null ))  return false;
        
        return (l.val == r.val) && helper(l.left,r.right ) && helper(l.right,r.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right );
    }
}
