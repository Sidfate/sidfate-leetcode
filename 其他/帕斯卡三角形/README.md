# 帕斯卡三角形

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/26/others/67/

给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

![](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
```
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

### 思路分析
我用java实现感觉最简单的就是排个序然后比较下下标和对应的值是否相等，不相等就是缺的那个数。

最简单快速的是用异或来实现，不停的异或下标和下标的值，因为下标和下标的值范围都是 0-n，两个相同的数异或为0，0与值异或就是值本身，所有最后剩下的一定是缺少的那个值：

```
1 ^ 0 = 1
0 ^ 1 ^ 2 ... ^ 0 ^ 1 ^ 2... = 缺少的值
```

### 代码展示
我的代码：
```java
public int missingNumber(int[] nums) {
    Arrays.sort(nums);
    if(nums[nums.length - 1] != nums.length) return nums.length;

    for(int i=0; i<nums.length+1; i++) {
        if(i != nums[i]) {
            return i;
        }
    }
    return 0;
}
```

异或实现：
```java
public int missingNumber(int[] nums) {
    int res = nums.length;
    for(int i = 0; i <  nums.length; i++){
        res ^= nums[i] ^ i;
    }
}     
```

