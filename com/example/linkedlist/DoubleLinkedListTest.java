package com.example.linkedlist;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/16 18:49
 * 测试双向列表
 */
public class DoubleLinkedListTest {

    public static void main(String[] args) {
        //先创建几个节点
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
        HeroNode2 hero5 = new HeroNode2(5,"韩信","韩跳跳");
        HeroNode2 hero6 = new HeroNode2(6,"李白","狐白");
        HeroNode2 hero7 = new HeroNode2(7,"孙悟空","猴子");
        HeroNode2 hero8 = new HeroNode2(8,"关羽","关公");

       DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
       //双向链表的顺序和节点的添加顺序一样
//       doubleLinkedList.add(hero1);
//       doubleLinkedList.add(hero3);
//       doubleLinkedList.add(hero4);
//       doubleLinkedList.add(hero2);
//       doubleLinkedList.add(hero5);

        //双向链表的顺序是按照节点编号从小到大的顺序
        doubleLinkedList.addByOrder(hero5);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero6);
        doubleLinkedList.addByOrder(hero7);
        doubleLinkedList.addByOrder(hero8);
       //显示
        //System.out.println("按照编号的顺序添加节点，最终链表的情况:");
       doubleLinkedList.list();

       //修改
/*        HeroNode2 newHeroNode = new HeroNode2(1,"鲁班","取款机");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况:");
        doubleLinkedList.list();*/

        //删除
/*        System.out.println("删除后的链表情况:");
        doubleLinkedList.delete(2);
        doubleLinkedList.list();*/
    }
}
