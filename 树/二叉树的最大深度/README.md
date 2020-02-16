# 二叉树的最大深度

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/47/

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，
```
    3
   / \
  9  20
    /  \
   15   7
```
返回它的最大深度 3 。

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
