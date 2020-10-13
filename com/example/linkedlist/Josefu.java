package com.example.linkedlist;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 8:54
 * 约瑟夫问题
 * 测试类
 */
public class Josefu {

    public static void main(String[] args) {
        SingleCircleLinkedList ls = new SingleCircleLinkedList();
        ls.addBoy(25);
        ls.list();

        //测试小孩出圈的顺序是否正确 2,4,1,5,3
        ls.countBoy(1,2,5);
    }
}
