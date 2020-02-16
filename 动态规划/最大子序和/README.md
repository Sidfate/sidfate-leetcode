# 最大子序和

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/23/dynamic-programming/56/

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

### 思路分析
想要获取前 i 个元素的最大序列，其实想想就是判断第 i-1 个元素的最大序列跟第 i 个元素的大小的比较，即：
```
sum[i] = max(sum[i-1] + a[i], a[i])
```
所以我们只要判断 sum[i-1] + a[i] 与 a[i] 的大小就ok了。获取到每一次序列的最大值，在通过一个全局变量一直取2者最大就获取到了整个序列的最大子序列。

### 代码展示
动态规划：
```java
public int maxSubArray(int[] nums) {
    int sum = nums[0], index = 0, tmp = nums[0];

    for(int i=1; i<nums.length; i++) {
        tmp += nums[i];
        if(tmp <= nums[i]) {
            tmp = nums[i];
        }
        sum = Math.max(sum, tmp);
    }

    return sum;
}
```