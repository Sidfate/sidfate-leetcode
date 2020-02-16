# 反转链表

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/43/

反转一个单链表。

示例:
```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

### 思路分析
假设我们的链表是 1->2->3->4->5->NULL，循环的思路：
1. 新建一个节点newHead，一开始为空。
2. 循环链表，第一步获取拷贝 head.next 为 tmp，将 head.next 设置为 newHead，所以head现在是 1->NULL，使 newHead 与 head 相等，在讲 head 还原为 tmp。
3. 重复 3 直到 head 为空。

![](https://sidfate.oss-cn-hangzhou.aliyuncs.com/upic/20200211182559-igFCwA.jpg)

### 代码展示
循环：
```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = null;
    while (head != null) {
        ListNode tmp = head.next;
        head.next = newHead;
        newHead = head;
        head = tmp;
    }
    return newHead;       
}
```

递归：
```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode subListHead = reverseList(head.next);
    // 形成环
    head.next.next = head;
    head.next = null;
    return subListHead;
}
```
