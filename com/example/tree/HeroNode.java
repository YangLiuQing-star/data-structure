package com.example.tree;

/**
 * @author YangLiuQing
 * @date 2020/5/23 15:58
 * 节点类
 * 实现二叉树的前序，中序，后序遍历
 */
public class HeroNode {

    private int id;
    private String name;
    private HeroNode left;//指向当前结点的左子结点
    private HeroNode right;//指向当前结点的右子结点

    /**
     * 构造器
     * @param id
     * @param name
     */
    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //向左子树递归
        if(this.left != null){
            this.left.preOrder();
        }
        //向右子树遍历
        if(this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder(){
        //左子树中序遍历
        if(this.left != null){
            this.left.midOrder();
        }
        //输出父节点
        System.out.println(this);

        //向右子树遍历
        if(this.right != null){
            this.right.midOrder();
        }
    }

    public void lastOrder(){
        //左子树递归后序遍历
        if(this.left != null){
            this.left.lastOrder();
        }

        //向右子树递归后序遍历
        if(this.right != null){
            this.right.lastOrder();
        }

        //输出父节点
        System.out.println(this);
    }

    /**
     * 前序查找
     * 根据编号查找指定的节点
     * @param id
     * @return
     */
    public  HeroNode findByPreOrder(int id){
        System.out.println("前序遍历查找次数");
        HeroNode res = null;

        //从父节点开始查询
        if(this.id == id){//父节点的id 是否等于要查找的id
            return this;
        }

        //从左子树开始前序查找
        if(this.left != null){
            //对当前节点前序递归查找
            res = this.left.findByPreOrder(id);
        }
        if(res != null){//说明左子树找到节点
            return res;
        }

        //从右子树开始前序查找
        if(this.right != null){
            res = this.right.findByPreOrder(id);
        }
        if(res != null){//说明右子树找到节点
            return res;
        }
        //节点不存在，返回null
        return res;
    }

    /**
     * 中序查找
     * 根据编号查找指定的节点
     * @param id
     * @return
     */
    public  HeroNode findByMidOrder(int id){
        HeroNode res = null;
        //从父节点的左子节点开始查询
        if(this.left != null){//父节点的id 是否等于要查找的id
            res = this.left.findByMidOrder(id);
        }
        if(res != null){
            return res;
        }

        System.out.println("进入中序遍历查找");

        //查询当前节点
        if(this.id == id){
            return this;
        }

        //从右子节点开始中序递归查找
        if(this.right != null){
            res = this.right.findByMidOrder(id);
        }
        if(res != null){//说明右子树找到节点
            return res;
        }

        //节点不存在，返回null
        return res;
    }

    /**
     * 后序查找
     * 根据编号查找指定的节点
     * @param id
     * @return
     */
    public  HeroNode findByLastOrder(int id){
        HeroNode res = null;

        //从父节点的左子节点开始查询
        if(this.left != null){//父节点的id 是否等于要查找的id
            res = this.left.findByLastOrder(id);
        }
        if(res != null){
            return res;
        }

        //从右子节点开始中序递归查找
        if(this.right != null){
            res = this.right.findByLastOrder(id);
        }
        if(res != null){//说明右子树找到节点
            return res;
        }

        System.out.println("后序遍历查找次数");

        //查询当前节点
        if(this.id == id){
            return this;
        }

        //节点不存在，返回null
        return res;
    }

    /**
     * 删除节点
     * 1.因为二叉树是单向的，所以我们判断当前节点的子节点是否要删除节点，
     * 而不能去判断当前节点是不是需要删除的节点
     * 2.如果当前节点的左子节点不为空，而且左子节点的就是要删除的节点:this.left = null，返回，结束递归
     * 3.如果当前节点的右子树不为空，而且右子节点的就是要删除的节点:this.right = null，返回，结束递归
     * 4.如果3没有删除节点，那么我们需要向左子树进行递归删除
     * 5.如果4没有删除节点，则向右子树进行递归删除
     * @param id 编号
     */
    public void deleteNode(int id){
        if(this.left != null && this.left.id == id){
            this.left = null;
            return;
        }

        if(this.right !=null && this.right.id == id){
            this.right = null;
            return;
        }

        if(this.left != null){
            this.left.deleteNode(id);
        }

        if(this.right != null){
            this.right.deleteNode(id);
        }
    }
}
