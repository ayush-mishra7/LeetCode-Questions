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
class BSTIterator {

    Stack<TreeNode>st = new Stack<>();

    public BSTIterator(TreeNode root) {
        Leftpush(root);
    }

    private void Leftpush(TreeNode root){
        while(root!= null){
            st.push(root);
            root = root.left;

        }
    }


    
    public int next() {
        TreeNode temp = st.pop();
        Leftpush(temp.right);
        return temp.val;

    }
    
    public boolean hasNext() {
        return st.isEmpty()?false : true;
    }
}

