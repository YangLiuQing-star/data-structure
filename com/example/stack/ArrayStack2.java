package com.example.stack;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 21:06
 */
public class ArrayStack2 {

    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈，数据放在该数组中
    private int top = -1;//栈顶，初始化为-1，表示没有数据

    //构造栈
    public ArrayStack2(int maxSize) {
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

    //返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示，数字越大，优先级最高
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;//指定目前的表达式只有 +,-,*,/
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//用于存放计算的结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

    //返回栈顶的值，但是不是真正的pop（出栈）
    public int peek(){
        return stack[top];
    }
}
