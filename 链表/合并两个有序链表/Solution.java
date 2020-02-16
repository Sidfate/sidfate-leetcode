import java.util.*;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = solution.initLinkedList(1);
        ListNode l2 = solution.initLinkedList(2);
        
        ListNode newHead = solution.mergeTwoLists(l1, l2);
        solution.traverseLinkedList(newHead);
    } 

    public ListNode initLinkedList(int ...vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode tmp = head;
        for(int i=1; i<vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            node.next = null;
            tmp.next = node;
            tmp = node;
        }

        return head;
    }

    public void traverseLinkedList(ListNode head) {
        System.out.println("遍历链表");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}