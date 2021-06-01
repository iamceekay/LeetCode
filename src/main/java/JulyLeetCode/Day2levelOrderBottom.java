package JulyLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day2levelOrderBottom {
}

   class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
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
    private List<List<Integer>> levelOrderBottomDfs(TreeNode root)
    {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null) return result;
        queue.offer(root);
            while(!queue.isEmpty())
            {
                int queueSize=queue.size();
                List<Integer> temp=new LinkedList<>();
                for(int i=0;i<queueSize;i++)
                {
                    if(queue.peek().left!=null) queue.offer(queue.peek().left);
                    if(queue.peek().right!=null) queue.offer(queue.peek().right);
                    temp.add(queue.poll().val);

                }
                result.add(0,temp);
            }
        return result;

    }

}
