package com.example.tree;

/**
 * @author YangLiuQing
 * @date 2020/5/24 8:56
 */
public class Node {

    private int id;

    private Node left;

    private Node right;

    //规定:leftType = 0表示，指向的左子树，leftType = 1表示，指向前驱结点
    private int leftType;

    //规定:rightType = 0表示，指向的右子树，rightType = 1表示，指向后继结点
    private int rightType;

    public Node(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
