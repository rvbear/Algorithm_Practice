import java.util.*;

class Node {
    int x, y, value;
    Node left, right;
    
    public Node(int x, int y, int value, Node left, Node right) {
        this.x = x; this.y = y; this.value = value; this.left = left; this.right = right;
    }
}

class Solution {
    int[][] answer;
    int index;
    public void preorder(Node root) {
        if(root != null) {
            answer[0][index++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][index++] = root.value;
        }
    }
    public void makeTree(Node parent, Node child) {
        if(parent.x < child.x) {
            if(parent.right == null) {
                parent.right = child;
            } else {
                makeTree(parent.right, child);
            }
        } else {
            if(parent.left == null) {
                parent.left = child;
            } else {
                makeTree(parent.left, child);
            }
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodeList = new Node[nodeinfo.length];
        
        for(int i = 0; i < nodeinfo.length; i++) {
            nodeList[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }
        
        Arrays.sort(nodeList, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.y == n2.y ? n1.x - n2.x : n2.y - n1.y; 
            }
        });
        
        Node parent = nodeList[0];
        for(int i = 1; i < nodeinfo.length; i++) {
            makeTree(parent, nodeList[i]);
        }
        
        answer = new int[2][nodeinfo.length];
        index = 0;
        preorder(parent);
        index = 0;
        postorder(parent);
        
        return answer;
    }
}