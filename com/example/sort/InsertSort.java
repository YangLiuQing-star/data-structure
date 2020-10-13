package com.example.sort;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/19 20:45
 * 插入排序
 * 当插入较小的数时，比较的次数明显增多，效率降低
 * 时间复杂度O(n^2) :(n-1)
 * 在最坏情况下，数组完全逆序，插入第2个元素时要考察前1个元素，插入第3个元素时，要考虑前2个元素，……，插入第N个元素，要考虑前 N - 1 个元素。因此，最坏情况下的比较次数是 1 + 2 + 3 + ... + (N - 1)，等差数列求和，结果为 N^2 / 2，所以最坏情况下的复杂度为 O(N^2)。
 * 最好情况下，数组已经是有序的，每插入一个元素，只需要考查前一个元素，因此最好情况下，插入排序的时间复杂度为O(N)
 * 把n个待排序的元素看成为一个有序表和一个无序表，
 * 开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，
 * 将它插入到有序表中的适当位置，使之成为新的有序表。
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        System.out.println("排序前的数组:");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后的数组:");
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[80000];
//        for(int i=0;i<arr.length;i++){
//            arr[i] = (int) (Math.random()*8000000);//随机产生(0-8000000)
//        }
//
//        //测试插入排序耗时:0-1s
//        long begin = System.currentTimeMillis();
//        insertSort(arr);
//        long end = System.currentTimeMillis();
//        long time = (end - begin)/1000;
//        System.out.println("插入排序耗时"+time+"秒");
    }

    /**
     * 插入排序(从小到大)
     * （从大到小）
     * @param arr 要排序的数组
     */
    public static void insertSort(int[] arr){
        int insertVal;//待插入的值
        int insertIndex;//插入的值的前面一个数的下标
        for(int i=1;i<arr.length;i++){
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex>=0 && insertVal < arr[insertIndex]){//待插入的值小于前一个数的值，前一个数后移
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //退出循环时，待插入的数的位置，位于insertIndex+1
            if(insertIndex+1 != i){//如果等于i，则说明没有进入while循环[优化]
                arr[insertIndex+1] = insertVal;
            }
        }
     /*   //逐步推导
        //原始:{101,34,119,1};

        //第1轮:{34,101,119,1};
        int insertVal = arr[1];
        int insertIndex = 1-1;//即arr[1]前面这个数的下标

        //给insertVal找到插入的位置
        //1.在给insertVal找位置时，保证数组不能越界
        //2.当前insertVal还没有找到插入的位置
        //3.需要将arr[insertIndex]后移
        while(insertIndex>=0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];//后移
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，位于insertIndex + 1
        arr[insertIndex+1] = insertVal;
        System.out.println("第1轮插入后:");
        System.out.println(Arrays.toString(arr));

        //第2轮:{34,101,119,1};
        insertVal = arr[2];
        insertIndex = 2-1;//即arr[2]前面这个数的下标

        //给insertVal找到插入的位置
        //1.在给insertVal找位置时，保证数组不能越界
        //2.当前insertVal还没有找到插入的位置
        //3.需要将arr[insertIndex]后移
        while(insertIndex>=0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];//后移
            insertIndex--;//继续往前找位置
        }
        //当退出while循环时，说明插入的位置找到，位于insertIndex + 1
        arr[insertIndex+1] = insertVal;
        System.out.println("第2轮插入后:");
        System.out.println(Arrays.toString(arr));

        //第3轮:{34,101,119,1};
        insertVal = arr[3];
        insertIndex = 3-1;//即arr[2]前面这个数的下标

        //给insertVal找到插入的位置
        //1.在给insertVal找位置时，保证数组不能越界
        //2.当前insertVal还没有找到插入的位置
        //3.需要将arr[insertIndex]后移
        while(insertIndex>=0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];//后移
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，位于insertIndex + 1
        arr[insertIndex+1] = insertVal;
        System.out.println("第3轮插入后:");
        System.out.println(Arrays.toString(arr));*/
    }

}
