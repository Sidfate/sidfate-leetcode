# 计数质数

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/25/math/61/

统计所有小于非负整数 n 的质数的数量。

示例:
```
输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
```

### 思路分析
所以这一题的主要目的就是如何判断一个数是质数。给出一个目前觉得最简单的方法，首先要给出一个结论：大于等于5的质数一定和6的倍数相邻，例如5和7，11和13,17和19等等。

> 证明：令x≥1，将大于等于5的自然数表示如下：
······ 6x-1，6x，6x+1，6x+2，6x+3，6x+4，6x+5，6(x+1），6(x+1)+1 ······
可以看到，不在6的倍数两侧，即6x两侧的数为6x+2，6x+3，6x+4，由于2(3x+1)，3(2x+1)，2(3x+2)，所以它们一定不是素数，再除去6x本身，显然，素数要出现只可能出现在6x的相邻两侧。这里有个题外话，关于孪生素数，有兴趣的道友可以再另行了解一下，由于与我们主题无关，暂且跳过。这里要注意的一点是，在6的倍数相邻两侧并不是一定就是质数。

再者，我们知道，一个数若可以进行因数分解，那么分解时得到的两个数一定是一个小于等于sqrt(n)，一个大于等于sqrt(n)，也就是和平方根作比较，据此我们只要遍历到sqrt(n)即可，因为若sqrt(n)左侧找不到约数，那么右侧也一定找不到约数。

### 代码展示
我的代码：
```java
public int countPrimes(int n) {
    if(n<=2) return 0;
    if(n<=3) return 1;
    if(n<5) return 2;
    int a = 2;

    for(int i=5; i<n; i++) {
        if(isPrime(i)) a++;
    }
    return a++;
}

public static boolean isPrime(int num) {
    // 不在6的倍数两侧的一定不是质数
    if (num % 6 != 1 && num % 6 != 5) {
        return false;
    }
    int sqrt = (int) Math.sqrt(num);
    for (int i = 5; i <= sqrt; i += 6) {
        if (num % i == 0 || num % (i + 2) == 0) {
            return false;
        }
    }
    return true;
}
```
