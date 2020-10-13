package com.example.sort;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/21 10:52
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        //归并排序需要额外空间（中转数组）
        int temp[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);

        System.out.println("归并排序后"+ Arrays.toString(arr));

//        int[] arr = new int[800000];
//        int[] temp = new int[arr.length];
//        for(int i=0;i<arr.length;i++){
//            arr[i] = (int) (Math.random()*80000000);//随机产生(0-8000000)
//        }
//
//        //测试归并排序耗时:1s
//        long begin = System.currentTimeMillis();
//        mergeSort(arr,0,arr.length-1,temp);
//        long end = System.currentTimeMillis();
//        long time = (end - begin)/1000;
//        System.out.println("归并排序耗时"+time+"秒");
    }

    /**
     * 合并的方法
     * @param arr  待排序的原始数组
     * @param left 最左边的索引
     * @param mid 中间索引
     * @param right 最右边的索引
     * @param temp 中转数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        //System.out.println("xxxxxxxxxxxxx");
        int i = left;//左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边序序列的初始索引
        int k = 0;//指向temp数组的当前索引

        //1.左右两边的数据（有序），按照规则填充到temp数组，直到左右两边有序序列有一边处理完毕为止
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;//最左索引右移
                k++;//中转数组的索引+1为下次存储做准备
            }else{
                temp[k] = arr[j];
                j++;//最右索引左移
                k++;
            }
        }
        //2.把有剩余数据的一边的数据依次全部填充到temp数组
        while(i<=mid){//左边的数据有剩余，全部填充到temp
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j<=right){//右边的数据有剩余，全部填充到temp
            temp[k] = arr[j];
            k++;
            j++;
        }
        //3.将temp数组的元素拷贝到array，并不是每次都拷贝所有的
        k = 0;
        int tempLeft = left;
        //System.out.println("tempLeft="+tempLeft+",right="+right);
        while(tempLeft<=right){//第一次合并:01,23,03,最后一次:07
            arr[tempLeft] = temp[k];
            k++;
            tempLeft++;
        }
    }

    /**
     * 分解的方法
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;//中间的索引
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            //此时分解完成，开始合并
            merge(arr,left,mid,right,temp);
        }
    }
}
