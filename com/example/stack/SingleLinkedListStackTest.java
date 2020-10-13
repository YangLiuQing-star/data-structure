package com.example.stack;

import java.util.Scanner;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 11:41
 */
public class SingleLinkedListStackTest {

    public static void main(String[] args) {
        //用来接收用户的输入
        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        //创建栈
        SingleLinkedListStack stack = new SingleLinkedListStack();


        while(loop){
            System.out.println("s(show):显示栈");
            System.out.println("e(exit):退出程序");
            System.out.println("a(push):入栈");
            System.out.println("g(get):出栈");
            System.out.println("t(top):查看栈顶的数据");
            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                stack.list();
                break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("\n请输入一个整数:");
                    int i = scanner.nextInt();
                    stack.push(new Node(i));
                    System.out.println("编号为"+i+"的结点已经入栈");
                    break;
                case 'g':
                    Node node = stack.pop();
                    if(node != null){
                        System.out.println(node+"成功出栈...");
                    }
                    break;
                case 't':
                    Node top = stack.getTop();
                    if(top!=null){
                        System.out.println("栈顶结点的编号为"+top);
                    }
                    break;
                default:{
                    System.out.println("输入有误，请重新输入操作...");
                }
            }
        }

        System.out.println("程序成功退出......");
    }
}
