package LeetCodePattern;

import java.util.Arrays;
import java.util.Scanner;

class ReverseLinkedListSolution {
    static Node head;
    static class Node
    {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
   static Node reverseLinkedList(Node node)
    {
        Node prev=null;
        Node current=node;
        Node next=null;
        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        head=new Node(25);
        head.next=new Node(35);
        head.next.next=new Node(45);
        print(head);
        System.out.println("  ");
       head=reverseLinkedList(head);
        print(head);


    }

}
