package com.example.tree;

/**
 * @author YangLiuQing
 * @date 2020/5/23 16:09
 * 二叉树
 */
public class BinaryTree {

    private HeroNode root;

    public BinaryTree(HeroNode root){
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(root != null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法前序遍历");
        }
    }

    //中序遍历
    public void midOrder(){
        if(root != null){
            this.root.midOrder();
        }else{
            System.out.println("二叉树为空，无法中序遍历");
        }
    }

    //后序遍历
    public void lastOrder(){
        if(root != null){
            this.root.lastOrder();
        }else{
            System.out.println("二叉树为空，无法后序遍历");
        }
    }

    public void findByPreOrder(int id){
        HeroNode node = this.root.findByPreOrder(id);
        if(node!=null){
            System.out.println("id="+id+"的节点信息为:"+node);
        }else {
            System.out.println("id="+id+"的节点信息不存在");
        }
    }

    public void findByMidOrder(int id){
        HeroNode node = this.root.findByMidOrder(id);
        if(node!=null){
            System.out.println("id="+id+"的节点信息为:"+node);
        }else {
            System.out.println("id="+id+"的节点信息不存在");
        }
    }

    public void findByLastOrder(int id){
        HeroNode node = this.root.findByLastOrder(id);
        if(node!=null){
            System.out.println("id="+id+"的节点信息为:"+node);
        }else {
            System.out.println("id="+id+"的节点信息不存在");
        }
    }

    /**
     * 如果树是空树，无法删除
     * 如果只有一个root节点，则等价于将二叉树置空
     * @param id
     */
    public void deleteNode(int id){
        if(root == null){
            System.out.println("树是空树，无法删除");
        }else{
            if(root.getId() == id){//判断父节点是否是要删除的节点，步骤2
                root = null;//父结点置空
            }else{
                this.root.deleteNode(id);
            }
        }
    }
}
