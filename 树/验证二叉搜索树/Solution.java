import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverseTree(root, list);
        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public void traverseTree(TreeNode root, List<Integer> list) {
        if(root == null) return;
        traverseTree(root.left, list);
        list.add(root.val);
        traverseTree(root.right, list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.initTree();
        boolean valid = solution.isValidBST(root);
        System.out.println("是不是二叉搜索树:" + valid);
    } 

    public TreeNode initTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        return root;
    }

}