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

import java.util.*;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int result = root.val;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result = node.val;

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
        }

        return result;
    }
}
