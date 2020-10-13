package com.example.linkedlist;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 8:48
 * 单向环形链表的创建
 * 1.先创建第一个节点，让first指向该节点，并形成环形
 * 2.后面我们每创建一个新的节点，我们就把该节点加入到已有的环形链表中即可
 *
 * 遍历环形链表
 * 1.先让一个辅助指针遍历cur，指向first节点，当cur.next==first遍历结束
 * 2.然后通过while循环遍历环形链表
 */
public class SingleCircleLinkedList {

    //创建一个first节点，当前没有编号
    private Boy first = null;

    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int num){
        //数据校验
        if(num<1){
            System.out.println("num的值不正确");
            return;
        }

        Boy curBoy = null;//辅助变量，帮助构建环形链表

        //for循环创建环形链表
        for(int i=1;i<=num;i++){
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i==1){
                first = boy;
                first.setNext(first);//形成环状
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;//指向单链表的当前元素
            }
        }
    }

    //遍历单向环形链表
    public void list(){
        if(first==null){
            System.out.println("当前链表为空，没有任何小孩");
            return;
        }
        //first不能动，使用辅助指针完成遍历
        Boy curBoy = first;
        while(curBoy.getNext()!=first){//遍历到链表的末尾
            System.out.println("小孩的编号:"+curBoy.getNo());//输出当前节点的编号
            curBoy = curBoy.getNext();//后移
        }
    }

    //根据用户的输入，生成一个出圈的顺序
    //1.创建一个辅助指针遍历（helper），事先应该指向环形链表的最后一个节点
    //2.当小孩报数前，helper和first移动startNo-1次
    //3.让first和helper指针同时移动m-1次
    //4.first指向的小孩节点出圈[first= first.next，helper.next=first]，删除的节点没有任何引用，会被回收

    /**
     *
     * @param startNo 从第几个小孩开始数数
     * @param count 数几下
     * @param num 最初有多少小孩在圈中
     */
    public void countBoy(int startNo,int count,int num){
        if(first==null||startNo<1||startNo>num){
            System.out.println("参数输入有误，请重新输入!");
            return;
        }
        //1.
        Boy helper = first;
        while(helper.getNext()!=first){
            helper = helper.getNext();//辅助指针后移
        }
        //此时helper指向最后一个节点

        //报数前，helper，first移动k-1次
        for(int i=0;i<startNo-1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让first和helper指针同时移动count-1次，然后出圈
        //循环操作，直到圈中只有一个节点
        while(first != helper){//first==helper说明圈中只有一个节点
            for(int i=0;i<count-1;i++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //指向下一个开始报数的节点
            first = first.getNext();
            //移除该小孩
            helper.setNext(first);
        }

        System.out.printf("最后留在圈中的小孩编号%d\n",first.getNo());
    }
}
