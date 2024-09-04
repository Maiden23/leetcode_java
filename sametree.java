package leetcode;
import java.util.*;
class sametree {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isSameTree(Node p, Node q) {
        if(p == null && q == null)  return true;
        if(p == null || q == null)  return false;
        if(p.data != q.data) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    static int idx =-1;
    public static Node buildtree(String node[]){
        idx++;
        if(idx>=node.length ||node[idx].equals("null")) return null;
        Node root = new Node(Integer.parseInt(node[idx]));
        root.left = buildtree(node);
        root.right = buildtree(node);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split("");
        sametree t = new sametree();
        Node root = t.buildtree(s);
        System.out.println(root.data + " ");
        idx = -1;
        String s1[] = sc.nextLine().split("");
        Node root1 = t.buildtree(s1);
        System.out.println(root1.data + " ");
        System.out.println(isSameTree(root,root1));
    }
}
