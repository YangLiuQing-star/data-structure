package com.example.search;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/22 8:13
 * 差值查找算法，也要求数组有序
 * 适用于数据量大，数据分布均匀，查找速度较快
 */
public class InsertValueSearch {

    public static void main(String[] args) {

        int arr[] = new int[100];
        for(int i=0;i<arr.length;i++){
            arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr));
        int index = insertValueSearch(arr, 0, arr.length - 1, 89);
        if(index!=-1){
            System.out.println("找到了，下标为"+index);
        }else{
            System.out.println("没有找到");
        }
    }

    /**
     * 差值查找
     * mid自适应
     * mid = left + (right - left)*(findVal - arr[left])/(arr[right]-arr[left])
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int insertValueSearch(int arr[], int left, int right, int findVal){
        System.out.println("查找次数");
        //注意:findVal<arr[0] || findVal > arr[arr.length-1]必须需要，否则我们得到的mid可能越界
        if(left>right || findVal<arr[0] || findVal > arr[arr.length-1]){
            return -1;
        }

        int mid = left + (right - left)*(findVal - arr[left])/(arr[right]-arr[left]);
        //当要查找的值远远大于数组的最大值或者远远小于数组的最小值，mid将会越界
        int midVal = arr[mid];

        if(findVal<midVal){
            return insertValueSearch(arr,0,mid-1,findVal);
        }else if(findVal>midVal){
            return insertValueSearch(arr,mid+1,right,findVal);
        }else{
            return mid;
        }
    }
}
