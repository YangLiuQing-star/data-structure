package com.example.sort;


import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/21 15:37
 * 冒泡，选择，插入:O(n^2)
 * 希尔，归并，快排，堆排序:O(nlgn)
 * 基数排序:O(n*k)
 * 基数排序
 * 时间复杂度O(n*k)，n:数据的规模，k:桶的数量
 * 稳定排序法
 * 数据量太大，会造成OutOfMemoryError错误
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[8000000];
//        for(int i=0;i<arr.length;i++){
//            arr[i] = (int) (Math.random()*800000000);//随机产生(0-8000000)
//        }
//
//        //测试基数排序耗时:1s
//        long begin = System.currentTimeMillis();
//        radixSort(arr);
//        long end = System.currentTimeMillis();
//        long time = (end - begin)/1000;
//        System.out.println("基数排序耗时"+time+"秒");
    }

    public static void radixSort(int[] arr){
        //定义一个二维数组，包含10个一维数组，每个桶就是1个一维数组
        //基数排序是空间换时间的经典算法
        int bucket[][] = new int[10][arr.length];

        //为了记录每个桶中，实际存放多少个数据，定义一个一维数组来记录各个桶每次放入数据的个数
        //bucketElementCounts[0] = 第0个桶的放入数据的个数
        int[] bucketElementCounts = new int[10];
        //数组中最大数的位数
        int max = arr[0];//假设第一个数最大

        //求出数组中的最大数
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        //根据数组中的最大数，得出最大数是几位数
        int maxLength = (max+"").length();

        for(int i = 0,n = 1; i < maxLength; i++,n *= 10){
            for(int j=0;j<arr.length;j++){
            int digitOfElement = arr[j] /n % 10;
            //在digitOfElement桶中，桶中放入的数据+1，放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }



        //按照桶的顺序（从每个一维数组的下标依次取出数据，放入原来的数组）
        int index = 0;
        //遍历每一个桶，并将桶中的数据放入原数组
        for(int k=0;k<bucket.length;k++){
            //如果桶中有数据，我们才放入原数组
            if(bucketElementCounts[k] != 0){//k桶有数据，循环第k个桶，即第k个一维数组
                for(int l=0;l<bucketElementCounts[k];l++){
                    //将数据放入原数组
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //每轮处理后，需要将每个桶中元素的数量清零
            bucketElementCounts[k] = 0;
            }
            //System.out.println("第"+(i+1)+"轮排序处理arr"+Arrays.toString(arr));
        }

//        //第1轮，对每个元素的个位进行排序处理
//        for(int j=0;j<arr.length;j++){
//            int digitOfElement = arr[j] /1 % 10;//取出个位
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照桶的顺序（从每个一维数组的下标依次取出数据，放入原来的数组）
//        int index = 0;
//        //遍历每一个桶，并将桶中的数据放入原数组
//        for(int k=0;k<bucket.length;k++){
//            //如果桶中有数据，我们才放入原数组
//            if(bucketElementCounts[k] != 0){//k桶有数据，循环第k个桶，即第k个一维数组
//                for(int l=0;l<bucketElementCounts[k];l++){
//                    //将数据放入原数组
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            //第1轮处理后，需要将每个桶中元素的数量清零
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第1轮，对个位数排序处理arr:"+ Arrays.toString(arr));
//
//        //第2轮，对每个元素的十位进行排序处理
//        for(int j=0;j<arr.length;j++){
//            int digitOfElement = arr[j] /10 % 10;//取出十位
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照桶的顺序（从每个一维数组的下标依次取出数据，放入原来的数组）
//        index = 0;
//        //遍历每一个桶，并将桶中的数据放入原数组
//        for(int k=0;k<bucket.length;k++){
//            //如果桶中有数据，我们才放入原数组
//            if(bucketElementCounts[k] != 0){//k桶有数据，循环第k个桶，即第k个一维数组
//                for(int l=0;l<bucketElementCounts[k];l++){
//                    //将数据放入原数组
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第2轮，对十位数排序处理arr:"+ Arrays.toString(arr));
//
//        //第3轮，对每个元素的个位进行排序处理
//        for(int j=0;j<arr.length;j++){
//            int digitOfElement = arr[j] / 100 %10;//取出百位
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        //按照桶的顺序（从每个一维数组的下标依次取出数据，放入原来的数组）
//        index = 0;
//        //遍历每一个桶，并将桶中的数据放入原数组
//        for(int k=0;k<bucket.length;k++){
//            //如果桶中有数据，我们才放入原数组
//            if(bucketElementCounts[k] != 0){//k桶有数据，循环第k个桶，即第k个一维数组
//                for(int l=0;l<bucketElementCounts[k];l++){
//                    //将数据放入原数组
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//        }
//        System.out.println("第3轮，对百位数排序处理arr:"+ Arrays.toString(arr));
    }
}
