# 整数反转

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/33/

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
```
输入: 123
输出: 321
```
示例 2:
```
输入: -123
输出: -321
```
示例 3:
```
输入: 120
输出: 21
```
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

### 思路分析
整数翻转相当于是一个不断除10，余数不断乘以10后累加的过程。举个例子：
```
数字 123 翻转
123 / 10 = 12 余 3，得 3；
12 / 10 = 1 余 2，计算 3*10 + 2 得 32；
1 / 10 = 0 余 1，计算 32*10 + 1 的 321；
```
另外需要注意的是溢出得0的情况。

### 代码展示
我的代码：
```java
public int reverse(int x) {
    int ans = 0;
    while(x != 0){
        int pop = x % 10;
        x = x / 10;
        if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
        if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

        ans = ans * 10 + pop;
    }
    return ans;
}
```

