package com.example.huffmantree;

/**
 * @author YangLiuQing
 * @date 2020/5/25 9:20
 * 创建结点类
 * 为了让Node对象支持排序（Collections集合排序）
 * 让Node实现Comparable接口
 */
public class Node implements Comparable<Node>{

    int value;//权值
    Node left;//指向左子结点
    Node right;//指向右子结点

    char ch;//节点代表的字符

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }

    /**
     * 前序遍历
     */
    public void preSearch(){
        System.out.println(this);
        Node node = null;

        if(this.left != null){
            node = this.left;
            node.preSearch();
        }

        if(this.right != null){
            node = this.right;
            node.preSearch();
        }
    }
}
