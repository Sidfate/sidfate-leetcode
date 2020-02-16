# Fizz Buzz

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/25/math/60/

写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果 n 是3的倍数，输出“Fizz”；

2. 如果 n 是5的倍数，输出“Buzz”；

3. 如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

示例：
```
n = 15,

返回:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
```

### 思路分析
没啥好说的，就是求余数然后拼接字符串的过程。

### 代码展示
我的代码：
```java
public List<String> fizzBuzz(int n) {
    List<String> l = new ArrayList<>();
    if(n<=0) return l;

    for(int i=1; i<n+1; i++) {
        String str = "";
        if(i%3 == i) {
            str += "Fizz";
        }
        if(i%5 == i) {
            str += "Buzz";
        }
        if(!str.isEmpty()) 
            l.add(str);
        else 
            l.add(Integer.toString(i));
    }

    return l;
}
```
