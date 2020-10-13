package com.example.avl;

/**
 * @author YangLiuQing
 * @date 2020/5/26 17:52
 * 平衡树
 */
public class AVLTreeTest {

    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
        //int[] arr = {10,12,8,9,7,6};
        int[] arr = {10,11,7,6,8,9};
        //创建一个AVLTree
        AVLTree avlTree = new AVLTree();
        for(int i = 0;i < arr.length;i++){
            avlTree.add(new Node(arr[i]));
        }

        System.out.println("中序遍历:");
        avlTree.infixOrder();

        System.out.println("二叉排序树平衡处理中..........");
        System.out.println("树的高度"+avlTree.getRoot().height());
        System.out.println("树左子树的高度"+avlTree.getRoot().leftHeight());
        System.out.println("树右子树的高度"+avlTree.getRoot().rightHeight());
        System.out.println("当前的根结点="+avlTree.getRoot());
    }
}
