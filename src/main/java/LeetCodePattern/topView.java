package LeetCodePattern;

import java.util.TreeMap;

class topView {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        static class Pair {
            int nodedata;
            int height;

            Pair(int nodedata, int height) {
                this.nodedata = nodedata;
                this.height = height;
            }
        }

        static void topView(Node root) {
            if (root == null) return;
            TreeMap<Integer, Pair> treeMap = new TreeMap<>();

            // obtain top view of binary tree into the Map
            inorder(root, 0, 0, treeMap);

            /* traverse the map and print top view */
            for (int keyInteger : treeMap.keySet())
                System.out.print(treeMap.get(keyInteger).nodedata + " ");

        }

        static void inorder(Node root, int w, int h, TreeMap<Integer, Pair> treeMap) {
            if (root == null) return;
            if (!treeMap.containsKey(w))
                treeMap.put(w, new Pair(root.data, h));
            /* if particular horizontal level has been visited
        then check if height of current node is less than
        the previous node met at same horizontal level, if this
        is true then the current node should replace previous node
        in top view of the binary tree */
            else if (treeMap.get(w).height > h)
                treeMap.put(w, new Pair(root.data, h));
            inorder(root.left, w - 1, h + 1, treeMap);
            inorder(root.right, w + 1, h + 1, treeMap);

        }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.right.right = new Node(5);
            root.left.right = new Node(4);
            root.left.right.right = new Node(6);
            root.left.right.right.right = new Node(7);
            root.left.right.right.right.right = new Node(8);

            topView(root);
        }
    }
}
