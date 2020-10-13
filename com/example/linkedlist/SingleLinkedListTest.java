package com.example.linkedlist;


import java.util.Stack;

/**
 * 测试单链表
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {
        //先创建几个节点
//        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
//        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
//        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
//        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
//        HeroNode hero5 = new HeroNode(5,"韩信","韩跳跳");
//        HeroNode hero6 = new HeroNode(6,"李白","狐白");
//        HeroNode hero7 = new HeroNode(7,"孙悟空","猴子");
//        HeroNode hero8 = new HeroNode(8,"关羽","关公");

//        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        SingleLinkedList singleLinkedList3 = new SingleLinkedList();

        //不按编号进行添加
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //按照编号顺序进行添加

//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero5);

//        singleLinkedList.list();
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero5);
//        singleLinkedList.add(hero6);
//        singleLinkedList.add(hero7);
//        singleLinkedList.add(hero8);
//        singleLinkedList2.addByOrder(hero2);
//        singleLinkedList2.addByOrder(hero4);
//        System.out.println("单链表1");
//        singleLinkedList.list();
//        HeroNode lastIndexHeroNode = findLastIndexHeroNode(singleLinkedList, 1);
//        System.out.println(lastIndexHeroNode);
//        System.out.println("单链表2");
//        singleLinkedList2.list();
//
//        HeroNode node = mergeLinkList(singleLinkedList.getHead(), singleLinkedList2.getHead());
//        singleLinkedList3.setHead(node);
//        System.out.println("链表1和链表2，合并后的有序链表");
//        singleLinkedList3.list();


//
//        System.out.println("原来列表的情况:");
//        singleLinkedList.list();
//        System.out.println("逆序打印单链表:");
//        reversePrint(singleLinkedList.getHead());
//        System.out.println("逆序打印单链表，没有改变原始链表的结构:");
//        singleLinkedList.list();
//        System.out.println("反转后的列表情况:");
//
//        reverseSingleLinkedList(singleLinkedList.getHead());
//        singleLinkedList.list();
//        //测试修改
//        singleLinkedList.update(newhero2);

        //测试删除
//        singleLinkedList.delete(4);
//        singleLinkedList.list();

        //获取单链表的长度
//        int length = getLength(singleLinkedList);
//        System.out.printf("单链表的长度=%d\n",length);

        //查找单链表的倒数第2个节点
//        HeroNode node = findLastIndexHeroNode(singleLinkedList, 3);
//        System.out.println(node);

        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        HeroNode hero5 = new HeroNode(5,"韩信","韩跳跳");
        HeroNode hero6 = new HeroNode(6,"李白","狐白");
        HeroNode hero7 = new HeroNode(7,"孙悟空","猴子");
        HeroNode hero8 = new HeroNode(8,"关羽","关公");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero5);
        singleLinkedList.add(hero7);

        singleLinkedList2.add(hero2);
        singleLinkedList2.add(hero4);
        singleLinkedList2.add(hero8);

        HeroNode mergeLinkList = mergeLinkList(singleLinkedList.getHead().next, singleLinkedList2.getHead().next);
        singleLinkedList3.getHead().next = mergeLinkList;
        singleLinkedList3.list();
    }

    //获取到单链表节点的个数（如果是带头节点的链表，不统计头节点）

    /**
     * 1.判断单链表是否为空
     * 2.从头节点开始遍历单链表
     * @param singleLinkedList
     * @return 有效节点的个数
     */
    public static int getLength(SingleLinkedList singleLinkedList){
        int length = 0;
        HeroNode head = singleLinkedList.getHead();
        if(head.next==null){
            return 0;
        }
        //从第一个节点开始遍历
        HeroNode temp = head.next;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    //查找倒数第k个节点，相当于查找length-k个节点
    public static HeroNode findLastIndexHeroNode(SingleLinkedList linkedList,int k){
        HeroNode head = linkedList.getHead();
        int length = getLength(linkedList);
        if(head == null){
            System.out.println("单链表为空，查找失败");
        }
        if(k > length){
            System.out.printf("第%d个节点不存在，查找失败\n",k);
        }
        //查找倒数第k个节点，相当于查找第length-k个节点
        //从第一个遍历单链表
        HeroNode temp = head.next;
        for(int i=0;i< length-k;i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 单链表的反转
     * 思路分析
     * 1.定义一个新的头节点
     * 2.遍历原始单链表中的每个节点（除头节点），并放在新链表的reverseHead的最前面
     * 3.原来链表的head.next = reverseHead.next
     * @param head 链表的头节点
     */
    public static void reverseSingleLinkedList(HeroNode head){
       if(head.next==null||head.next.next==null){//链表为空或者链表长度为1
           return;
       }
        //定义一个辅助变量来遍历原始链表
        HeroNode curr = head.next;
        //定义新的新头节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode next = null;//用来保存当前节点的下一个节点
       while(curr!=null){//遍历到链表尾，结束循环
            next = curr.next;//保存当前节点的下一个节点，下次从当前节点的下一个节点开始遍历
            curr.next = reverseHead.next;//将curr的下一个节点指向新的链表的最前端（即头节点后的一个空节点）
           reverseHead.next = curr;//将curr连接到新的链表上
           curr = next;
       }

       //将head.next 指向 reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    //逆序打印单链表
    //方式1.先将单链表反转，然后遍历即可，会破坏原来单链表的结构，不可取
    //方式2.可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head){
        if(head.next==null){
            return;//空链表，无法打印
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈中
        while(cur!=null){
            stack.push(cur);//入栈
            cur = cur.next;//后移
        }
        //将栈中的节点进行打印，出栈
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序（不带头结点的单链表）
     * @param head1
     * @param head2
     * @return
     */
    public static HeroNode mergeLinkList(HeroNode head1,HeroNode head2){
        if(head1==null&&head2==null){//两个链表都为空
            return null;
        }
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }

        HeroNode head;//定义新链表的头节点
        HeroNode cur;//cur节点指向新链表
        //一开始，我们是cur节点指向head1和head2中较小数据域的节点，得到head节点
        if(head1.no < head2.no){
            head = head1;
            cur = head1;
            head1 = head1.next;
        }else{
            head = head2;
            cur = head2;
            head2 = head.next;
        }
        //在新链表中，cur指向的下一个节点对应较小的哪个数据
        while(head1 != null && head2 != null){
            if(head1.no < head2.no){
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }else{
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        //合并剩余的元素
        if(head1!=null){//说明链表2遍历结束，为空
            cur.next = head1;
        }
        if(head2!=null){//说明链表1遍历结束，为空
            cur.next = head2;
        }
        return head;
    }
}
