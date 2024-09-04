package leetcode;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class inorder {
    public static void inorder1(Node root) {
        if (root == null)
            return;
        inorder1(root.left);
        System.out.print(root.data + " ");
        inorder1(root.right);
    }

    static int idx = -1;

    static Node buildtree(int[] node) {
        idx++;
        if (idx >= node.length || node[idx] == -1)
            return null;
        Node newNode = new Node(node[idx]);
        newNode.left = buildtree(node);
        newNode.right = buildtree(node);
        return newNode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] data = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            data[i] = Integer.parseInt(s[i]);
        }
        inorder i = new inorder();
        Node root = i.buildtree(data);
        inorder1(root);
    }
}
