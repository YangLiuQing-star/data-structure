package com.example.binarysorttree;

/**
 * @author YangLiuQing
 * @date 2020/5/26 9:35
 * 节点类
 */
public class Node {

    public  int value;//结点的值
    public Node left;//左子结点
    public Node right;//右子结点

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 递归添加结点
     * 需要满足二叉排序树的要求
     * @param node
     */
    public void addNode(Node node){
        if(node == null){
            return;
        }

        //根据传入结点的值（node）和当前子树根结点（this）的值进行比较
        if(node.value < this.value){//当前结点的值小于当前子树根结点的值
            if(this.left == null){//根节点的左子树为空，添加传入的结点即可
                this.left = node;
            }else{//向左子树递归添加
                this.left.addNode(node);
            }
        }else{//当前结点的值（node）大于当前子树根结点（this）的值
            if(this.right == null){//根节点的右子树为空，添加传入的结点即可
                this.right = node;
            }else{//向右子树递归添加
                this.right.addNode(node);
            }
        }
    }

    //二叉树的中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }

    /**
     * 根据结点的值查找指定的结点
     * @param value 结点的值
     * @return 结点
     */
    public Node search(int value){
        if(value == this.value){//找到当前结点
            return this;
        }else if(value < this.value ){//要查找的值 < 当前结点的值，向左子树递归查找
            if( this.left == null){
                return null;
            }
            //继续向左子树递归查找
            return this.left.search(value);
        }else {//要查找的值 > 当前结点的值，向右子树递归查找
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 根据结点的值查找此结点的父节点
     * @param value 要查找结点的值
     * @return 要删除结点的父节点，如果没有返回null
     */
    public Node searchParentNode(int value){
        if((this.left != null && this.left.value == value) ||
                (this.right !=null && this.right.value == value)){//如果当前结点是要删除结点的父节点
            return this;
        }else{//如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if(value <this.value && this.left != null){//向左子树递归查找
                return this.left.searchParentNode(value);
            }else if(value >= this.value && this.right != null){//向右子树递归查找
                return this.right.searchParentNode(value);
            }else{//左子树或者右子树为空，找不到父结点
                return null;
            }
        }
    }


}
