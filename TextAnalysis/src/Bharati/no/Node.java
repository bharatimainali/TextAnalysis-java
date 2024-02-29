package Bharati.no;

import java.util.Stack;

public class Node {
    Node left;
    String word;
    int count = 1;
    Node right;

    Node(String word){
        this.word = word;
    }
}

class textAnalysis{
    Node root;
    public void insert(String key){
        Node node = new Node(key);
        if(root == null){
            root = node;
            return;
        }
        Node prev = root;
        Node temp = root;
        while(temp != null){
            if(temp.word.compareTo(key) > 0){
                prev = temp;
                temp = (Node) temp.left;
            }else if(temp.word.compareTo(key) < 0){
                prev = temp;
                temp = (Node) temp.right;
            }else {
                prev = temp;
                temp = null;
            }
        }
        if (prev.word.compareTo(key) > 0){
            prev.left = node;
        }else if (prev.word.compareTo(key) < 0){
            prev.right = node;
        }else{
            prev.count += 1;
        }
    }
    public void inorder(){
        Node temp = root;
        Stack<Node> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()){
            if(temp != null){
                stack.add(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.println(temp.word + ":" + temp.count);
                temp = temp.right;
            }
        }
    }
}

