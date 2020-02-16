# 验证回文字符串

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/36/

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

### 思路分析
这题没有需要详细说明的地方，首尾指针一起往中间遍历，首指针不断++，尾指针--，首尾指针只要遇到不符合的字符就++，尾指针同理--，判断完字符后也++和--。

### 代码展示
我的代码：
```java
public boolean isPalindrome(String s) {
    if(s.isEmpty()) return true; 
    int i = 0, j = s.length()-1;
    while(i <= j) {
        char head = s.charAt(i);
        char tail = s.charAt(j);

        int headState = getState(head);
        int tailState = getState(tail);

        if(headState == -1 || tailState == -1) {
            if(headState == -1) i++;
            if(tailState == -1) j--;
            continue;
        }
        if(headState == 2) head -= 32;
        if(tailState == 2) tail -= 32;
        if(head != tail) return false;
        i++;
        j--;
    }

    return true;
}
```

