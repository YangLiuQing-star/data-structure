package com.example.binarysorttree;

/**
 * @author YangLiuQing
 * @date 2020/5/26 9:35
 * 二叉排序树
 */
public class BinarySortTreeTest {

    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环添加结点到二叉排序树
        for(int i = 0;i < arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        binarySortTree.infixOrder();//1 3 5 7 9 10 12

        //测试删除叶子结点
        binarySortTree.deleteNode(3);
        binarySortTree.deleteNode(5);
        binarySortTree.deleteNode(7);
        binarySortTree.deleteNode(9);
        binarySortTree.deleteNode(12);
        binarySortTree.deleteNode(2);

//        System.out.println("root="+binarySortTree.getRoot());

        binarySortTree.deleteNode(10);
        binarySortTree.deleteNode(1);



        System.out.println("删除结点后：");
        binarySortTree.infixOrder();
    }


}
