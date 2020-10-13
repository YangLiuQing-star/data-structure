package com.example.tree;

/**
 * @author YangLiuQing
 * @date 2020/5/23 15:58
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        //创建节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"关胜");
        //手动构建一棵二叉树
        BinaryTree tree = new BinaryTree(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

//        System.out.println("前序遍历:");//12354
//        tree.preOrder();
//        System.out.println("中序遍历:");//21534
//        tree.midOrder();
//        System.out.println("后序遍历:");//25431
//        tree.lastOrder();

        System.out.println("前序遍历方式查找结果:");
        tree.findByPreOrder(5);
        System.out.println("\n中序遍历方式查找结果:");
        tree.findByMidOrder(5);
        System.out.println("\n后序遍历方式查找结果:");
        tree.findByLastOrder(5);

//        System.out.println("删除前，前序遍历的结果");//12354
//        tree.preOrder();
//        tree.deleteNode(3);
//
//        System.out.println();
//        System.out.println("删除后，前序遍历的结果");//1234
//        tree.preOrder();
    }
}
