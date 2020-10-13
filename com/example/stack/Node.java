package com.example.stack;

/**
 * @author YangLiuQing
 * @date 2020/6/1 15:23
 */
public class Node {

    public int no;//节点编号
    public Node next;//当前节点的下一个结点

    //构造器
    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
