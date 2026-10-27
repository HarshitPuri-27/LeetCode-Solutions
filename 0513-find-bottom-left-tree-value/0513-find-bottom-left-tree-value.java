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
    int ans;
    int maxLevel=-1;

    public void bottom(TreeNode root,int  level){
        if(root==null) return;
        if(level>maxLevel){
            maxLevel=level;
            ans=root.val;
        } 
        bottom(root.left,level+1);
        bottom(root.right,level+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        bottom(root,0);
        return ans;
    }
}