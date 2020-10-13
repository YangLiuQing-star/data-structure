package com.example.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangLiuQing
 * @date 2020/5/21 20:19
 * 二分查找（折半查找）
 * 使用二分查找的前提是该数组是有序的
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,9,9};
        //int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

//        int res = binarySearch(arr, 0, arr.length-1, 2);
//        if(res!=-1){
//            System.out.println("找到了，下标为"+res);
//        }else{
//            System.out.println("没有找到");
//        }

        List ls = binarySearch2(arr,0,arr.length-1,9);
        System.out.println("找到了，索引如下:"+ ls);
    }

    /**
     * 二分查找
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return 如果找到，则返回下标，如果没有找到，则返回-1
     */
    public static int binarySearch(int arr[],int left,int right,int findVal){
        System.out.println("二分查找");
        //数组中间的索引
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(left>right){
            return -1;
        }

        if(findVal<midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else if(findVal>midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else{
            return mid;
        }
    }

    /**
     * 改进，找到后不要返回，先将它保存在集合中，然后向mid的左右两边继续进行扫描，如果扫描到，将索引加入到集合中
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List binarySearch2(int arr[],int left,int right,int findVal){
        System.out.println("***hello***");
        List<Integer> ls = new ArrayList();
        //数组中间的索引
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        //说明没有找到
        if(left>right){
            return  ls;
        }

        if(findVal<midVal){
             return binarySearch2(arr,left,mid-1,findVal);
        }else if(findVal>midVal){
             return binarySearch2(arr,mid+1,right,findVal);
        }else{
            ls.add(mid);

            //中间数的前一个数
            int temp = mid - 1;

            while(true){//向mid的左边一个个的查找
                if(temp<0 || arr[temp]!=findVal){//说明没有找到
                    break;
                }
                ls.add(temp);
                temp --;//左移
            }

            //中间数的后一个数
            temp = mid + 1;

            while(true){//向mid的右边一个个的查找
                if(temp>arr.length-1 || arr[temp] != findVal){//说明没有找到
                    break;
                }
                ls.add(temp);
                temp ++;//右移
            }
            return ls;
        }
    }
}
