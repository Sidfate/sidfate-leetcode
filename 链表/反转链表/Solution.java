import java.util.*;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

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

    public ListNode reverse(ListNode l1, ListNode l2) {
        if(l1.next == null) {
            return l1;
        }
        
        l2.next = reverse(l1.next, l2);
        return l2.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.initLinkedList(1, 2, 3, 4, 5);
        solution.traverseLinkedList(head);
        ListNode newHead = solution.reverseList(head);
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