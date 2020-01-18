package LeetCodePattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
    TreeNode(int x) { val = x; }
 }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
 /*102. Binary Tree Level Order Traversal
            Medium

2073

        56

    Add to List

            Share
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
            / \
            9  20
            /  \
            15   7
            return its level order traversal as:
            [
            [3],
            [9,20],
            [15,7]
            ]*/

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  result=new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> queue=  new LinkedList<TreeNode>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty())
        {
            result.add(new ArrayList<Integer>());
            int level_length=queue.size();
            for(int i=0;i<level_length;i++)
            {
                TreeNode node=queue.remove();
                result.get(level).add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            level++;
        }
        return result;
    }
    ArrayList<List<Integer>>  result=new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root==null) return result;
        levelOrder2(root,0);
        return result;

    }
    private void  levelOrder2(TreeNode node,int level){
        if(result.size()==level)
            result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        if(node.left!=null)
            levelOrder2(node.left,level+1);
        if(node.right!=null)
            levelOrder2(node.right,level+1);
    }

   /* 107. Binary Tree Level Order Traversal II
    Easy

948

        178

    Add to List

            Share
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
            / \
            9  20
            /  \
            15   7
            return its bottom-up level order traversal as:
            [
            [15,7],
            [9,20],
            [3]
            ]*/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return result;
        levelOrderBottom(root,0);
        return result;

    }
    private void  levelOrderBottom(TreeNode node,int level){
        if(result.size()==level)
            result.add(0,new ArrayList<Integer>());
        if(node.left!=null)
            levelOrderBottom(node.left,level+1);
        if(node.right!=null)
            levelOrderBottom(node.right,level+1);
        result.get(result.size()-level-1).add(node.val);
    }
/*103. Binary Tree Zigzag Level Order Traversal
    Medium

1418

        81

    Add to List

            Share
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
            / \
            9  20
            /  \
            15   7
            return its zigzag level order traversal as:
            [
            [3],
            [20,9],
            [15,7]
            ]*/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return result;
        zigzagLevelOrder(root,0);
        return result;

    }
    private void  zigzagLevelOrder(TreeNode node,int level){
        if(result.size()==level)
            result.add(new ArrayList<Integer>());
        if(level%2==0)
            result.get(level).add(node.val);
        else
            result.get(level).add(0,node.val);
        if(node.left!=null)
            zigzagLevelOrder(node.left,level+1);
        if(node.right!=null)
            zigzagLevelOrder(node.right,level+1);
    }

  /*  637. Average of Levels in Binary Tree
    Easy

951

        136

    Add to List

            Share
    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
            Example 1:
    Input:
            3
            / \
            9  20
            /  \
            15   7
    Output: [3, 14.5, 11]
    Explanation:
    The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11]*/

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double>  value=new ArrayList<>();
        if(root==null) return value;
        averageOfLevels(root,0);
        for(List<Integer> res :result)
        {
            value.add(res.stream().mapToInt(a -> a).average().orElse(0.0));
        }
        return value;

    }
    private void  averageOfLevels(TreeNode node,int level){
        if(result.size()==level)
            result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        if(node.left!=null)
            averageOfLevels(node.left,level+1);
        if(node.right!=null)
            averageOfLevels(node.right,level+1);
    }

  /*  111. Minimum Depth of Binary Tree
            Easy

960

        546

    Add to List

            Share
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

            3
            / \
            9  20
            /  \
            15   7
            return its minimum depth = 2.*/

    public int minDepth(TreeNode root) {
        int min=Integer.MAX_VALUE;
        if(root==null)
            return 0;
        if(root.left==null && root.right==null) return 1;
        if(root.left!=null)
            min=Math.min(minDepth(root.left),min);
        if(root.right!=null)
            min=Math.min(minDepth(root.right),min);
        return min+1;

    }

   /* 116. Populating Next Right Pointers in Each Node
            Medium

1385

        130

    Add to List

            Share
    You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

    struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.



    Follow up:

    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


            Example 1:



    Input: root = [1,2,3,4,5,6,7]
    Output: [1,#,2,3,#,4,5,6,7,#]
    Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

*/
   public Node connect(Node root) {
       if (root == null) {
           return root;
       }

       // Start with the root node. There are no next pointers
       // that need to be set up on the first level
       Node leftmost = root;

       // Once we reach the final level, we are done
       while (leftmost.left != null) {

           // Iterate the "linked list" starting from the head
           // node and using the next pointers, establish the
           // corresponding links for the next level
           Node head = leftmost;

           while (head != null) {

               // CONNECTION 1
               head.left.next = head.right;

               // CONNECTION 2
               if (head.next != null) {
                   head.right.next = head.next.left;
               }

               // Progress along the list (nodes on the current level)
               head = head.next;
           }

           // Move onto the next level
           leftmost = leftmost.left;
       }

       return root;
   }

}