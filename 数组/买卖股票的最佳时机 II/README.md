# 买卖股票的最佳时机 II

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/22/

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
```
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
```
示例 2:
```
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
```
示例 3:
```
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```
### 思路分析
我的思路是分2个步骤：
1. 循环遍历原数组，如果当前数小于后一位数，进入步骤2，否则继续循环。
2. 以当前数为起点向后遍历剩余数组，直到直到第一个最大数，该过程相当于步骤1。找到后累加收益，跳出当前循环，进入步骤1。 

网上资料说明是 **贪心算法，总是做出在当前看来是最好的选择，不从整体最优上加以考虑，也就是说，只关心当前最优解**。放在这题上就是只要有收益就卖，只管卖掉，累加收益，举个例子，1 7 8，最大利润 = 8 - 1 = 7 - 1 + 8 - 7。

另外有很多比较后求和累加的过程都可以用贪心算法解决。

### 代码展示
我的代码：
```java
public int maxProfit(int[] prices) {
    if(prices.length <= 1) {
        return 0;
    }
    int i = 0;
    int result = 0;
    while(i < prices.length - 1) {
        if(prices[i] > prices[i+1]) {
            i++;
            continue;
        }

        int j = i+1;
        for(; j < prices.length - 1; j++) {
            if(prices[j] > prices[j+1]) {
                break;
            }
        }
        result += prices[j] - prices[i];
        i = j;
    }

    return result;
}
```
贪心算法代码：
```java
public int maxProfit(int[] price) {
    int maxPro = 0, tmp = 0;
        for (int i = 1; i < prices.length; ++i) {
            tmp = prices[i] - prices[i-1];
            if (tmp > 0) {
                maxPro += tmp;
            }
        }
        return maxPro;
}

```
