import java.util.*;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;next = null; }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        if(head.next.val == head.val) return true;                          
        ListNode a,b;
        a = head;
        b = head.next;

        while(a != b) {
            if(b.next == null || b.next.next == null) {
                return false;
            }
            a = a.next;
            b = b.next.next;
        }

        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.initLinkedList(1, 2, 3, 4, 5);
        solution.addLoop(head, 1);
        // solution.traverseLinkedList(head);
        boolean result = solution.hasCycle(head);
        System.out.println("是否环形:" + result);
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

    public void addLoop(ListNode head, int index) {
        if(index == -1) return;
        int i = 0;
        ListNode tmp = head;
        while(head.next != null) {
            if(i == index) {
                tmp = head;
            }
            i++;
            head = head.next;
        }
        head.next = tmp;
    }

    public void traverseLinkedList(ListNode head) {
        System.out.println("遍历链表");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}