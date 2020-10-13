package com.example.tree;

/**
 * @author YangLiuQing
 * @date 2020/5/24 8:53
 * 线索化二叉树
 * 前序，中序，后序线索化二叉树
 * 前驱结点：一个结点的前一个结点
 * 后继结点：一个结点的后一个结点
 */
public class ThreadedBinaryTree {

    private Node root;

    //为了实现线索化，需要创建一个指向当前结点的前驱结点的指针，在递归进行线索化时，递归总是保留前一个结点
    private Node pre;

    public ThreadedBinaryTree(Node root){
        this.root = root;
    }

    /**
     * 中序线索化结点
     * @param node
     */
    public void threadedNodes(Node node){
        if(node == null){//不能线索化
            return;
        }

        //1.线索化左子树
        threadedNodes(node.getLeft());

        //2.线索化当前结点

        //2.1处理当前结点的前驱结点  8号结点为例
        if(node.getLeft() == null){
            //当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点左指针的类型（指向前驱结点）
            node.setLeftType(1);
        }

        //2.2处理当前结点的后继结点
        if(pre != null && pre.getRight() == null){
            //使前驱结点的右指针，指向当前结点
            pre.setRight(node);
            //修改前驱结点右指针的类型为后继结点
            pre.setRightType(1);
        }

        //每处理一个结点后，让前驱结点指向线索化完成的结点，即当前结点是下一个结点的前驱结点
        pre = node;

        //3.线索化右子树
        threadedNodes(node.getRight());
    }

    //重载
    public void threadedNodes(){
        this.threadedNodes(root);
    }


    /**
     * 前序线索化二叉树
     * @param node 根结点
     */
    public void threadedNodesByPreSearch(Node node){
        if(node == null){//不能线索化
            return;
        }

        //1.线索化当前结点

        //1.1处理当前结点的前驱结点
        if(node.getLeft() == null){
            //当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点左指针的类型（指向前驱结点）
            node.setLeftType(1);
        }

        //1.2处理当前结点的后继结点
        if(pre != null && pre.getRight() == null){
            //使前驱结点的右指针，指向当前结点
            pre.setRight(node);
            //修改前驱结点右指针的类型
            pre.setRightType(1);
        }

        //每处理一个结点后，让前驱结点指向线索化完成的结点，即当前结点是下一个结点的前驱结点
        pre = node;

        node = node.getLeft();
        //2.线索化左子树
        threadedNodesByPreSearch(node.getLeft());

        //3.线索化右子树
        threadedNodesByPreSearch(node.getRight());
    }

    public void threadedNodesByPreSearch(){
        threadedNodesByPreSearch(root);
    }

    /**
     * 后序线索化二叉树
     * @param node
     */
    public void threadedNodesByLastSearch(Node node){
        if(node == null){
            return;
        }

        //1.线索化左子树
        threadedNodesByLastSearch(node.getLeft());

        //2.线索化右子树
        threadedNodesByLastSearch(node.getRight());

        //3.线索化当前结点
        //3.1处理当前结点的前驱结点
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        //3.2处理当前结点的后继结点
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        //3.3更新前驱结点为当前结点
        pre = node;
    }

    public void threadedNodesByLastSearch(){
        threadedNodesByLastSearch(root);
    }

    /**
     * 遍历线索化二叉树的方法
     */
    public void threadedList(){
        Node node = root;

        while(node != null){//循环的找到leftType == 1 的结点
            //leftType == 1 说明该结点是按照线索化处理后的有效结点
            while(node.getLeftType() == 0){
                node = node.getLeft();
            }

            //打印当前结点
            System.out.println(node);

            //如果当前结点的右指针指向的是后继结点，就一直输出
            while(node.getRightType() == 1){
                //获取当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }

            //替换遍历的结点
            node = node.getRight();
        }
    }

}
