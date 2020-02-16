# 字符串转换整数 (atoi)

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/37/

请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:
```
输入: "42"
输出: 42
```
示例 2:
```
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
```
示例 3:
```
输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
```
示例 4:
```
输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
```
示例 5:
```
输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−231) 。
```

### 思路分析
这题题目不难，但是坑很多，所以部分慢点在于判断逻辑上了，下面列举我遇到的几种需要考虑的情况：
* "+1" 要返回 1
* "01" 要返回 1
* " - 123" 不符合要求，返回0。

回到解题上来，关键在于找到数字的字符然后计算大小。我用了一种偷鸡的方法，先取出满足条件的字符串，然后用 BigDecimal 转换数字然后比较 INT_MAX 和 INT_MIN 的大小。实际上应该是遍历的过程中不断*10，只要最后的一个数字，最终计算的值就是有效大小。

### 代码展示
我的代码：
```java
public int myAtoi(String str) {
    if(str.isEmpty()) return 0;
    String temp = "";
    int flag = 0;
    for(char ch: str.toCharArray()) {
        if(ch >= 48 && ch <= 57) {
            if(flag > 1) return 0;
            if(flag == 1 && temp.isEmpty()) return 0;
            temp += ch; 
        }else {
            if(!temp.isEmpty()) break;
            if(ch == 45 || ch == 43) temp += ch; 
            if(ch != 32) flag++;
        }
    }
    if(temp.isEmpty() || temp.equals("-") || temp.equals("+")) return 0;
    
    BigDecimal decimal = new BigDecimal(temp);
    BigDecimal intMax = new BigDecimal(Integer.MAX_VALUE);
    BigDecimal intMin = new BigDecimal(Integer.MIN_VALUE);
    if(decimal.compareTo(intMax) == 1) {
        return intMax.intValue();
    }
    if(decimal.compareTo(intMin) == -1) {
        return intMin.intValue();
    }
    return decimal.intValue();
}
```
最快方法，累乘以10：
```java
public int myAtoi(String str) {
    int rev = 0;
    char[] charList = str.toCharArray();
    int length = str.length();
    int zf = 1;
    int i = 0;
    int pop = 0;
    for(;  i < length; i++){
        if(charList[i] == ' '){
            continue;
        }else{
            if(charList[i] == '-'){
                i++;
                zf = -1;
                break;
            }
            if(charList[i] == '+'){
                i++;
                break;
            }
            if(charList[i] <'0' || charList[i] >'9'){
                return 0;
            }else{
                break;
            }
        }
    }
    if(i == length){
        return 0;
    }
    for(;i < length; i++){
        if(charList[i] <'0' || charList[i] >'9'){
            return rev;
        }
        pop = (charList[i] -48) * zf;
        if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
            return Integer.MAX_VALUE;
        }
        if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
            return Integer.MIN_VALUE;
        }
        rev = rev * 10 + pop;
    }
    return rev;
}
```
