# 有效的括号

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/26/others/68/

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。
   
注意空字符串可被认为是有效字符串。

示例 1:
```
输入: "()"
输出: true
```
示例 2:
```
输入: "()[]{}"
输出: true
```
示例 3:
```
输入: "(]"
输出: false
```
示例 4:
```
输入: "([)]"
输出: false
```
示例 5:
```
输入: "{[]}"
输出: true
```

### 思路分析
我用了递归的思路，没有用到额外的数据结构，就在原字符串上比那里。首先我们宏观的来看这个问题，假如给定了一个字符串：

```
[...]{...}(...)
```

如果 ... 也是满足有效条件的话，上面的字符串我们也可以认定为有效，再简单点，其实那=哪种括号也没所谓，我们如果把括号转换成只有一种，题目就更清晰了：

```
将括号全部转化为{}
{...}
```
那么问题来了，我们怎么去找到开括号的闭括号，例如开括号的 '{' 对应闭括号是 '}'。从最简单的开始，我们认为下面的是有效的括号：
```
{}
{{}}
{}{}
```
所以我们可以得出如何认定有效的结论：
1. 能找到一个闭括号，并且只有1个。
2. 能找到n个闭括号，并且在第一个闭括号前还有n-1个开括号（出开头外）。
3. 能找到n个闭括号，并且在第一个开括号（出开头外）出现在第一个闭括号之后，以此类推。

换成代码的形式看下面我的代码。

另外，这题使用栈的结构是最简单的。**栈顶需要等于闭括号**，如果不等于说明无效。


### 代码展示
我的代码（循环）：
```java
char[] chars = new char[]{'(', '[', '{', '}', ']', ')'};
public boolean isValid(String s) {
    if(s == null || s.isEmpty()) return true;

    char ch = s.charAt(0);
    int i = getChar(ch);
    int first = s.indexOf(ch, 1);
    int j = s.indexOf(chars[5-i]);
    if(first != -1 && first < j) {
        j = s.lastIndexOf(chars[5-i]);
    }
    if(j == -1) {
        return false;
    }
    return isValid(s.substring(1, j)) && isValid(s.substring(j+1));
}

public int getChar(char ch) {
    switch(ch) {
        case '(':
            return 0;
        case ')':
            return 5;
        case '[':
            return 1;
        case ']':
            return 4;
        case '{':
            return 2;
        case '}':
            return 3;
    }
    return -1;
}
```

栈实现：
```java
public boolean isValid(String s) {
    if(s == "" || s.length() == 0)
        return true;

    Stack stack = new Stack();
    stack.push(s.charAt(0));

    for(int i=1; i<s.length(); i++){
        if(!stack.isEmpty()){
            if(stack.peek().equals((char)(s.charAt(i)-1)) || stack.peek().equals((char)(s.charAt(i)-2))){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }else {
            stack.push(s.charAt(i));
        }
    }

    if(stack.isEmpty())
        return true;

    return false;
}
```

