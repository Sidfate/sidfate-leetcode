# 删除链表中的节点

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/41/

请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19/237_example.png)

示例 1:
```
输入: head = [4,5,1,9], node = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```
示例 2:
```
输入: head = [4,5,1,9], node = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```

说明:

* 链表至少包含两个节点。
* 链表中所有节点的值都是唯一的。
* 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
* 不要从你的函数中返回任何结果。

### 思路分析
这一题需要仔细读题目条件，给定一个要被删除的节点，然后删除它。我已开始以为题目出错了，以为是一个循环链表，不然怎么知道节点的前一个节点。后来发现自己根本就想错了，只要把需要删除的节点当做下一个节点，然后让下一个节点消失就好了。具体就是：

```
node.val = node.next.val;
node.next = node.next.next;
```

### 代码展示
我的代码：
```java
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}
```
