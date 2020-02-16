# 外观数列

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/39/

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```
* 1 被读作  "one 1"  ("一个一") , 即 11。
* 11 被读作 "two 1s" ("两个一"）, 即 21。
* 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。


给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。

示例 1:
```
输入: 1
输出: "1"
解释：这是一个基本样例。
```
示例 2:
```
输入: 4
输出: "1211"
解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
```

### 思路分析
典型的递归题型，想知道第n项的表达式必须先知道第n-1项的表达式。问题在于如果计算一个字符串的外观数列：遍历字符串，比较当前字符和下一个字符的值是否相等，如果相等那么设置step+1（step默认为1），如果不相等，那么输出字符串 step + str[index]。
递归相对而言就是速度会慢一点，好处是可以让别人看不懂，我看了速度快的几个答案都是用的循环实现，所以下面代码我给出2种实现。

### 代码展示
我的代码（递归）：
```java
public String countAndSay(int n) {
    if(n == 1) {
        return "1";
    }else {
        return say(countAndSay(n-1));
    }
}

public String say(String str) {
    int len = str.length();
    String res = "";
    int step = 1;
    if(len == 1) return "11";
    for(int i=0; i<len-1; i++) {
        if(str.charAt(i) == str.charAt(i+1)) {
            step++;
        }else {
            res += "" + step + str.charAt(i);
            step = 1;
        }
        if(i == len - 2) {
            res += "" + step + str.charAt(len - 1);
            break;
        }
    }

    return res;
}
```

循环方式：
```java
public String countAndSay(int n) {
    String res = "1";
    for(int i = 0; i < n - 1; i++) {
        res = descriptor(res);
    }
    return res;
}

public String descriptor(String s) {
    StringBuilder sb = new StringBuilder();
    int counter = 0;
    char c = s.charAt(0);
    for(int i = 0; i < s.length(); i++) {
        if(c == s.charAt(i)) {
            counter++;
        } else {
            sb.append(counter);
            sb.append(c);
            c = s.charAt(i);
            counter = 1;
        }
    }        
    sb.append(counter);
    sb.append(c);
    return sb.toString();
}
```

