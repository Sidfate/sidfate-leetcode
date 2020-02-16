import java.util.*;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

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
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.initLinkedList(1, 1, 2, 1);
        solution.traverseLinkedList(head);
        boolean result = solution.isPalindrome(head);
        System.out.println("是否为回文链表:" + result);
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