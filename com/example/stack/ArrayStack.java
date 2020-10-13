package com.example.stack;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 10:32
 *
 * 从左到右扫描表达式，遇到数字直接入栈，遇到运算符，从数栈中弹出2个数，进行运算（后面减前面）
 * 数组模拟栈
 */
public class ArrayStack {

    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈，数据放在该数组中
    private int top = -1;//栈顶，初始化为-1，表示没有数据

    //构造栈
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈---push
    public void push(int val){
        if(isFull()){//先判断栈是否满
            System.out.println("栈已满，无法入栈");
            return;
        }
        top++;
        stack[top] = val;
    }

    //出栈---pop:将栈顶的数据返回
    public int pop(){
        if(isEmpty()){
           throw new RuntimeException("栈为空，无法取数据");
        }
        //取出栈顶数据
        int val = stack[top];
        //栈顶下移
        top--;
        return val;
    }

    //遍历栈，从栈顶开始遍历数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈为空，没有数据可以遍历");
            return;
        }
        for(int i=top;i>=0;i-- ){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
