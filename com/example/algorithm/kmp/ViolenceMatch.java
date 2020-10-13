package com.example.algorithm.kmp;

/**
 * @author YangLiuQing
 * @date 2020/5/28 10:15
 * 暴力匹配算法
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "helloworld1helloworld2helloworld3helloworld4";
        String str2 = "helloworld2";
        int res = violenceMatch(str1, str2);
        if(res != -1){
            System.out.println("匹配成功，匹配成功的开始下标为"+res);
        }else{
            System.out.println("匹配失败");
        }
    }

    /**
     * 字符串匹配
     * @param str1 原字符串
     * @param str2 子串
     * @return 匹配失败，返回-1，匹配成功，返回匹配成功的开始下标
     */
    public static int violenceMatch(String str1,String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;

        for(int i = 0,j = 0;i < len1 && j < len2;i++,j++){
            if(chars1[i] != chars2[j]){
                //原字符串从开始匹配的后一个位置开始，继续匹配
                i = i - j + 1;
                //子串从头开始匹配
                j = 0;
            }

            if(j == len2 - 1){//说明此时已经找到
                //返回查找的起始位置
                return i - j;
            }
        }
        //没有找到，返回-1
        return -1;
    }
}
