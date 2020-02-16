# 回文链表

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/45/

请判断一个链表是否为回文链表。

示例 1:
```
输入: 1->2
输出: false
```
示例 2:
```
输入: 1->2->2->1
输出: true
```
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

### 思路分析
这道题因为我在之前的文章中又看到过方法，当时的做法是先找到中间节点然后翻转一半，比较各一半是否相等。我现在再看这道题觉得这个做法很奇怪，我为什么不直接翻转整个链表，然后再和原链表比较是否相等不就好了吗，可能相当而言比较遍历会是原来的一半，但是我还少了一步找到中间节点的操作。下面给出的是我的代码。

### 代码展示
我的代码：
```java
public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    ListNode tmp = new ListNode(0);
    ListNode tmp2 = head;
    ListNode fake = tmp;
    while (tmp2 != null) {
        tmp.next = new ListNode(tmp2.val);
        tmp.next.next = null;
        tmp = tmp.next;
        tmp2 = tmp2.next;
    }
    ListNode newHead = reverseList(head);

    fake = fake.next;
    while(fake != null) {
        if(fake.val != newHead.val) {
            return false;
        }
        fake = fake.next;
        newHead = newHead.next;
    }

    return true;
}
```
