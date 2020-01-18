package LeetCodePattern;


import java.util.HashSet;
import java.util.Set;

public class FastSlowPointers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        isHappy(19);
    }

    /*141. Linked List Cycle
    Given a linked list, determine if it has a cycle in it.

    To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.



            Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where tail connects to the second node.


    Example 2:

    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where tail connects to the first node.


    Example 3:

    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.*/
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) return true;
            }
            return false;

        }
  /*  142. Linked List Cycle II
    Medium

1953

        156

    Add to List

            Share
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

            Note: Do not modify the linked list.



    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.


    Example 2:

    Input: head = [1,2], pos = 0
    Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.


    Example 3:

    Input: head = [1], pos = -1
    Output: no cycle
    Explanation: There is no cycle in the linked list.*/
  public ListNode detectCycle(ListNode head) {
      ListNode fast=head;
      ListNode slow=head;
      while(fast!=null && fast.next!=null)
      {
          fast=fast.next.next;
          slow=slow.next;
          if(fast==slow)
          {
              fast=head;
              while(fast!=slow)
              {
                  fast=fast.next;
                  slow=slow.next;
              }
              return fast;
          }
      }
      return null;
  }

   /* Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

            Example:

    Input: 19
    Output: true
    Explanation:
            12 + 92 = 82
            82 + 22 = 68
            62 + 82 = 100
            12 + 02 + 02 = 1*/
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

   /* 876. Middle of the Linked List
            Easy

749

        46

    Add to List

            Share
    Given a non-empty, singly linked list with head node head, return a middle node of linked list.

    If there are two middle nodes, return the second middle node.



    Example 1:

    Input: [1,2,3,4,5]
    Output: Node 3 from this list (Serialization: [3,4,5])
    The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
    Note that we returned a ListNode object ans, such that:
    ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
            Example 2:

    Input: [1,2,3,4,5,6]
    Output: Node 4 from this list (Serialization: [4,5,6])
    Since the list has two middle nodes with values 3 and 4, we return the second one.*/

    public ListNode middleNode(ListNode head) {
        ListNode current=head;
        ListNode count=head;
        int mid =length(count);
        System.out.println(mid);
        int i=0;
        while(i<mid)
        {
            i++;
            current=current.next;

        }
        return current;
    }
    public int length(ListNode head) {
        int len=0;
        while(head!=null)
        {
            len++;
            head=head.next;
        }

        return len/2;

    }


}
