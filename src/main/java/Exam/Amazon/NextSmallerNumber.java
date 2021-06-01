package Exam.Amazon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class NextSmallerNumber {
    static class Node {
        int val, leftSum = 0, count = 0;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
        public static void main(String[] args) {
            countSmaller(new int[]{5,2,6,1});

        }
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        if(nums.length == 0){
            return Arrays.asList(count);
        }
        Node root = new Node(nums[nums.length - 1]);
        for(int i = nums.length - 1; i >= 0; i--){
            count[i] = insert(root, nums[i]);
        }
        return Arrays.asList(count);
    }
    private static int insert(Node node, int num){
        int sum = 0;
        while(node.val != num){
            if(num<node.val){
                if(node.left == null) node.left = new Node(num);
                node.leftSum++;
                node = node.left;
            }else{
                sum += node.leftSum + node.count;
                if(node.right == null) node.right = new Node(num);
                node = node.right;
            }
        }
        node.count++;
        return sum + node.leftSum;
    }
}
