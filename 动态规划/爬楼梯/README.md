# 爬楼梯

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/23/dynamic-programming/54/

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：
```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```
示例 2：
```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```
### 思路分析
这题的解法有很多，常见的就是递归和动态规划。我首先重试了用递归：
```java
public int climbStairs(int n) {
    if (n == 1) return 1;
	if (n == 2) return 2;
	return climbStairs(n - 1) + climbStairs(n - 2);
}
```
很好理解，我们要是想上n这个台阶，我们要么是在 n-1 这个台阶上，要么是在 n-2 这个台阶上。但是这个方法没通过测试，因为递归速度太慢了，需要不断的创建方法的堆栈，所以改用动态规划的思路。
所谓的动态规划，在我理解上就是拆分子问题的做法，然后通过解决相对清晰子问题完成大问题。所以我们这里可以借助一个数组，记录从 1-n 的方法数，数组第 i 的值等于第i-1的值加上第i-2的值。

### 代码展示
递归（没通过，超时）：
```java
public int climbStairs(int n) {
    if (n == 1) return 1;
	if (n == 2) return 2;
	return climbStairs(n - 1) + climbStairs(n - 2);
}
```

动态规划：
```java
public int climbStairs(int n) {
    if (n <= 2) return n;
	
    int sum[] = new int[n];
    sum[0] = 1;
    sum[1] = 2;
    for (int i = 2; i < n; i++) {
        sum[i] = sum[i - 1] + sum[i - 2];
    }
    return sum[n - 1];
}
```
