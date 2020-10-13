package com.example.linkedlist;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/16 18:50
 * 该类用来表示双向链表中的单个节点
 */
public class HeroNode2 {
    public int no;
    public String name;
    public String nikeName;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指向前一个节点，默认为null

    //构造器
    public HeroNode2(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName +"'"+
                '}';
    }
}
