# 汉明距离

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/26/others/65/

两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:
```
输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
```

### 思路分析
也是位运算的题，需要只要异或操作 ^：
```
0 ^ 1 = 1
1 ^ 1 = 0
1 ^ 0 = 1
```
所以通过异或可以判断是不是要累加汉明距离。


### 代码展示
我的代码：
```java
public int hammingDistance(int x, int y) {
    int a = x ^ y, count = 0;
    String b = Integer.toBinaryString(a);
    
    for(char ch: b.toCharArray()) {
        if(ch == '1') count++;
    }
    return count;
}
```
完全的位运算：
```java
public int hammingDistance(int x, int y) {
    int z = x^y;
    int sum = 0;
    while(z!=0) {
        sum += (z&1);
        z = z>>1;
    }
    return sum;
}
```
