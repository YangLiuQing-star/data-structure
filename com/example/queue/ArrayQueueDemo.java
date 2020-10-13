package com.example.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(show):退出程序");
            System.out.println("a(show):添加数据到队列");
            System.out.println("g(show):从队列取出数据");
            System.out.println("h(show):查看队列头的数据");
            key = scanner.next().charAt(0);//返回字符串中下标为0的字符
            switch(key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个整数:");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try{
                        int data = arrayQueue.getQueue();
                        System.out.println(data);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                    int headData = arrayQueue.headQueue();
                    System.out.println(headData);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        System.out.println("程序退出...");
    }
}


