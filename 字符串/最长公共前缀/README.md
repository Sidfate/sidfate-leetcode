# 最长公共前缀

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/40/

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:
```
输入: ["flower","flow","flight"]
输出: "fl"
```
示例 2:
```
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
```
说明:

所有输入只包含小写字母 a-z 。

### 思路分析
我的思路是先找出strs列表中长度最小的字符串，设置长度为min，然后遍历每个字符串，判断从0到min的字符想不想等，想等我用了 hashset 。
看了网上的答案，有一个是比较快的，就是循环整个列表，然后拿第一个字符串直接和其他字符串比较，用了 substring 函数，逐渐减少第一个字符串长度，这样到最后就是所有字符串的公共部分。

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

最快答案：
```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
        return "";
    }

    String temp = strs[0];
    int bounder = temp.length();

    for (int i = 0; i < strs.length; i++) {

        while(!strs[i].startsWith(temp.substring(0,bounder))){
            bounder --;
            if(bounder < 0){
                return "";
            }
        }
    }
    return temp.substring(0,bounder);                                                                     
}
```