package revise.LL;

import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.util.*;

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

    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null){
//            return true;
//        }
//
//        ListNode temp = head;
//
//        List<Integer> list = new ArrayList<>();
//
//        while (temp != null){
//            list.add(temp.val);
//            temp = temp.next;
//        }
//
//
//
//        int i = 0;
//        int j = list.size()-1;
//        while (i<j){
//            if (list.get(i) != list.get(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
        if(head==null||head.next==null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;

        while (slow!=null){
            if (dummy.val != slow.val){
                return false;
            }
            dummy = dummy.next;
            slow= slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode ptr) {
        ListNode pre=null;
        ListNode nex=null;
        while(ptr!=null) {
            nex = ptr.next;
            ptr.next = pre;
            pre=ptr;
            ptr=nex;
        }
        return pre;
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited_nodes = new HashSet<>();
        ListNode current_node = head;
        while (current_node != null) {
            if (visited_nodes.contains(current_node)) {
                return true;
            }
            visited_nodes.add(current_node);
            current_node = current_node.next;
        }
        return false;
    }

    public boolean hasCycleHandT(ListNode head) {
        ListNode slow_pointer = head, fast_pointer = head;
        while (fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if (slow_pointer == fast_pointer) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited_nodes = new HashSet<>();
        ListNode current_node = head;
        while (current_node != null) {
            if (visited_nodes.contains(current_node)) {
                return current_node;
            }
            visited_nodes.add(current_node);
            current_node = current_node.next;
        }
        return null;
    }

    public ListNode detectCycleHandT(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){ // cycle found
                slow = head; // reset slow
                while (slow!= fast){  // find the point where the cycle by
                    // making both the pointers move the same number of nodes
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // when slow == fast that means thats the node
                // therefore return that node
            }
        }
        return null; // if not found a loop
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null ){
            return null;
        }
        int count = count(head); // this will return the length
        if (n == count){
            return head.next; //means delete the first node
        }

        int i = 1;
        ListNode temp = head;
        while (i < count-n){ // count-n will give the actual pos
            temp = temp.next;
            i++;
        }
        // once reached that pos we will simply skip it ;
        temp.next = temp.next.next;

        return head;
    }

    public int count(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp!= null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode one = headA;
//        ListNode two = headB;
//        HashSet<ListNode> set = new HashSet<>();
//
//        while (one != null){
//            if (!set.contains(one)){
//                set.add(one);
//            }else {
//                return one;
//            }
//            one = one.next;
//        }
//
//        while (two != null){
//            if (set.contains(two)){
//                return two;
//            }
//            two = two.next;
//        }
//        return null;

        int c1=0,c2=0;
        ListNode a=headA,b=headB;
        while(a!=null){
            c1++;
            a=a.next;
        }
        while(b!=null){
            c2++;
            b=b.next;
        }
        while(c1>c2){
            c1--;
            headA=headA.next;
        }
        while(c2>c1){
            c2--;
            headB=headB.next;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

    }

    public ListNode oddEvenList(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;

        while (first.next != null && first.next.next != null){
            first.next = first.next.next;
            second.next = second.next.next;
        }
        first.next = second;

        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    }



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
//    public class ListNode {
//        int data;
//        ListNode next;
//        ListNode(int x) {
//            this.data = x;
//        }
//    }

}
