package leetcode;
import java.util.*;
public class levelorder {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int idx =-1;
    public static Node buildTree(String[] nodes){
        idx++;
        if(idx >= nodes.length||nodes[idx].equals("null")) return null;
        Node newNode = new Node(Integer.parseInt(nodes[idx]));
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split("");
        Node root = buildTree(nodes);
        System.out.println(root.data+ " ");
    }
}
