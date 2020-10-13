package com.example.linkedlist;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 8:54
 * 节点类
 * 约瑟夫问题
 */
public class Boy {

    private int no;
    private Boy next;//指向下一个节点，默认为null

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}
