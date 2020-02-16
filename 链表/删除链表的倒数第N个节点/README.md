# 删除链表的倒数第N个节点

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/42/

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
```
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

### 思路分析
因为要删除倒数的第n个节点，链表是有序的，不容易直接确定倒数的第n个节点是谁，所以我通过一次遍历把链表的节点放进一个list里，然后通过list可以 O(1) 的取出第 n-1 个节点，将他的next设置为next.next就ok了，所以只需要一次扫码。

### 代码展示
我的代码：
```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    List<ListNode> list = new ArrayList<>();
    ListNode tmp = head;
    while(tmp != null) {
        list.add(tmp);
        tmp = tmp.next;
    }
    int size = list.size();
    if(n == size) {
        return head.next;
    }
    ListNode node = list.get(size-n-1);
    node.next = node.next.next;
    
    return head;
}
```
