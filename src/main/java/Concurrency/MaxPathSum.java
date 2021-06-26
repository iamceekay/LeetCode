package Concurrency;

public class MaxPathSum {
    public static void main(String[] args) {
       /*TreeNode root=new TreeNode(-10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.right=new TreeNode(7);
        root.right.left=new TreeNode(15);
        System.out.println(maxPathSum(root));*/
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        System.out.println(maxPathSum(root));

    }
   static int max=Integer.MIN_VALUE;
    private static int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxpathSum(root);
        return max;
    }

    private static int maxpathSum(TreeNode root) {
        if(root==null) return 0;
        int left=maxpathSum(root.left);
        int right=maxpathSum(root.right);
        int maxLeftRight=Math.max(left,right);
        int maxWithRoot=Math.max(root.val, root.val+maxLeftRight);
        int maxAll=Math.max(maxWithRoot,root.val+left+right);

        max=Math.max(max,maxAll);
        return maxWithRoot;
    }

    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
