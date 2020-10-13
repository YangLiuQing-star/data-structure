package com.example.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author YangLiuQing
 * @date 2020/5/19 15:36
 *冒泡排序
 *通过对待排序序列从前向后（从下标较小的元素开始）,依次比较
 *相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向最后，就象水底下的气泡一样逐渐向上冒
 *时间复杂度O(n^2)
 *优化：在一趟排序中，一次交换都没有发生，证明排序完成，没必要继续下去
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,20};

        System.out.println("排序前的数组:");
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[80000];
//        for(int i=0;i<arr.length;i++){
//            arr[i] = (int) (Math.random()*8000000);//随机产生(0-8000000)
//        }
//
//        //测试冒泡排序耗时:12s
//        long begin = System.currentTimeMillis();
//        bubbleSort(arr);
//        long end = System.currentTimeMillis();
//        long time = (end - begin)/1000;
//        System.out.println("冒泡排序耗时"+time+"秒");

        System.out.println("排序后的数组:");
        System.out.println(Arrays.toString(arr));


        for(int j=0;j<arr.length-1-0;j++){
            int temp = 0;//临时变量
            if(arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }


/*        //第二趟排序，是将第二大的数排在倒数第二位
        for(int j=0;j<arr.length-1-1;j++){
            int temp = 0;//临时变量
            if(arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组:");
        System.out.println(Arrays.toString(arr));

        //第三趟排序，是将第3大的数排在倒数第3位
        for(int j=0;j<arr.length-1-2;j++){
            int temp = 0;//临时变量
            if(arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组:");
        System.out.println(Arrays.toString(arr));

        //第四趟排序，是将第4大最大的数排在倒数第4位
        for(int j=0;j<arr.length-1-3;j++){
            int temp = 0;//临时变量
            if(arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组:");
        System.out.println(Arrays.toString(arr));

        */
    }

    //将前面的冒泡排序封装成一个函数
    public static void bubbleSort(int[] arr){

        int temp = 0;//临时变量

        boolean flag;//用来标识每趟排序是否进行过交换

        //第一趟排序，是将最大的数排在最后
        for(int i=0;i<arr.length-1;i++){
            flag = false;//重置flag，进行下次判断
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag = true;//进行过交换
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
//            System.out.printf("第%d趟排序后的数组:\n",i+1);
//            System.out.println(Arrays.toString(arr));
            //优化
            if(flag==false){//在一趟排序中，一次交换都没有发生，说明已经有序，直接退出循环
                break;
            }
        }
    }

}
