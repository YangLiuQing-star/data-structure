package com.example.search;

/**
 * @author YangLiuQing
 * @date 2020/5/21 20:05
 * 线性查找
 * 思想：遍历整个数组，找到返回下标
 */
public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = {-2,34,89,1,9,11,-1};
        int index = seqSearch(arr, -11);

        if(index==-1){
            System.out.println("没有找到");
        }else{
            System.out.println("找到了，下标为"+index);
        }

    }

    /**
     * 线性查找
     * 找到一个满足条件的值，并返回该值的下标
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int arr[],int value){
        for(int i=0;i<arr.length;i++){
            if(value == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
