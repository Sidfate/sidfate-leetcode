# 第一个错误的版本

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/8/sorting-and-searching/53/

你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

示例:

给定 n = 5，并且 version = 4 是第一个错误的版本。

调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true

所以，4 是第一个错误的版本。 

### 思路分析
思路没啥好说的，就是二分查找的方式，问题在于这题隐藏了一个坑，就是计算中间节点的时候可能会产生int溢出，所以在计算中间点的时候我用了以下的方式防止计算到溢出：
```java
int count = start + (end - start) / 2;
```

### 代码展示
我的代码：
```java
public int firstBadVersion(int n) {
    if(n == 1) return 1;
    int start = 1;
    int end = n;
    while(start != end) {
        if(end - start == 1) return isBadVersion(start) ? start:end;
        int count = start + (end - start) / 2;
        if(isBadVersion(count)) {
            end = count;
        }else {
            start = count;
        }
        
    }
    
    return start+1;
}
```

