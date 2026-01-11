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
    int max = 0;
    public int maxDepth(TreeNode root) {
        md(root, 1);
        return max;
    }
    public void md(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if(level>max){
            max=level;
        }
        md(root.left, level + 1);
        md(root.right, level + 1);
    }
}