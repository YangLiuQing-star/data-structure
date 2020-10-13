package com.example.queue;

import java.util.Scanner;

public class CircleQueueDemo {

    public static void main(String[] args) {
        //创建一个队列
        CircleQueue circleQueue = new CircleQueue(4);//最大有效数据为3，因为预留了一个位置
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("\ns(show):显示队列");
            System.out.println("e(show):退出程序");
            System.out.println("a(show):添加数据到队列");
            System.out.println("g(show):从队列取出数据");
            System.out.println("h(show):查看队列头的数据");
            key = scanner.next().charAt(0);//返回字符串中下标为0的字符
            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个整数:");
                    int n = scanner.nextInt();
                    circleQueue.addQueue(n);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try {
                        int data = circleQueue.getQueue();
                        System.out.println(data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headData = circleQueue.headQueue();
                        System.out.println(headData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        System.out.println("程序退出...");
    }
}
