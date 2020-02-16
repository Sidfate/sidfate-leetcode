# 字符串中第一个唯一字符

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/5/strings/34/

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:
```
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
```

注意事项：您可以假定该字符串只包含小写字母。


### 思路分析
我的思路在于另建2个map，分别储存 字符->字符出现个数 和 字符->字符首次出现索引 的关联。第一次遍历填充上述2个map，第二次遍历从 字符->字符出现个数 出去第一个出现个数为1的字符，然后通过这个字符去获取第二个map的值，也就是首次出现索引。

后来发现我忽视了题目给的一个条件：您可以假定该字符串只包含小写字母。然后看了提交中最快的一种解答，它把题目分为2种情况：
1. 如果字符串长度小于26。定义一个长度为 26 的int数组，用来表示从 a-z 的出现次数，0代表a，25代表z。然后一次循环遍历字符串，统计出现次数，第二次循环字符串，找到第一个出现次数为1的字符。
2. 如果字符串长度大于26。遍历 a-z，找出字符在字符串最开始出现的索引值，和最后出现的索引值，如果相等，说明字符唯一出现，然后将索引值计入一个临时变量，不断的取临时变量和索引值的最小值，最后临时变量就是最小的唯一字符索引。

### 代码展示
我的代码：
```java
public int firstUniqChar(String s) {
    Map<Character, Integer> count = new LinkedHashMap<>();
    Map<Character, Integer> index = new HashMap<>();
    for(int i=0; i<s.length(); i++) {
        int value = 1;
        char key = s.charAt(i);
        if(!index.containsKey(key)) {
            index.put(key, i);
        }
        if(count.containsKey(key)) {
            value = count.get(key) + 1;
        }
        count.put(key, value);
    }

    for(char key: count.keySet()) {
        if(count.get(key) == 1) {
            return index.get(key);
        }
    }
    return -1;
}

```

最快解答：
```java
public int firstUniqChar(String s) {
    int[] charArr = new int[26];
    if(s.length()<26){
        for(char ch:s.toCharArray()){
            charArr[ch-'a'] ++;
        }
        for(int i=0;i<s.length();i++){
            if(charArr[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    int result = s.length();
    for(int i = 'a';i<='z';i++){
        int l = s.indexOf(i);
        if(l!=-1&&l == s.lastIndexOf(i)){
            result=Math.min(l,result);
        }
    }
    result = result == s.length()?-1:result;
    return result;
}
```

