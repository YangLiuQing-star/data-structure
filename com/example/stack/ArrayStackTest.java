package com.example.stack;

import java.util.Scanner;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 10:32
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        //创建栈
        ArrayStack stack = new ArrayStack(5);

        //使用菜单进行测试
        String key = "";
        boolean loop = true;//控制循环
        while(loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:表示退出程序");
            System.out.println("push:表示入栈");
            System.out.println("pop:表示出栈");
            System.out.println("请输入您要进行的操作:");
            Scanner scanner = new Scanner(System.in);
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "exit":
                    loop=false;
                    break;
                case "push":
                    System.out.println("请输入一个的整数:");
                    int val = scanner.nextInt();
                    stack.push(val);
                    System.out.println(val+"入栈成功");
                    break;
                case "pop":
                    int val2 = stack.pop();
                    System.out.println(val2+"出栈成功");
                    break;
                default:{
                    System.out.println("您输入的操作有误，请重新输入");
                    break;
                }
            }
        }
    }
}
