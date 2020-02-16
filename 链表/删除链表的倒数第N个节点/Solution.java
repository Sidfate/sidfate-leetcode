import java.util.*;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

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
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.initLinkedList(1, 2, 3, 4, 5);
        solution.traverseLinkedList(head);
        ListNode newHead = solution.removeNthFromEnd(head, 2);
        System.out.println("链表头部:" + newHead);
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