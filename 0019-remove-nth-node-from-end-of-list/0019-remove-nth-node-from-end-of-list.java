/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public int length(ListNode head) {
        int cnt = 0;

        while (head != null) {
            cnt++;
            head = head.next;
        }

        return cnt;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = length(head);

        int st = len - n + 1;

        // If first node has to be removed
        if (st == 1) {
            return head.next;
        }

        ListNode temp = head;

        // Reach the node before the node to be removed
        for (int i = 1; i < st - 1; i++) {
            temp = temp.next;
        }

        // Remove the node
        temp.next = temp.next.next;

        return head;
    }
}