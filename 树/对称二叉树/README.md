# 对称二叉树

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/49/

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
```
    1
   / \
  2   2
   \   \
   3    3
```
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

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
