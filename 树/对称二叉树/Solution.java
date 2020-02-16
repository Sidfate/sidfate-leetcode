import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean flag = true;

    public boolean isSymmetric(TreeNode root) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        prevTraverse(root, l1);
        flag = false;
        nextTraverse(root, l2);

        for(int i=0; i<l1.size(); i++) {
            System.out.println(l1.get(i) + "--" + l2.get(i));
            // if(l1.get(l1.size()-1-i) != l2.get(i)) 
            //     return false;
        }
        return true;
    }

    public void midTraverse(TreeNode root, List<Integer> l) {
        if(root == null) return;
        if(root.left == null && root.right != null) {
            root.left = new TreeNode(-1);
        }
        if(root.right == null && root.left != null) {
            root.right = new TreeNode(-1);
        }
        if(flag)
            midTraverse(root.left, l);
        else 
            midTraverse(root.right, l);
        l.add(root.val);
        if(flag)
            midTraverse(root.right, l);
        else
            midTraverse(root.left, l);
    }

    public void prevTraverse(TreeNode root, List<Integer> l) {
        if(root == null) return;
        if(root.left == null && root.right != null) {
            root.left = new TreeNode(-1);
        }
        if(root.right == null && root.left != null) {
            root.right = new TreeNode(-1);
        }
        
        l.add(root.val); 
        midTraverse(root.left, l);
        midTraverse(root.right, l);
    }

    public void nextTraverse(TreeNode root, List<Integer> l) {
        if(root == null) return;
        if(root.left == null && root.right != null) {
            root.left = new TreeNode(-1);
        }
        if(root.right == null && root.left != null) {
            root.right = new TreeNode(-1);
        }
        
        midTraverse(root.right, l);
        midTraverse(root.left, l);
        l.add(root.val); 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.initTree();

        // solution.preTraverse(root.left);
        
        // solution.nextTraverse(root.right);
        boolean result = solution.isSymmetric(root);
        System.out.println("是不是对称二叉树:" + result);
    } 

    public TreeNode initTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(2);
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(2);
        // root.left.left = new TreeNode(2);
        // root.right.left = new TreeNode(2);
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);
        // root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(3);
        return root;
    }
}