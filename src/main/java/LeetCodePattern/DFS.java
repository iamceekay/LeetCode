package LeetCodePattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public class TreeNode {
    int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}

    /*112. Path Sum
    Easy

1310

        402

    Add to List

            Share
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

            5
            / \
            4   8
            /   / \
            11  13  4
            /  \      \
            7    2      1
            return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.*/

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        sum-=root.val;
        if(root.left==null && root.right==null)
            return (sum==0);
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);

    }

   /* 113. Path Sum II
            Medium

1246

        42

    Add to List

            Share
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

            5
            / \
            4   8
            /   / \
            11  13  4
            /  \    / \
            7    2  5   1
    Return:

            [
            [5,4,11,2],
            [5,8,4,5]
            ]*/
   private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(new ArrayList<Integer>(), root, sum);
        return result;
    }

    private void pathSum(List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) result.add(list);
            return;
        }
        pathSum(new ArrayList<Integer>(list), root.left, sum);
        pathSum(new ArrayList<Integer>(list), root.right, sum);

    }


   /* 733. Flood Fill
    Easy

672

        140

    Add to List

            Share
    An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

    Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

    To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

    At the end, return the modified image.

            Example 1:
    Input:
    image = [[1,1,1],[1,1,0],[1,0,1]]
    sr = 1, sc = 1, newColor = 2
    Output: [[2,2,2],[2,2,0],[2,0,1]]
    Explanation:
    From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
    by a path of the same color as the starting pixel are colored with the new color.
    Note the bottom corner is not colored 2, because it is not 4-directionally connected
    to the starting pixel.*/
   public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       if(image[sr][sc]==newColor) return image;
       int color=image[sr][sc];
       dfs(image,sr,sc,color,newColor);

       return image;

   }
    public void dfs(int[][] image,int r ,int c, int color,int newColor)
    {
        if(r < 0 || r >=image.length || c<0 || c >=image[0].length || image[r][c]!=color) return;
        image[r][c]=newColor;
        dfs(image, r+1 ,c,  color,newColor);
        dfs(image, r-1 , c,  color, newColor);
        dfs(image, r , c+1,  color, newColor);
        dfs(image, r , c-1,  color, newColor);
    }


/*
    98. Validate Binary Search Tree
    Medium

2805

        408

    Add to List

            Share
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.


    Example 1:

            2
            / \
            1   3

    Input: [2,1,3]
    Output: true
    Example 2:

            5
            / \
            1   4
            / \
            3   6

    Input: [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.*/

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root,long min,long max)
    {
        if (root==null) return true;

        if(root.val<=min || root.val >=max) return false;

        return isValidBST( root.left, min, root.val) && isValidBST( root.right, root.val,max);
    }

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
/*200. Number of Islands
            Medium

3738

        137

    Add to List

            Share
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input:
            11110
            11010
            11000
            00000

    Output: 1
    Example 2:

    Input:
            11000
            11000
            00100
            00011

    Output: 3*/
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {

                    numIslands(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void numIslands(char[][] grid,int i,int j)
    {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length || grid[i][j]!='1') return;
        grid[i][j]='0';
        numIslands(grid, i+1, j);
        numIslands(grid, i-1, j);
        numIslands(grid, i, j-1);
        numIslands(grid, i, j+1);
    }

   /* 988. Smallest String Starting From Leaf
            Medium

232

        55

    Add to List

            Share
    Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

    Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

            (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)



    Example 1:



    Input: [0,1,2,3,4,3,4]
    Output: "dba"
    Example 2:



    Input: [25,1,3,1,3,0,2]
    Output: "adz"*/

    private String ans = "~"; // dummy value '~' > 'z'
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    private String dfs(TreeNode n, String str) {
        if (n == null) { return str; } // base case, and in case root is null.
        str = (char)(n.val + 'a') + str; // prepend current char to the path string from root.
        if (n.left == null && n.right == null && ans.compareTo(str) > 0) { ans = str; } // update ans if n is a leaf.
        dfs(n.left, str); // recursion to the left branch.
        dfs(n.right, str); // recursion to the right branch.
        return ans;
    }

}
