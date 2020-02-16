# 移动零
> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/28/

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:
```
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```
说明:

* 必须在原数组上操作，不能拷贝额外的数组。
* 尽量减少操作次数。

### 思路分析
因为题目要求需要不拷贝额外数组，所以我们通过交换的方式移动数组。遍历原数组，找到0后，再去遍历后面的元素找到第一个不为0的数字，交换2个下标的值。
这种方式因为需要嵌套循环，所以不算快的方式。还可以考虑只要把0全放后面就行，所以统计只要不为0的都往前面放，后面的填充0就好了，这样只要2次循环无嵌套，O(N)。

### 代码展示
我的代码（交换元素）：
```java
public void moveZeroes(int[] nums) {
    int i = 0, j = 0;
    for(; i<nums.length; i++) {
        if(nums[i] == 0) {
            for(j=i+1; j<nums.length; j++) {
                if(nums[j] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
        }
    }
}
```
非零直接前置，后面的全填充0：
```java
public void moveZeroes(int[] nums) {
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[index] = nums[i];
            index += 1;
        }
    }
    for (int i = index; i < nums.length; i++) {
        nums[i] = 0;
    }
}
```
