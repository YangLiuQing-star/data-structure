package com.example.algorithm.kmp;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/28 12:06
 * KMP算法
 * 解决字符串匹配问题
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext(str2);//[0,1,2]   A AA AA A
        int index = kmpSearch(str1,str2, next);

        System.out.println(str2+"对应的部分匹配表:");
        System.out.println("next = "+Arrays.toString(next));
        System.out.println("index="+index);
    }

    /**
     * 获取一个子串的部分匹配表
     * @param dest 子串
     * @return 子串的部分匹配表
     */
    public static int[] kmpNext(String dest){
        //创建一个数组保存部分匹配表，代表当前字符之前的字符串中，有多大长度的相同前缀后缀
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串dest长度为1，前缀后缀相同的长度为0，即部分匹配值0

        for(int i = 1,j = 0; i < dest.length();i++){
            while(j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];//KMP核心点
            }

            if(dest.charAt(i) == dest.charAt(j)){//部分匹配值+1
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     *
     * @param str1 原字符串
     * @param str2 子串
     * @param next 子串对应的部分匹配表
     * @return 没有匹配到，返回-1，匹配成功，返回第一个匹配的位置
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        //遍历原始字符串
        for(int i = 0,j = 0;i < str1.length();i++){

            //KMP核心点
            while(j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }

            if(j == str2.length()){//匹配成功
                return i - j + 1;
            }
        }
        return -1;
    }
}
