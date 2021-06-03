package Concurrency;

import java.util.ArrayList;

public class DepthOfTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val)
        {
            this.val=val;
        }
    }

    public static void main(String[] args) {
       ArrayList<String> list= new ArrayList<>();
       TreeNode tree=new TreeNode(3);
       tree.left=new TreeNode(9);
       tree.right=new TreeNode(20);
       tree.right.left=new TreeNode(15);
        tree.right.right=new TreeNode(7);
        System.out.println(maxDepth(tree));

    }

    private static int maxDepth(TreeNode tree) {
        if(tree==null) return 0;
        int leftVal=maxDepth(tree.left);
        int rightVal=maxDepth(tree.right);
        int result=Math.max(rightVal,leftVal)+1;
        return result;
    }
}
