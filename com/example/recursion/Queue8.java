package com.example.recursion;

/**
 * @author YangLiuQing
 * @date 2020/5/18 20:46
 * 八皇后问题
 */
public class Queue8 {

    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组，记录皇后摆放的位置的结果，arr[n]:n代表第n个皇后（从0--7），arr[n]：代表第n个皇后所在的位置
    int[] arr = new int[max];
    //用来统计八皇后问题有多少种解法
    static int count = 0;
    //用来统计八皇后判断冲突的次数
    static int sum = 0;



    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("八皇后问题的解法一共有"+count+"种");
        System.out.println("八皇后问题冲突判断的次数为"+sum+"次");
    }

    //写一个方法，打印皇后摆放的位置的结果
    public void print(){
        for(int i=0;i<arr.length;i++){
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
    }

    /**
     * 当放入第n个皇后时，检测该皇后是否和前面已经放置的皇后冲突
     * @param n 表示放置第n个皇后 n从0开始到max-1结束
     * @return
     */
    private boolean judge(int n){
        sum++;//冲突判断的次数加1
        for(int i=0;i<n;i++){
            //arr[i]==arr[n]:第n个皇后是否和前面第n-1个皇后在同一列
            //Math.abs(n-i)==Math.abs(arr[n]-arr[i]):表示第n个皇后是否和前面第n-1个皇后在同一斜线
            //由于从第0行开始依次放置皇后，所以不需要考虑皇后在同一行的情况
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    //编写一个方法，放置第n个皇后
    public void check(int n){
        if(n == max){//n=8，其实8个皇后已经放好
            count++;
            print();
            return;
        }

        //依次放置皇后，并判断是否冲突，循环结束时，八个皇后放置完成
        for(int i=0;i<max;i++){//放置第i个皇后
            //先把当前这个皇后n,放置在该行的第0列
            arr[n] = i;
            //判断当放置第n个皇后到第i列时是否冲突
            if(judge(n)){//不冲突
                //接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，继续执行arr[n] = i;即将第n个皇后，在本行往后移动一个位置
        }
    }

}
