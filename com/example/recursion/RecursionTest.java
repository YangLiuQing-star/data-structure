package com.example.recursion;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/18 11:47
 * 递归调用机制
 * 自身调用自身
 * 八皇后，汉诺塔，阶乘问题，迷宫问题，篮子问题
 */
public class RecursionTest {

    public static void main(String[] args) {
        test(4);
        int res = factorial(6);
        System.out.printf("6!=%d",res);
    }

    public static void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }

    //阶乘问题
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
}
