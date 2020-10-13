package com.example.search;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/22 10:46
 * 斐波那契（黄金分割法）查找算法
 * 要求有序
 * F(k) = F(k-1)+F(k-2)
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int arr[] = {1,8, 10, 89, 1000, 1234};
        System.out.println("原始数组:"+Arrays.toString(arr));
        System.out.println("index="+fibSearch(arr,1000));
    }

    //mid=left+fib(k-1)-1，使用到斐波那契数列，因此构建一个斐波那契数列，k代表斐波那契数列的第k个元素
    public static int[] fib(){
        int[] fibArray = new int[maxSize];
        fibArray[0] = 1;
        fibArray[1] = 1;

        for(int i=2;i<maxSize;i++){
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }

        return fibArray;
    }

    /**
     * 编写斐波那契查找算法（非递归）
     * @param arr 原始数组
     * @param key 我们需要查找的关键码
     * @return 返回对应的下标，如果没有返回-1
     */
    public static int fibSearch(int[] arr,int key){
        //数组的最小下标
        int low = 0;
        //数组的最大下标
        int high = arr.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放中间值
        int f[] = fib();

        //寻找关键码k
        while(arr.length>f[k]){
            k ++;
        }

        //因为f[k]可能大于原始数组的长度，因此我们需要构造一个新的数组
        //arr数组中不足的部分，会使用0填充
        int[] temp = Arrays.copyOf(arr,f[k] - 1);

        //使用原始数组的最后一个元素，填充新数组末尾为0的元素
        for(int i = high+1;i<temp.length;i++){
            temp[i] = arr[high];
        }

        //循环处理，找到我们的key
        while(low <= high){
            mid=low+f[k-1]-1;

            if(key < temp[mid]){//我们应该继续向数组的左边查找
                high = mid - 1;
                //1.全部元素 = 前面元素 + 后面的元素
                //2.f[k] = f[k-1] + f[k-2]，可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                k--;
            }else if(key> temp[mid]){//右边继续寻找
                low = mid + 1;
                //2.f[k] = f[k-1] + f[k-2]，可以继续拆分 f[k-1] = f[k-2](左) + f[k-3]（右）
                k -= 2;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
