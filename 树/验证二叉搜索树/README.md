# 验证二叉搜索树

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/48/

给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

* 节点的左子树只包含小于当前节点的数。
* 节点的右子树只包含大于当前节点的数。
* 所有左子树和右子树自身必须也是二叉搜索树。
示例 1:
```
输入:
    2
   / \
  1   3
输出: true
```
示例 2:
```
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
```

### 思路分析
在这道题上犯了一个典型的错误，我忽视了一个条件：
* 节点的左子树只包含小于当前节点的数。
* 节点的右子树只包含大于当前节点的数。

这就意味着像下面这样的二叉树不属于 BST。
```
        3
      /   \
    2     5
  /  \
1    4
```
因为 4 > 3 了，我以为只要判断每个节点下是不是符合大小的条件就好了，所以有了下面错误的代码：
```java
public boolean isValidBST(TreeNode root) {
    if(root.left == null && root.right == null) {
        return true;
    }

    if(root.left != null && root.val < root.left.val) {
        return false;
    }
    if(root.right != null && root.val > root.right.val) {
        return false;
    }

    boolean left = isValidBST(root.left);
    boolean right = isValidBST(root.right);
    return left && right;
}
```
因此此题告诉我们一定要全局的看题目和结构，要判断是不是符合二叉搜索树，需要把全部的节点按顺序遍历出来，判断遍历后的大小是不是有序的。另外这种遍历的方式也叫做中序遍历，即：左子节点->节点->右子节点。


### 代码展示
循环：
```java
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
```
