package com.example.stack;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 11:41
 * 使用单链表实现栈的基本操作
 */
public class SingleLinkedListStack {

    private Node head = new Node(0);//单链表的头结点，固定不动
    private Node top = null;//栈顶指针，指向栈顶元素


    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == null;
    }

    /**
     * 入栈
     * @param node
     */
    public void push(Node node){
        Node temp = head;
        while(true){
            if(temp.next == null){//到达栈顶，找到添加的位置
                break;
            }
            temp = temp.next;//后移
        }
        temp.next = node;//在栈顶添加结点
        top = node;//栈顶指针指向新增的结点
    }

    public Node pop(){
        if(head.next == null){
            System.out.println("栈为空，没有结点可以出栈");
            return null;
        }
        //栈非空
        Node temp = head;

        //1.取出栈顶的结点
        Node node = top;
        //2.top下移，需要找到栈顶的前一个位置，让top指向此位置
        while(true){
            if(temp.next == top){//已经遍历到栈顶的前一个位置
                break;
            }

            temp = temp.next;//后移
        }
        //删除栈顶结点，同时让top指向栈顶的前一个位置
        temp.next = null;
        top = temp;

        return node;
    }

    /**
     * 从栈顶结点开始，显示栈
     */
    public void list(){
        if (head.next == null){
            System.out.println("栈为空，没有数据可以遍历");
            return;
        }
        //栈非空，先进行反转，再遍历
        reverse();
        //因为头结点不能移动，所以定义一个辅助变量，完成栈的遍历
        Node helper = head.next;

        while(true){
            if(helper == null){
                break;
            }
            System.out.println(helper);
            //后移
            helper = helper.next;
        }
    }

    /**
     * 实现单链表的反转
     */
    public void reverse(){
        if(head.next == null || head.next.next == null){//栈为空或者栈中只有一个结点，直接返回，不需要反转
            return;
        }

        //定义一个新的头节点
        Node reverseHead = new Node(0);
        //定义一个辅助遍历，完成栈的遍历
        Node cur = head.next;
        //用来保存当前结点的下一个结点
        Node next = null;
        while(true){
            if(cur == null){//遍历到栈顶
                break;
            }
            next = cur.next;
            //摘下cur结点
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 查看栈顶数据，并不是出栈
     * @return
     */
    public Node getTop(){
        if(isEmpty()){
            System.out.println("栈为空，没有栈顶数据...");
            return null;
        }
        return top;
    }
}
