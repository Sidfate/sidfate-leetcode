# 实现 strStr()

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/38/

实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:
```
输入: haystack = "hello", needle = "ll"
输出: 2
```
示例 2:
```
输入: haystack = "aaaaa", needle = "bba"
输出: -1
```
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

### 思路分析
首先说下一个搞笑的事，在我完成这题的时候，我的耗时是 3ms，我看了第一名的答案：
```java
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
```
直接用了java自带的方法，那我不如去看java源码。

回来说下我的思路，我的想法是：
1. 在 haystack 中找 needle[0] 的位置 index，如果找不到，返回 -1，找到了继续2。
2. 从 index 开始遍历字符，遍历长度为 j = 1~needle.length()，依次比较 haystack[index+j] 和 needle[j]，如果遇到不相等就退出，继续1，否则继续3
3. 判断遍历长度 j 是不是等于needle长度，如果相等说明找到了，返回 index，否则继续1。
   
### 代码展示
我的代码：
```java
public int strStr(String haystack, String needle) {
    if(needle.length() == 0) {
        return 0;
    }
    int len = haystack.length() - needle.length();
    if(len < 0) {
        return -1;
    }

    int i = 0, j = 1;
    for(char ch: needle.toCharArray()) {
        if(-1 == haystack.indexOf(ch)) {
            return -1;
        }
    }
    while(i<haystack.length()) {
        int index = haystack.indexOf(needle.charAt(0), i);
        if(index == -1 || len < index) {
            return -1;
        }
        for(j=1; j<needle.length(); j++) {
            if(haystack.charAt(index+j) != needle.charAt(j)) {
                break;
            }
        }
        if(j == needle.length()) {
            return index;
        }
        i = index+1;
    }

    return -1;
}
```

java 原生 indexOf 实现：
```java
public int indexOf(String str) {
    return indexOf(str, 0);
}
public int indexOf(String str, int fromIndex) {
    return indexOf(value, 0, value.length,
            str.value, 0, str.value.length, fromIndex);
}
/**
    * Code shared by String and StringBuffer to do searches. The
    * source is the character array being searched, and the target
    * is the string being searched for.
    *
    * @param   source       the characters being searched.
    * @param   sourceOffset offset of the source string.
    * @param   sourceCount  count of the source string.
    * @param   target       the characters being searched for.
    * @param   targetOffset offset of the target string.
    * @param   targetCount  count of the target string.
    * @param   fromIndex    the index to begin searching from.
    */
static int indexOf(char[] source, int sourceOffset, int sourceCount,
        char[] target, int targetOffset, int targetCount,
        int fromIndex) {
    if (fromIndex >= sourceCount) {
        return (targetCount == 0 ? sourceCount : -1);
    }
    if (fromIndex < 0) {
        fromIndex = 0;
    }
    if (targetCount == 0) {
        return fromIndex;
    }

    char first = target[targetOffset];
    int max = sourceOffset + (sourceCount - targetCount);

    for (int i = sourceOffset + fromIndex; i <= max; i++) {
        /* Look for first character. */
        if (source[i] != first) {
            while (++i <= max && source[i] != first);
        }

        /* Found first character, now look at the rest of v2 */
        if (i <= max) {
            int j = i + 1;
            int end = j + targetCount - 1;
            for (int k = targetOffset + 1; j < end && source[j]
                    == target[k]; j++, k++);

            if (j == end) {
                /* Found whole string. */
                return i - sourceOffset;
            }
        }
    }
    return -1;
}
```