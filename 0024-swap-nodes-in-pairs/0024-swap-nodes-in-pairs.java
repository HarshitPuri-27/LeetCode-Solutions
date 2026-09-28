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
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null && temp.next != null) {

            ListNode second = temp.next;

            temp.next = second.next;
            second.next = temp;

            if (prev != null) {
                prev.next = second;
            }

            prev = temp;
            temp = temp.next;
        }

        return newHead;
    }
}
        
