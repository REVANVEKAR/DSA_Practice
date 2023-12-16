package revise.LL;

import java.awt.event.ItemEvent;

public class LLuse {


    public void deleteNode(ListNode node) {
        // so basically pointer is given to the node to be deleted and not the head
        // and its not the last node

        // approach : just swap data and delete the next node basically make your own head
        // by swapping the data u want with the one u dont want
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public ListNode middleNode(ListNode head) {
        // my approach use two pointers when one pointer jumps two nodes the other jumps one
        // therefore reaching middle

        ListNode temp = head;
        ListNode temp2 = head;

        while (temp.next != null && temp.next.next != null){
            temp = temp.next.next;
            temp2 = temp2.next;
        }
        return temp.next==null?temp2:temp2.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;
        while (temp!= null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
        return head;
    }

    public ListNode reverseListR(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseListR(head.next);
        ListNode tail = newHead; // explanation
        // so if the LL is 1->2->3->4->5->null this will return 5 as the new head
        // thats why we take tail and iterate till tail.next != null so that we
        // can make further connections

        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = head; // remember this is the current head ( i mean if its the
        // second last call the head will be 4 ( the same value as head.next in the previous call)
        head.next = null; // make the head.next point to null instead of pointing to the new head

        return newHead;
    }



//    public class ListNode {
//        int data;
//        ListNode next;
//        ListNode(int x) {
//            this.data = x;
//        }
//    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
