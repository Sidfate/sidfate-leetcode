# 旋转数组
> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/23/

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:
```
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
```
示例 2:
```
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
```
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

### 思路分析
这题需要给出多种解答，我的直觉有2种解决方式：1 种是有公式直接计算每个位置在移动后值，相当于是总结规律；另一种是按步骤移动交换。这2种方式可以扩充多种解决方案。
简单说明下第一种里的规律，就是通过长度和移动距离计算当前索引上的值之前是在哪个索引上，例如长度为5的数组移动3次，那么index = 0的值应该存放的是原数组中index为 `|(5 + 0 - (3%5)) % 5| = 2` 的值。

```
index 0 1 2 3 4
value 1 2 3 4 5
移动 3 次后，index = 0 的值为 2 （原先 index = 2 的值）。
```


### 代码展示
我的代码：
```java
// 总结规律型
public void rotate(int[] nums, int k) {
        if(nums.length <= 1) {
            return;
        }
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int next = Math.abs((nums.length + i-(k%nums.length)) % nums.length);
            list.add(nums[next]);
        }
        for(int i=0; i<nums.length; i++) {
            nums[i] = list.get(i);
        }
    }

```
贪心算法代码：
```java
public int maxProfit(int[] price) {
    int maxPro = 0, tmp = 0;
        for (int i = 1; i < prices.length; ++i) {
            tmp = prices[i] - prices[i-1];
            if (tmp > 0) {
                maxPro += tmp;
            }
        }
        return maxPro;
}

```
