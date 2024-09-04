package leetcode;
import java.util.*;
import java.io.*;
class Symmetrytree {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean symmetry(Node root){
        if(root == null)   return true;
        return isMirror(root.left, root.right);
    }
    public static boolean isMirror(Node p,Node q){
        if(p == null && q == null)   return true;
        if(p == null || q == null || p.data != q.data)   return false;
        return isMirror(p.left,q.right) && isMirror(p.right, q.left);
    }
    static int idx = -1;
    public static Node buildtree(String node[]){
        idx++;
        if(idx >= node.length||node[idx].equals("null"))  return null;
        Node newNode = new Node(Integer.parseInt(node[idx]));
        newNode.left = buildtree(node);
        newNode.right = buildtree(node);
        return newNode;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        Node root = buildtree(s);
        idx = -1;
        /*String[] s1 = sc.nextLine().split(" ");
        Node root1 = buildtree(s1); */
        System.out.println(symmetry(root));
    }
}
