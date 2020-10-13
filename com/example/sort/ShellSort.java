package com.example.sort;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/20 7:35
 * 希尔排序
 * 时间复杂度O()
 * 希尔排序是把记录按下标的一定增量分组，
 * 对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，
 * 当增量减至1时，整个文件恰被分成一组，算法便终止
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前:"+Arrays.toString(arr));
        shellSort2(arr);
        System.out.println("排序后:"+Arrays.toString(arr));

//        int[] arr = new int[80000];
//        for(int i=0;i<arr.length;i++){
//            arr[i] = (int) (Math.random()*8000000);//随机产生(0-8000000)
//        }
//
//        //测试交换式希尔排序耗时:7s，移位式希尔排序1:
//        long begin = System.currentTimeMillis();
//        shellSort2(arr);
//        long end = System.currentTimeMillis();
//        long time = (end - begin)/1000;
//        System.out.println("希尔排序耗时"+time+"秒");
    }

    /**
     * 从小到大
     * 使用逐步推导的方式编写希尔排序[交换法]
     * @param arr 待排序的数组
     */
    public static void shellSort(int[] arr){
        int temp;
        for(int step=arr.length/2;step>0;step/=2){//步长
            for(int i=step;i<arr.length;i++){//
                //遍历各组中所有的元素，对每组中的元素进行排序
                for(int j=i-step;j>=0;j-=step){
                    //如果当前元素大于加上步长的那个元素，则交换
                    if(arr[j]>arr[j+step]){
                        temp = arr[j];
                        arr[j] = arr[j+step];
                        arr[j+step] = temp;
                    }
                }
            }
        }

/*        int temp;
        //希尔排序的第1轮排序，分成10/2=5组
        for(int i=5;i<arr.length;i++){
            //遍历各组中所有的元素，每组2个元素，步长5
            for(int j=i-5;j>=0;j-=5){
                //如果当前元素大于加上步长的那个元素，则交换
                if(arr[i]>arr[j+5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("希尔排序的第1轮后:"+ Arrays.toString(arr));

        //希尔排序的第2轮排序，分成5/2=2组
        for(int i=2;i<arr.length;i++){
            //遍历各组中所有的元素，每组5个元素，步长2
            for(int j=i-2;j>=0;j-=2){
                //如果当前元素大于加上步长的那个元素，则交换
                if(arr[j]>arr[i]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("希尔排序的第2轮后:"+ Arrays.toString(arr));

        //希尔排序的第3轮排序，分成2/2=1组
        for(int i=1;i<arr.length;i++){
            //遍历各组中所有的元素，每组10个元素，步长1
            for(int j=i-1;j>=0;j-=1){
                //如果当前元素大于加上步长的那个元素，则交换
                if(arr[j]>arr[i]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("希尔排序的第3轮后:"+ Arrays.toString(arr));*/
    }

    //对交换式的希尔排序进行优化--->移位法
    public static void shellSort2(int[] arr){

        for(int gap = arr.length/2;gap>0;gap /= 2){
            for(int i=gap;i<arr.length;i++){
                int insertIndex = i;//待插入值的下标
                int insertVal = arr[insertIndex];//待插入的值
                if(arr[insertIndex]<arr[insertIndex-gap]){
                    while(insertIndex-gap>=0 && insertVal<arr[insertIndex-gap]){
                        //向后移动
                        arr[insertIndex] = arr[insertIndex-gap];
                        insertIndex -= gap;
                    }
                    //当退出while循环后，insertVal就找到了位置
                    arr[insertIndex] = insertVal;
                }
            }
        }
    }
}
