# 存在重复

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/24/

给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:
```
输入: [1,2,3,1]
输出: true
```
示例 2:
```
输入: [1,2,3,4]
输出: false
```
示例 3:
```
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
```
### 思路分析
题目相对比较简单，列下我的思路：
1. 循环遍历原数组，依次将当前元素与剩余元素作比较，复杂度O(n^2)，这种最傻瓜的方式果然不行，我甚至尝试修改了判断相等的方式，改成了位运算 0==(x^y) ，还是超时。
2. 用 java 自带的集合结构，这个思想相当于开辟额外空间存放已经去重的数组或者每个数字出现的格式，你用 hashset 或者 hashmap 都可以成功。
3. 先讲原数组排序然后，依次比较，排序可以用低复杂度的，所以整体还是快的。

另外记录下往上的一种做法，是在一次遍历中完成，在遍历原数组的同时比较大小，然后判断相等。

### 代码展示

```java
public boolean containsDuplicate(int[] nums) {
    for (int i = 1; i < nums.length;i++){
        int j = i - 1;
        int temp = nums[j+1];
        while (j >= 0 && nums[j] > temp){
            nums[j+1] = nums[j];
            j--;
        }
        nums[j+1] = temp;
        if (j >= 0 && nums[j] == nums[j+1]){
            return true;
        }
    }
    return false;
}
```
