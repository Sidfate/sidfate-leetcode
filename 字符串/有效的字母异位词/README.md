# 有效的字母异位词

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/35/

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:
```
输入: s = "anagram", t = "nagaram"
输出: true
```
示例 2:
```
输入: s = "rat", t = "car"
输出: false
```
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

### 思路分析
如果你完成了《字符串中第一个唯一字符》，本题的思路就很清晰了。我们仍然定义一个长度为26的int数组用来充当字母表，即下标0代表a，下标25代表z。然后根据字符串长度遍历字符串，s的字符串的字符在数组中+1，t的字符串的字符在数组中-1。如果2个字符串是字母异位词，说明他们的字母一模一样，那么最终这个字母表数组的值应该都为0。

### 代码展示
我的代码：
```java
public boolean isAnagram(String s, String t) {
    int[] chars = new int[26];
    int i = 0;

    if(s.length() != t.length()) {
        return false;
    }
    for(; i<s.length(); i++) {
        chars[s.charAt(i)-'a']++;
        chars[t.charAt(i)-'a']--;
    }
    for(i=0; i<26; i++) {
        if(chars[i] != 0) {
            return false;
        }
    }

    return true;
}
```

