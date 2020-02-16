# 3的幂

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/25/math/62/

给定一个整数，写一个函数来判断它是否是 3 的幂次方。

示例 1:
```
输入: 27
输出: true
```
示例 2:
```
输入: 0
输出: false
```
示例 3:
```
输入: 9
输出: true
```
示例 4:
```
输入: 45
输出: false
```
进阶：
你能不使用循环或者递归来完成本题吗？

### 思路分析
正常思路就是不断的除以3然后判断商是不是等于1，网上找了个最简单的方法：

> 用到了数论的知识：3 的幂次的质因子只有 3。
题目要求输入的是 int 类型，正数范围是 0 – 2^31，在此范围中允许的最大的 3 的次方数为 3^19 = 1162261467 ，那么只要看这个数能否被 n 整除即可。

```java
return n > 0 && 1162261467 % n == 0;
```

### 代码展示
我的代码（循环）：
```java
public boolean isPowerOfThree(int n) {
    if(n==0) return false;
    while(n%3==0){
        n/=3;
    }
    return n==1;        
}
```
取巧的方法：
```java
public boolean isPowerOfThree(int n) {
    return n > 0 && 1162261467 % n == 0;    
}
```
