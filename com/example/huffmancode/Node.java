package com.example.huffmancode;

/**
 * @author YangLiuQing
 * @date 2020/5/25 11:01
 * 节点类
 */
public class Node implements Comparable<Node>{

    Byte data;//存放数据本身，比如'a'--->97
    int weight;//权值，字符出现的次数

    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);

        if(this.left != null){
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }

    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
