package org.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class _11_practice {
    /**
     * 완전이 이진트리를 이용해서 메세지를 암호화 하려고 합니다.
     * 암호화 하는 방법은 아래와 같습니다.
     * 1. 완전 이진트리에 메세지를 한글자씩 순서대로 추가합니다.
     * 2. 한 글자를 추가한 상태 또한 완전 이진 트리가 되어야 합니다.
     * 3. 완전 이진트리를 루트 노드로 부터 후위 순회 하여 한글자씩 이어 붙입니다.
     *
     * 암호화할 메세지가 주어질 때 암호화한 결과를 return 하는 solution 함수를 작성해주세요.
     * (후위순회 : 트리를 왼쪽 서브 트리 -> 오른쪽 서브 트리 -> 노드(자신) 순서로 순회하는 방법
     *
     * 입출력 예
     * message = ABCDEF
     * return = DEFCA
     *
     *       A
     *     /  \
     *    B    C
     *   / \  /
     *  D  E F
     */
    public static void main(String[] args) {
        String message = "ABCDEF";
        System.out.println(solution(message));
    }

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static String solution(String message){
        Queue<Node> que = new LinkedList<>();
        Node root = new Node(message.charAt(0));
        que.offer(root);

        for(int i=1; i<message.length(); i+=2){
            System.out.println("i : "+i+" que : "+que.peek().value);
            Node current = que.poll();
            if(i<message.length()){
                current.left = new Node(message.charAt(i));
                que.offer(current.left);
            }
            if(i+1 < message.length()){
                current.right = new Node(message.charAt(i+1));
                que.offer(current.right);
            }
        }
        return  print(root);
    }

    static String print(Node root){
        if(root == null) return "";
        StringBuilder sbf = new StringBuilder();
        sbf.append(print(root.left));
        sbf.append(print(root.right));
        sbf.append(root.value);
        return sbf.toString();
    }
}
