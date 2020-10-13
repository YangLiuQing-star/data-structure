package com.example.linkedlist;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/16 18:49
 * 该类用来操作双向链表
 */
public class DoubleLinkedList {

    //先初始化一个头节点，固定不动，不存放具体数据
    private HeroNode2 head = new HeroNode2(0,"","");

    //添加节点到单链表

    /**
     * 添加一个节点到双向链表的末尾
     * @param heroNode
     */
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        //遍历链表，找到最后一个节点
        while(true){
            if(temp.next==null){//找到链表的最后
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时，temp指向链表的最后
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //显示双向链表
    public void list(){
        if(head.next==null){//链表为空
            System.out.println("链表为空");
            return;
        }
        //定义一个辅助变量来记录头节点的位置
        HeroNode2 temp = head.next;
        while(true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;//后移
        }
    }

    //修改节点信息，根据编号来修改，即编号不能改

    /**
     * 双向链表修改和单向链表几乎一样
     * 只是节点元素不同而已
     * @param heroNode
     */
    public void update(HeroNode2 heroNode){
        if(head.next==null){//链表为空
            System.out.println("链表为空");
            return;
        }
        //根据编号找到需要修改的节点
        HeroNode2 temp = head.next;
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
     * 对于双向链表，可以直接找到要删除的节点
     * 找到后自我删除即可
     * 被删除的节点，会被垃圾回收机制回收
     */
    public void delete(int no){
        if(head.next==null){
            System.out.println("双向链表为空，无法删除");
            return;
        }
        //定义辅助变量记录头节点的位置
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到待删除的节点
        while(true){
            if(temp==null){//已经到链表最后节点的next域
                break;
            }
            if(temp.no==no){//说明已经找到要删除的节点，位置在temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag==true){
            temp.pre.next = temp.next;
            //有风险，如果是最后一个节点，就不需要执行这句话，否则，会出现空指针异常
            if(temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.printf("在双向链表中，准备删除的英雄编号%d不存在",no);
        }

    }

    //考虑编号的顺序，对双向链表添加节点
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = head;
        boolean flag = false;//标志添加的节点是否存在
        while(true){
            if(temp.next == null){//遍历到双向链表最后一个节点
                break;
            }
            if(temp.next.no>heroNode.no){//位置找到，在temp和temp.next之前添加新节点即可
                break;
            }
            if(temp.next.no == heroNode.no){//节点已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //判断flag的值
        if(flag==true){//编号已经存在，添加失败
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入",heroNode.no);
        }else{//编号不存在，插入到temp前
            heroNode.next = temp.next;
            heroNode.pre = temp;
            if(temp.next!=null){
                temp.next.pre = heroNode;
            }
            temp.next = heroNode;
        }
    }

    public HeroNode2 getHead() {
        return head;
    }
}
