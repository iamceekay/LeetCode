package LeetCodePattern;

public class LinkedListReversal {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static void main(String[] args) {

    }


   /* 206. Reverse Linked List
            Easy

3250

        78

    Add to List

            Share
    Reverse a singly linked list.

            Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL*/
    public ListNode reverseList(ListNode head) {
        ListNode Current=head;
        ListNode Prev=null;
        ListNode Next=null;
        while(Current!=null)
        {
            Next=Current.next;
            Current.next=Prev;
            Prev=Current;
            Current=Next;

        }
        return Prev;

    }

   /*
   92. Reverse Linked List II
   Reverse a linked list from position m to n. Do it in one-pass.

            Note: 1 ≤ m ≤ n ≤ length of list.

            Example:

    Input  : 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL*/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }

   /* 25. Reverse Nodes in k-Group
            Hard

1589

        312

    Add to List

            Share
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    Example:

    Given this linked list: 1->2->3->4->5

    For k = 2, you should return: 2->1->4->3->5

    For k = 3, you should return: 3->2->1->4->5*/

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head==null || head.next ==null || k==1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i=0;
        while (head != null){
            i++;
            if (i%k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;

    }

    public ListNode reverse(ListNode begin, ListNode end){
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr!=end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;

    }
}
