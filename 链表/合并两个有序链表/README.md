# 合并两个有序链表

> 源地址：https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/44/

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

### 思路分析
有这道题记录下一个事实，那就是链表的题很多都适合用递归实现。我下面给出了循环和递归的2种方案，接下来主要讲下循环的思路。

同时遍历2个链表，比较当前节点的大小
* 如果 l1.val > l2.val 或者 l1 已经到尾，那么新链表添加 l2.val，l1 不动，l2继续遍历。
* 如果 l2.val > l1.val 或者 l2 已经到尾，那么新链表添加 l1.val， l2 不动，l1继续遍历。
* 如果 l1.val == l2.val，那么新链表添加2个节点，l1，l2都继续遍历。

### 代码展示
我的代码（同时遍历）：
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode head = new ListNode(0);
    ListNode tmp = head;
    while(l1 != null || l2 != null) {
        if(l2 == null || (l1 != null && l1.val < l2.val)) {
            tmp.next = new ListNode(l1.val);
            tmp = tmp.next;
            l1 = l1.next;
            continue;
        }
        if(l1 == null || (l2 != null && l1.val > l2.val)) {
            tmp.next = new ListNode(l2.val);
            tmp = tmp.next;
            l2 = l2.next;
            continue;
        }
        if(l1.val == l2.val) {
            tmp.next = new ListNode(l1.val);
            tmp.next.next = new ListNode(l1.val);
            tmp = tmp.next.next;
            l1 = l1.next;
            l2 = l2.next;
        }
    }
    return head.next;
}
```
递归实现：
```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null){
        return l2;
    }
    if(l2 == null){
        return l1;
    }
    if(l1.val < l2.val){
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;           
    }
    else{
        l2.next =  mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```