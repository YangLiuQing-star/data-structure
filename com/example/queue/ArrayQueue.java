package com.example.queue;

/**
 * 使用数组模拟队列
 * 先进先出
 * 存在的问题说明:数据取出后，只是修改了数组并没有在数组中删除该数据，导致数组的空间不能重复利用
 */
public class ArrayQueue {

    private int maxSize;//队列的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列尾的具体数据（即队列的最后一个数据）
    }

    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize-1;
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
        rear++;
        arr[rear] = n;
    }

    //出队列
    public int getQueue(){
        if(isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列为空，无法取数据");
        }

        front++;//front后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，不是取数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front+1];
    }
}
