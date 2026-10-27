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

    static int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        int result=find(root)-1;
        return Math.max(max, result);
    }

    public int find(TreeNode root){
        if(root.left==null && root.right==null)
            return 1;

        int left=0,right=0;

        if(root.left!=null)
            left=find(root.left);
        if(root.right!=null)
            right=find(root.right);

        max=Math.max(max,left+right);

        return 1+Math.max(left,right);
    }
}