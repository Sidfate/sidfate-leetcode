import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left+1: right+1;
    }   

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.initTree();
        int depth = solution.maxDepth(root);
        System.out.println("二叉树深度:" + depth);
    } 

    public TreeNode initTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

}