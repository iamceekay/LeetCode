package Exam.LearnAll;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val){this.val=val;};

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(5);
        node.left.left=new TreeNode(6);
        node.left.right=new TreeNode(7);
        node.right=new TreeNode(2);
        node.right.left=new TreeNode(3);
        node.right.right=new TreeNode(4);
        System.out.println(inOrderTraversal(node));
    }
    static ArrayList<Integer> result=new ArrayList<>();
    public static List<Integer> inOrderTraversal(TreeNode node){
        inOrder(node);
        return  result;
    }
    public static void inOrder(TreeNode node){
        if(node==null) return;
        result.add(node.val);
        System.out.println(node.val);
        inOrder(node.left);
        inOrder(node.right);
    }
}
