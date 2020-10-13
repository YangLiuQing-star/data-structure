package com.example.sort;

/**
 * @author YangLiuQing
 * @date 2020/5/19 16:41
 * 选择排序
 * 时间复杂度O(n^2)
 * 选择排序总共有n-1轮排序
 * 每一轮排序又是一个循环，循环规则
 * 假定当前这个数是最小的数，
 * 然后和后面的每个数依次比较，
 * 如果发现有比当前数更小的数，就重新确定最小的数，并得到下标，
 * 当遍历到数组的最后时，就得到本轮最小数和下标，
 *
 * 第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 * 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…, 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，
 * 总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 */
public class SelectSort {

    public static void main(String[] args) {
        //int[] arr = {101,34,119,1,-1,123};
        int[] arr = new int[80000];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*8000000);//随机产生(0-8000000)
        }

        //测试选择排序耗时:2s
        //System.out.println("排序前:");
        //System.out.println(Arrays.toString(arr));
        long begin = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        //System.out.println("排序后:");
        //System.out.println(Arrays.toString(arr));
        long time = (end - begin)/1000;
        System.out.println("选择排序耗时"+time+"秒");
    }

    //选择排序，从小到大
    public static void selectSort(int[] arr){
        //使用逐步推导的方式来选择排序，先简单再复杂
        // 可以将一个复杂的算法，拆分成简单的问题==》逐步解决，综合起来，得到最终答案
        //在推导过程中，我们发现了规律，因此我们使用for循环来解决

        int minIndex;
        int min;

        for(int i=0;i<arr.length-1;i++){
            minIndex = i;
            min = arr[minIndex];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            //进行交换
            if(minIndex!=i){//如果minIndex == i，说明没有进行交换，即i已经是在适当的位置了
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
/*
        //第1轮
        for(int j=0+1;j<arr.length;j++){
            if(min>arr[j]){
                min = arr[j];//重置最小值
                minIndex = j;//重置最小值的索引
            }
        }

        //将最小值与arr[0]进行交换
        if(minIndex!=0){
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        System.out.println("第1轮后:");
        System.out.println(Arrays.toString(arr));

       minIndex = 0+1;
        min = arr[minIndex];
        //第2轮
        for(int j=0+1+1;j<arr.length;j++){
            if(min>arr[j]){
                min = arr[j];//重置最小值
                minIndex = j;//重置最小值的索引
            }
        }

        //将最小值与arr[0]进行交换
        if(minIndex!=1){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }


        System.out.println("第2轮后:");
        System.out.println(Arrays.toString(arr));

        minIndex = 0+1+2;
        min = arr[minIndex];
        //第2轮
        for(int j=0+1+2;j<arr.length;j++){
            if(min>arr[j]){
                min = arr[j];//重置最小值
                minIndex = j;//重置最小值的索引
            }
        }

        //将最小值与arr[0]进行交换
        if(minIndex!=2){
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第3轮后:");
        System.out.println(Arrays.toString(arr));*/
    }
}
