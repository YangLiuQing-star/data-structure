package com.example.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedList {

    //先初始化一个头节点，固定不动，不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单链表

    /**
     * 实现链表尾部添加结点
     * 当不考虑编号的顺序时，找到当前列表的最后一个节点，将最后一个节点的next域指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //遍历链表，找到最后一个节点
        while(true){
            if(temp.next==null){//找到链表的最后
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp指向链表的最后
        temp.next = heroNode;
    }

    //考虑编号的顺序，从小到大进行添加，因为我们找的temp是位于添加位置的前一个节点
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;//标志添加的节点是否存在
        while(true){
            if(temp.next==null){//链表尾部
                break;
            }
            if(temp.next.no>heroNode.no){//位置找到，添加即可，位置位于temp和temp.next之间
                break;
            }
            if(temp.next.no==heroNode.no){//节点已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //判断flag的值
        if(flag==true){//编号已经存在，添加失败
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入",heroNode.no);
        }else{//编号不存在，插入到temp后
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //显示链表
    public void list(){
        if(head.next==null){//链表为空
            System.out.println("链表为空");
            return;
        }
        //定义一个辅助变量来记录头节点的位置
        HeroNode temp = head.next;
        while(true){
           //判断是否到链表最后
            if(temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //修改节点信息，根据编号来修改，即编号不能修改

    /**
     * 根据新节点的no进行修改
     * @param heroNode
     */
    public void update(HeroNode heroNode){
        if(head.next==null){//链表为空
            System.out.println("链表为空");
            return;
        }
        //根据编号找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;//标志是否找到要修改的节点，默认为false
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.no==heroNode.no){//说明找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag==true){//找到要修改的节点，进行修改即可
            temp.name = heroNode.name;
            temp.nikeName = heroNode.nikeName;
        }else{
            System.out.printf("准备修改的英雄编号%d不存在",heroNode.no);
        }
    }

    /**
     * 删除节点
     * 1.需要找到要删除节点的前一个节点temp
     * 2.temp.next = temp.next.next
     * 被删除的节点，会被垃圾回收机制回收
     */
    public void delete(int no){
        if(head.next==null){
            System.out.println("链表为空，删除失败");
            return;
        }
        //定义辅助变量记录头节点的位置
        HeroNode temp = head;
        boolean flag = false;//记录删除的结果，默认为false
        while(true){
            if(temp.next.no==no){//temp为删除节点的前一个节点
                flag = true;
                break;
            }
            if(temp.next.next==null){//到链表尾，退出循环
                break;
            }
            temp = temp.next;
        }
        if(flag==true){
            temp.next = temp.next.next;
        }else{
            System.out.printf("准备删除的英雄编号%d不存在",no);
        }
    }

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }
}
