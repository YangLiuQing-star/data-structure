package com.example.algorithm.divideAndConquer;

/**
 * @author YangLiuQing
 * @date 2020/5/27 18:28
 * 分治算法
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(2,'A','B','C');
    }


    /**
     * 汉诺塔移动的方法
     * 移动的步数:2^num - 1
     * @param num 盘子的数量
     * @param a 第一个盘子的名称
     * @param b 第二个盘子的名称
     * @param c 第三个盘子的名称
     */
    public static void hanoiTower(int num,char a,char b,char c){
        //1个盘，A->C
        if(num == 1){
            System.out.println("第1个盘从:"+a+"->"+c);
        }else{//2个盘以上，看成最上面所有盘，最下面的一个盘
            //第1步.最上面的盘从A --->B，移动过程会使用到C
            hanoiTower(num - 1,a,c,b);
            //第2步.最下面的盘从A --->C
            System.out.println("第"+num+"个盘从:"+a+"->"+c);
            //第3步.最后，B塔的所有盘从B--->C，移动过程会使用到A
            hanoiTower(num - 1,b,a,c);
        }
    }
}
