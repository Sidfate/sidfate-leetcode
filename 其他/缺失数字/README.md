# 缺失数字

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/26/others/69/

给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:
```
输入: [3,0,1]
输出: 2
```
示例 2:
```
输入: [9,6,4,2,3,5,7,0,1]
输出: 8
```
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

### 思路分析
这题用递归和循环都可以，唯一的要点就是：

```
第一层 l1: 1
第二层 l2: 1,1
第三层 l3: 1,2,1
第n层  ln: 1,l(n-1)[0] + l(n-1)[1], ... , l(n-1)[i-1] + l(n-1)[i],  ..., 1
```

### 代码展示
我的代码（递归）：
```java
 public List<List<Integer>> generate(int numRows) {
    if(numRows <=0) return new ArrayList<>(); 
    List<List<Integer>> l = new ArrayList<>(numRows);

    l.add(new ArrayList<Integer>(){{ add(1); }});
    for(int i=1; i<numRows-1; i++) {
        l.add(new ArrayList<>());
    }
    if(numRows == 1) {
        return l;
    }
    generate(numRows-1, l);
    return l;
}

public void generate(int level, List<List<Integer>> l) {
    List<Integer> l1 = new ArrayList<>();
    if(level == 1) {
        l1.add(1);
        l1.add(1);
        l.add(level, l1);
        return;
    }
    
    generate(level - 1, l);
    List<Integer> l2 = l.get(level-1);
    l1.add(0, 1);
    for(int i=1; i<level; i++) {
        l1.add(i, l2.get(i-1) + l2.get(i));
    }
    l1.add(1);
    l.set(level, l1);
}
```

