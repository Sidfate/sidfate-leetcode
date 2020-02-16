import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 
    3
   / \
  9  20
    /  \
   15   7
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
			return null;
        }
        List<List<Integer>> floors = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.offer(root);
        list.offer(root.val);
		while (!queue.isEmpty()) {
            if(queue.size() == 1) {
                floors.add(list);
                list = new LinkedList<>();
            }
			TreeNode node = queue.poll();
			if (node.left != null) {
                queue.offer(node.left);
                list.offer(node.left.val);
			}else {
                list.offer(null);
            }
			if (node.right != null) {
                queue.offer(node.right);
                list.offer(node.right.val);
			}else {
                list.offer(null);
            }
        }

        for(int i=0; i<floors.size(); i++) {
            for(int j=0; j<floors.get(i).size() ;j++) {
                System.out.println(floors.get(i).get(j));
            }
            System.out.println("----");
        }
        
        return floors;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.initTree();
        List<List<Integer>> result = solution.levelOrder(root);
        
    } 

    public TreeNode initTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        return root;
    }

}