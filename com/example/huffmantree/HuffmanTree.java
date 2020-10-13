package com.example.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YangLiuQing
 * @date 2020/5/25 9:20
 * 哈夫曼树
 * 赫夫曼树是所有叶子结点带权路径长度最短的树(wpl最小)
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preSearch(root);
    }

    /**
     * 创建哈弗曼树
     * 循环处理，直到所有数据处理完
     * @param arr
     */
    public static Node createHuffmanTree(int[] arr){
        int count = 0;//用来统计处理的次数
        //1.完成排序
        List<Node> nodes = new ArrayList<>();
        //构建结点
        for(int item:arr){
            Node node = new Node(item);
            nodes.add(node);
        }

        while(nodes.size() != 1){
            count++;

            //从小到大排序
            Collections.sort(nodes);
            System.out.println("第"+count+"次处理前:nodes="+nodes);

            //2.取出权值最小的两个结点，规定权值小的结点作为左子结点，权值大的结点作为右子结点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //根据权值最小的两个结点，构建出一个新的父结点
            Node parent = new Node(leftNode.value + rightNode.value);
            //构建一棵新的树
            parent.left = leftNode;
            parent.right = rightNode;
            //从集合中删除最小的两个结点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //父结点加入到nodes
            nodes.add(parent);

            System.out.println("第"+count+"次处理后:nodes="+nodes);

        }
        //返回哈弗曼树的root结点
        return nodes.get(0);
    }

    /**
     * 前序遍历哈弗曼树
     * @param root
     */
    public static void preSearch(Node root){
        if(root == null){
            System.out.println("该哈弗曼树是空树，无法前序遍历.");
            return;
        }
        root.preSearch();
    }
}
