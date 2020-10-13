package com.example.algorithm.binarySearchNoCursion;

/**
 * @author YangLiuQing
 * @date 2020/5/27 16:07
 * 二分查找，非递归算法
 */
public class BinarySearchNoRecursion {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        int index = binarySearch(arr, target);
        if(index != -1){//找到
            System.out.println(target+"在数组中的位置为"+index);
        }else{
            System.out.println("在数组中，没有找到"+target);
        }
    }

    /**
     * 非递归实现二分查找
     * @param arr 带查找的数组
     * @param target 需要查找的数
     * @return 返回对应的下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right)/2;
        while(left <= right){//可以继续查找
            if(target < arr[mid]){//向左查找
                right = mid - 1;
                mid = (left + right)/2;
            }else if(target > arr[mid]){//向右查找
                left = mid + 1;
                mid = (left + right)/2;
            }else{//直接返回
                return mid;
            }
        }
        //退出while循环时，说明没有找到
        return -1;
    }
}
