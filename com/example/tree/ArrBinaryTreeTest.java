package com.example.tree;

/**
 * @author YangLiuQing
 * @date 2020/5/24 7:33
 * 二叉树按数组存储，但是也能按照树的方式进行前序，中序，后序遍历
 */
public class ArrBinaryTreeTest {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        //创建一个ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("顺序存储二叉树的前序遍历结果:");
        arrBinaryTree.preOrder();//1	2	4	5	3	6	7

        System.out.println();

        System.out.println("顺序存储二叉树的中序遍历结果:");
        arrBinaryTree.midOrder();//4	2	5	1	6	3	7

        System.out.println();


        System.out.println("顺序存储二叉树的后序遍历结果:");
        arrBinaryTree.lastOrder();//4	5	2	6	7	3	1
    }
}

