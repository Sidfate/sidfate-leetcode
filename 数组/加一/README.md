# 加一
> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/27/

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
```
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
```
示例 2:
```
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
```

### 思路分析
这题是明显的陷进题，主要就是在进位的问题上，如果数字是9，那么就需要考虑进位。我想了2种方法：
* 一种是循环进位，就是从后往前判断9，直到进位结束。进位结束要么是已经遍历到头，例如99这样的数字，最后结果是100，要么就是在中间不需要进位，例如169，结果是170。
* 第二种是将数组转化成数字，10进制累加，然后直接数字+1，再将数字转数组。

### 代码展示
我的代码（循环进位）：
```java
public int[] plusOne(int[] digits) {
    int len = digits.length;
    
    if(digits[len-1] != 9) {
        digits[len-1] += 1;
        return digits;
    }else {
        digits[len-1] = 0;
    }
    int i = len-2;
    while(i >= 0) {
        if(digits[i] != 9) {
            digits[i] += 1;
            break;
        }
        digits[i] = 0;
        i--;
    }
    if(digits[0] != 0) {
        return digits;
    }
    int[] nums = new int[len+1];
    for(i=1; i<len+1; i++) {
        nums[i] = 0;
    }
    nums[0] = 1;
    return nums;
}
```

