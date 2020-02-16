# 二叉树的层次遍历

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/50/

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7
```
返回其层次遍历结果：
```
[
  [3],
  [9,20],
  [15,7]
]
```

### 思路分析
遇到树的问题，很多情况下就是递归的过程，因为往往树的遍历都是探底再回溯的过程，符合递归的样子。然后递归其实看起来很像是伪代码，用语义化的逻辑不断调用自己。
或者转化为最小单元的逻辑，就是递归的逻辑。就像我们这里最大深度的问题。

### 代码展示
循环：
```java
public int maxDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }
    
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return left > right ? left+1: right+1;
}   
```
