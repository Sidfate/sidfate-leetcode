# 只出现一次的数字

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/25/

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
```
输入: [2,2,1]
输出: 1
```
示例 2:
```
输入: [4,1,2,1,2]
输出: 4
```
### 思路分析
这个题目也算是比较简单的，第一直觉像这种只有1个不重复，其他都有2个重复的情况很可能可以通过位运算来换算。求稳还是用了排序的方式，排序可以把重复的数字放在一起，所以排序后一个正常重复的数字旁边肯定有一个和自己重复的数字，按照这个思路就可以遍历出不重复的数字。

查了资料，上面的位运算确实可以，通过异或的方式，2个数如果相等那么异或的结果为 0，0与数字异或的结果就是数字本身。所以最终将所有数遍历完，一直异或的结果就是不重复的那个数。看到下面位运算的实现你就能直接为什么很多源码底层都会去考虑用位运算做一些计算，性能提升很大。
```
1 ^ 1 = 0
0 ^ 1 = 1
```

最后实践发现这题出题不是很严谨，因为按题目意思来说应该不需要考虑给定数组长度小于3的情况，但是实际提交还是要考虑到，这就产生了问题，如果数组长度为2，例如[1, 2]怎么办？我这边直接返回了第一个元素。

### 代码展示
我的代码：
```java
public int singleNumber(int[] nums) {
    int len = nums.length;
    Arrays.sort(nums);
    if(nums.length < 3) {
        return nums[0];
    }
    if(nums[0] != nums[1]) {
        return nums[0];
    }
    if(nums[len-1] != nums[len-2]) {
        return nums[len-1];
    }
    for(int i = 1; i < len; i++) {
        if(nums[i-1] != nums[i] && nums[i] != nums[i+1]) {
            return nums[i];
        }
    }
    return 0;   
}
```
位运算代码：
```java
public int singleNumber(int[] nums) {
    int res = 0;
    for (int i : nums) {
        res ^= i;
    }
    return res;
}
```
