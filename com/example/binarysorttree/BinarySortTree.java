package com.example.binarysorttree;

/**
 * @author YangLiuQing
 * @date 2020/5/26 9:35
 * 二叉排序树
 * 对于任何一个非叶子结点，左子节点的值比当前节点的值小，右子节点的值比当前节点的值大
 */
public class BinarySortTree {

    private Node root;

    /**
     * 添加结点
     * @param node
     */
    public void add(Node node){
        if(root == null){//如果是空树，让root指向node即可
            root = node;
        }else{
            root.addNode(node);
        }
    }

    /**
     * 查找要删除的结点
     * @param value
     * @return
     */
    public Node search(int value){
        if(root == null){//二叉树为空，直接返回null
            return null;
        }else{
            return root.search(value);
        }
    }

    /**
     * 查找当前结点的父节点
     * @param value
     * @return
     */
    public Node searchParentNode(int value){
        if(root == null){//二叉树为空，直接返回null
            return null;
        }else{
            return root.searchParentNode(value);
        }
    }

    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }else{
            System.out.println("二叉排序树为空，无法中序遍历.");
        }
    }

    /**
     * 删除0棵子树的结点（叶子结点）
     * 思路:
     * 1.先找到要删除的结点 targetNode
     * 2.找到删除结点的父节点parent
     * 3.确定targetNode是parent的左子结点，还是右子结点
     * 4.根据前面的情况，对应删除
     * 如果删除的是parent的左子结点，parent.left = null
     * 如果删除的是parent的右子结点，parent.right = null
     */

    /**
     * 删除1棵子树的结点
     * 思路:
     * 1.先找到要删除的结点 targetNode
     * 2.找到删除结点的父节点parent
     * 3.确定targetNode的子结点是左子结点，还是右子结点
     * 4.确定targetNode是parent的左子结点，还是右子结点
     * 5.如果targetNode有左结点，区分targetNode是parent的左（右）结点
     * parent.left = targetNode.left    parent.right = targetNode.left
     * 如果targetNode有右结点，区分targetNode是parent的左（右）结点
     * parent.left = targetNode.right   parent.right = targetNode.right
     *
     */

    /**
     * 删除2棵子树的结点
     * 思路:
     * 1.先找到要删除的结点 targetNode
     * 2.找到删除结点的父节点parent
     * 3.区分targetNode是parent的左（右）结点
     * 4.从targetNode的右子结点找到最小的结点
     * 5.用一个临时变量，把最小结点的值保存 temp
     * 6.删除最小结点 targetNode.left = null
     * 7.targetNode.value = temp;
     *
     */

    public void deleteNode(int value){
        if(root == null){
            return;
        }else{
            //1.先找到要删除的结点
            Node targetNode = search(value);
            if(targetNode == null){//删除的结点不存在
                return;
            }
            //如果当前二叉排序树只有一个结点，即根结点，将整棵二叉排序树置空
            if(root.left == null && root.right == null){
                root = null;
                return;
            }

            //查找targetNode的父结点
            Node parentNode = searchParentNode(value);
            //如果要删除的结点是叶子结点
            if(targetNode.left == null && targetNode.right == null){
                //判断targetNode是父结点的左子结点还是右子结点
                if(parentNode.left !=null && parentNode.left.value == value){//是父结点的左子结点
                    parentNode.left = null;
                }else if(parentNode.right != null && parentNode.right.value == value){//是父结点的右子结点
                    parentNode.right = null;//将目标结点置空
                }
            }else if(targetNode.left != null && targetNode.right != null){//删除有左，右子树的结点
//                //向左子结点一直往左查找
//                int min = delRightTreeMin(targetNode.right);
//                //重置
//                targetNode.value = min;

                int max = delLeftTreeMax(targetNode.left);
                targetNode.value = max;
            }else{//删除只有一棵子树的结点
                //如果要删除的结点有左子结点
                if(targetNode.left != null){
                    if(parentNode == null){//直接让root结点指向targetNode.left
                        root = targetNode.left;
                    }else{
                        if(parentNode.left.value == value){//目标结点为父结点的左子结
                            parentNode.left = targetNode.left;
                        }else{//父结点的右子结点为目标结点
                            parentNode.right = targetNode.left;
                        }
                    }
                }else{//如果要删除的结点有右子结点
                    if(parentNode == null){
                        root = targetNode.right;
                    }else {
                        //如果targetNode是parentNode左子结点
                        if(parentNode.left.value == value){
                            parentNode.left = targetNode.right;
                        }else{//如果targetNode是parentNode右子结点
                            parentNode.right = targetNode.right;
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param node 传入的结点，当做一棵二叉排序树的根节点
     * @return 以node为根结点的右子树中最小结点的值，同时删除此最小结点
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环查找左结点，找到最小值
        while(target.left != null){
            target = target.left;
        }
        //此时target指向了最小结点，删除最小结点
        deleteNode(target.value);
        //返回最小结点的值
        return target.value;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     *
     * @param node 传入的结点，当做一棵二叉排序树的根节点
     * @return 以node为根结点的左子树中最大结点的值，同时删除此最大结点
     */
    public int delLeftTreeMax(Node node){
        Node target = node;

        //循环向右查找结点的最大值
        while(target.right != null){
            target = target.right;
        }
        //此时结点的最大值已经找到，删除该结点
        deleteNode(target.value);
        //返回最大结点的值
        return target.value;
    }
}
