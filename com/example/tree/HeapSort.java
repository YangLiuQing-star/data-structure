package com.example.tree;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/24 19:58
 * 堆排序
 * 时间复杂度
 * O(nlgn)
 * 升序使用大顶堆
 * 降序使用小顶堆
 */
public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {4,1,3,7,6,8,5,9,2};
        System.out.println("堆排序前:");
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println("堆排序后:");
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[80000];
//        for(int i=0;i<arr.length;i++){
//            arr[i] = (int) (Math.random()*8000000);//随机产生(0-8000000)
//        }
//
//        //测试堆排序耗时:12s
//        long begin = System.currentTimeMillis();
//        heapSort(arr);
//        long end = System.currentTimeMillis();
//        long time = (end - begin)/1000;
//        System.out.println("堆排序耗时"+time+"秒");
    }

    /**
     * 堆排序
     * 叶子结点的计算公式:arr.length/2-1
     * @param arr
     */
    public static void heapSort(int[] arr){//从后往前找出所有的非叶子结点
        int temp = 0;

        for(int i = 0;i < arr.length -1 ;i++){
            for(int j = (arr.length-i)/2-1;j >= 0;j--){
                adjustHeap(arr,j,arr.length-i);
            }
            //此时一个大顶堆构建完成，最大值和数组的最后一个元素进行交换
            temp = arr[0];
            arr[0] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }

//        for(int i = arr.length/2-1;i >= 0;i--){
//            adjustHeap(arr,i,arr.length);
//        }
//
//        for(int i = (arr.length-1)/2-1;i >= 0;i--){
//            adjustHeap(arr,i,arr.length-1);
//        }
//
//        for(int i = (arr.length-1-1)/2-1;i >= 0;i--){
//            adjustHeap(arr,i,arr.length-1-1);
//        }
//
//        for(int i = (arr.length-1-1-1)/2-1;i >= 0;i--){
//            adjustHeap(arr,i,arr.length-1-1-1);
//        }
    }


    /**
     * 功能:实现把二叉树中非叶子结点调整成一个大顶堆
     * @param arr 待调整的数组
     * @param i 非叶子结点在数组中的索引
     * @param len 对多少个元素进行调整，len在逐渐减少
     * @return
     */
    public static void adjustHeap(int arr[],int i,int len){
        //先取出非叶子结点在当前数组中对应的值，保存在临时变量中
        int temp = arr[i];
        //调整:非叶子结点:i，左子结点:k = i * 2 + 1，
        for(int k = i * 2 + 1;k < len;k = k * 2 + 1){
            if(k + 1 < len && arr[k] < arr[k+1]){//当前非叶子结点的左子结点的值小于右子结点的值
                k++;//此时k指向右子结点
            }

            if(temp < arr[k]){//如果右子结点的值大于父结点的值，交换
                arr[i] = arr[k];//把较大的值赋值给当前非叶子结点
                i = k;//i指向k，继续循环比较
            }else{
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父结点的最大值放在了最顶上（局部构建大顶堆完成）
        arr[i] = temp;//将temp的值放在最后
    }
}
