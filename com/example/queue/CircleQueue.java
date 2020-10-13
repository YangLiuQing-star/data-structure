package com.example.queue;

//数组模拟环形队列

public class CircleQueue {
    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据

    public CircleQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列的第一个元素
        rear = 0;//指向队列尾的后一个位置（预留一个作为约定）
    }

    //判断队列是否为满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能加入数据.");
            return;
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;//rear后移
    }

    //出队列
    public int getQueue(){
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列为空，无法取数据");
        }
        //front指向队列的第一个元素
        //1.先把front对应的值保存到一个临时变量
        //2.将front后移
        //3.将临时变量返回
        int val = arr[front];
        front = (front+1)%maxSize;
        return val;
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        //从front开始遍历
        for(int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d",i%maxSize,arr[i%maxSize]);
        }

    }

    //显示队列的头数据，不是取数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

    //求出当前有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}
