package com.example.avl;

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

    //返回以该结点为根结点的这个树的高度
    public int height(){
        //左子树高度和右子树高度中的最大值+1 = 树的高度
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
    }

    //返回左子树的高度
    public int leftHeight(){
        if(left == null){
            return 0;
        }else{
            return left.height();
        }
    }

    //返回右子树的高度
    public int rightHeight(){
        if(right == null){
            return 0;
        }else{
            return right.height();
        }
    }

    /**
     * 左旋转二叉排序树
     */
    private void leftRotate(){
        //1.根据当前根结点的值，创建一个新的结点
        Node newNode = new Node(value);
        //2.把新的结点的左子树，设置成当前结点的左子树
        newNode.left = left;
        //3.把新结点的右子树，设置成当前结点的右子树的左子树
        newNode.right = right.left;
        //4.把当前结点的值替换成右子结点的值
        value = right.value;
        //5.把当前结点的右子树设置成当前结点的右子树的右子树
        right = right.right;
        //6.把当前结点的左子树设置成新的结点
        left = newNode;
    }

    /**
     * 右旋转二叉排序树
     */
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * 递归添加结点
     * avl树前提必须是二叉排序树
     * @param node 要添加的结点
     */
    public void addNode(Node node){
        if(node == null){
            return;
        }

        //根据传入结点的值和当前子树根结点的值进行比较
        if(node.value < this.value){//当前结点的值小于当前子树根结点的值
            if(this.left == null){//根节点的左子树为空，添加传入的结点即可
                this.left = node;
            }else{//递归向左子树添加
                this.left.addNode(node);
            }
        }else{//当前结点的值大于当前子树根结点的值
            if(this.right == null){//根节点的右子树为空，添加传入的结点即可
                this.right = node;
            }else{//递归向右子树添加
                this.right.addNode(node);
            }
        }

        //当一个结点添加完成后，(如果右子树的高度 - 左子树的高度) >1，则左旋转
        if(rightHeight() - leftHeight() > 1){//进行左旋转
            if(right != null && right.leftHeight() > right.rightHeight()){
                //先将当前结点的右结点进行右旋转
                left.rightRotate();
                //然后再对当前结点进行左旋转
                leftRotate();
            }else{//直接对当前结点进行左旋转即可
                leftRotate();
            }
            return;//平衡处理过后，直接返回即可，没必要继续处理
        }

        //当一个结点添加完成后，(如果左子树的高度 - 右子树的高度) >1，则右旋转
        if(leftHeight() - rightHeight() > 1){//进行右旋转
            if(left !=null && left.rightHeight() > left.leftHeight()){
                //先将当前结点的左结点进行左旋转
                left.leftRotate();
                //然后再对当前结点进行右旋转
                rightRotate();
            }else{//直接对当前结点进行右旋转即可
                rightRotate();
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }
}
