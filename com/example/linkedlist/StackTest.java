package com.example.linkedlist;

import java.util.Stack;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/16 8:21
 * 演示栈的基本使用
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //进栈 jack tom smith
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        //出栈 smith tom jack
        while(stack.size()>0){
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }
    }
}
