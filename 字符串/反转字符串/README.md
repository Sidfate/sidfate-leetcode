# 从排序数组中删除重复项

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/32/

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

 
示例 1：
```
输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
```
示例 2：
```
输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
```

### 思路分析
简单的题目所以有很多解法，我只给出我觉得最快的一块，就是首尾交换直到之间，这样只需要遍历一半的数组。

### 代码展示
我的代码：
```java
public void reverseString(char[] s) {
    int len = s.length;
    for(int i=0; i<len; i++) {
        if(len/2 - 1 < i) {
            break;
        }
        
        char tmp = s[i];
        s[i] = s[len -1 - i];
        s[len -1 - i] = tmp;
    }
}

```

