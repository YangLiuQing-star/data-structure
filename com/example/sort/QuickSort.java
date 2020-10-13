package com.example.sort;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/20 16:05
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[8000000];
//        for(int i=0;i<arr.length;i++){
//            arr[i] = (int) (Math.random()*80000000);//随机产生(0-8000000)
//        }
//
//        //测试快速排序耗时:2s
//        long begin = System.currentTimeMillis();
//        quickSort(arr,0,arr.length-1);
//        long end = System.currentTimeMillis();
//        long time = (end - begin)/1000;
//        System.out.println("快速排序耗时"+time+"秒");
    }

    /**
     *
     * @param arr 待排序的数组
     * @param left 左下标
     * @param right 右下标
     */
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int mid = arr[(left+right)/2];
        int temp = 0;

        while(l < r){//比mid小的，放在mid的左边，比mid大的，放在mid的右边
            //在mid的左边一直找，找到一个大于等于mid的值退出
            while(arr[l]<mid){
                l++;
            }
            //在mid的右边一直找，
            // 找到一个小于等于mid的值退出
            while(arr[r]>mid){
                r--;
            }

            //如果l >=r 时，则mid的左右两边的值，已经按照左边全都是小于等于mid的顺序排列，已经按照右边全都是大于等于mid的顺序排列
            if(l >= r){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完成后，发现这个arr[l] == mid，前移
            if(arr[l] == mid){
                r -= 1;
            }

            //如果交换完成后，发现这个arr[r] == mid，后移
            if(arr[r] == mid){
                l++;
            }
        }
            if(l==r){//否则会出现栈溢出
                l++;
                r--;
            }

            //向左递归
            if(left<r){
                quickSort(arr,left,r);
            }

            //向右递归
            if(right>l){
                quickSort(arr,l,right);
            }
    }

}
