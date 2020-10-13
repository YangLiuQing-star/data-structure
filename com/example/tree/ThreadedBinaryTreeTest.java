package com.example.tree;

/**
 * @author YangLiuQing
 * @date 2020/5/24 8:52
 * 中序遍历线索化二叉树
 * 8, 3, 10, 1, 14, 6
 * 前序
 * {1,3,8,10,6,14}
 */
public class ThreadedBinaryTreeTest {

    public static void main(String[] args) {
        //创建结点
        Node root = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(10);
        Node node6 = new Node(14);

        //根据结点，构建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);



        //测试中序线索化二叉树
//        ThreadedBinaryTree tree = new ThreadedBinaryTree(root);
//        tree.threadedNodes();
//
//        //测试10号结点
//        Node left = node5.getLeft();
//        Node right = node5.getRight();
//
//        System.out.println("测试中序线索化二叉树:");
//        System.out.println("10号结点的前驱结点是"+left);
//        System.out.println("10号结点的后继结点是"+right);

        //测试前序线索化二叉树
        ThreadedBinaryTree tree = new ThreadedBinaryTree(root);
        tree.threadedNodesByPreSearch();

        //测试10号结点
        Node left = node5.getLeft();
        Node right = node5.getRight();

        System.out.println("测试前序线索化二叉树");
        System.out.println("10号结点的前驱结点是"+left);
        System.out.println("10号结点的后继结点是"+right);

//        System.out.println("使用线索化的方式遍历线索化二叉树:");
//        tree.threadedList();

        //测试后序线索化二叉树
//        ThreadedBinaryTree tree = new ThreadedBinaryTree(root);
//        tree.threadedNodesByLastSearch();
//
//        //测试10号结点
//        Node left = node5.getLeft();
//        Node right = node5.getRight();
//
//        System.out.println("测试后序线索化二叉树");
//        System.out.println("10号结点的前驱结点是"+left);
//        System.out.println("10号结点的后继结点是"+right);
    }
}
