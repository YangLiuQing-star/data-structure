package com.example.tree;

/**
 * @author YangLiuQing
 * @date 2020/5/24 7:33
 * 实现顺序存储二叉树的遍历
 */
public class ArrBinaryTree {
    
    private int arr[];//存储结点

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    /**
     * 完成顺序存储二叉树的前序遍历
     * @param index 数组的下标，对应二叉树结点的编号
     */
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }

        //输出当前数组元素
        System.out.print(arr[index]+"\t");

        //向左递归遍历
        if(index * 2 + 1 < arr.length){//保证数组不能越界
            preOrder(index * 2 + 1);
        }

        //向右递归遍历
        if(index * 2 + 2 < arr.length){
            preOrder(index * 2 + 2);
        }
    }

    //重载前序遍历的方法
    public void preOrder(){
        this.preOrder(0);
    }

    /**
     * 实现顺序存储二叉树的中序遍历
     * @param index 根节点
     */
    public void midOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }

        //向左递归遍历
        if(index * 2 + 1 < arr.length){//保证数组不能越界
            midOrder(index * 2 + 1);
        }

        //输出当前数组元素
        System.out.print(arr[index]+"\t");


        //向右递归遍历
        if(index * 2 + 2 < arr.length){
            midOrder(index * 2 + 2);
        }
    }

    //重载中序遍历的方法
    public void midOrder(){
        this.midOrder(0);
    }

    /**
     * 顺序存储二叉树的后序遍历
     * @param index 根节点
     */
    public void lastOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }

        //向左递归遍历
        if(index * 2 + 1 < arr.length){//保证数组不能越界
            lastOrder(index * 2 + 1);
        }

        //向右递归
        if(index * 2 + 2 < arr.length){
            lastOrder(index * 2 + 2);
        }

        //输出当前数组元素
        System.out.print(arr[index]+"\t");
    }

    //重载后序遍历的方法
    public void lastOrder(){
        this.lastOrder(0);
    }

}
