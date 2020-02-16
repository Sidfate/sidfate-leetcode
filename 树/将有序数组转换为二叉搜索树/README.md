# 将有序数组转换为二叉搜索树

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/51/

将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:
```
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
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
