package com.example.linkedlist;

//每个HeroNode对象就是一个节点
public class HeroNode {
    public int no;
    public String name;
    public String nikeName;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName +"'"+
                '}';
    }
}
