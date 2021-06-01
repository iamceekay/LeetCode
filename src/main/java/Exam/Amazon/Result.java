package Exam.Amazon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val=x;
        }
    }

    /*
     * Complete the 'foo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY values
     *  2. INTEGER node1
     *  3. INTEGER node2
     */

    public static int foo(List<Integer> values, int node1, int node2) {
        // Write your code here
        TreeNode root=null;
        for(int i=0;i<values.size();i++)
        {
            root=buildBinaryTree(root,values.get(i));
        }
        TreeNode ancestor=findAncestor(root,node1,node2);
        return distance(ancestor,node1)+distance(ancestor,node2);
    }
    public static TreeNode buildBinaryTree(TreeNode root,int node)
    {
        if(root==null){
            root=new TreeNode(node);
            return root;
        }
        else if(root.val<node)
        {
            if(root.right==null)
            {
                root.right=new TreeNode(node);
            }
            else
            {
                buildBinaryTree(root.right,node);
            }
        }
        else if(root.val>node)
        {
            if(root.left==null)
            {
                root.left=new TreeNode(node);
            }
            else
            {
                buildBinaryTree(root.left,node);
            }
        }
        return root;
    }
    public static TreeNode findAncestor(TreeNode root,int start,int end)
    {
        while(true)
        {
            if(root.val>start && root.val <end)
            {
                root=root.left;
            }
            else if(root.val<start && root.val<end)
            {
                root=root.right;
            }
            else{
                return root;
            }
        }
    }
    public static int distance(TreeNode ancestor,int start)
    {
        int d=0;
        while(true)
        {
            if(ancestor!=null)
            {
                if(ancestor.val==start){
                    return d;
                }
                else if(ancestor.val<start)
                {
                    d++;
                    ancestor=ancestor.right;
                }
                else if(ancestor.val>start)
                {
                    d++;
                    ancestor=ancestor.left;
                }
            }
            else
            {
                return d;
            }
        }
    }

}