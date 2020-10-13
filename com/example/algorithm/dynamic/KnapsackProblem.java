package com.example.algorithm.dynamic;

/**
 * @author YangLiuQing
 * @date 2020/5/27 21:32
 * 动态规划
 * 解决背包问题
 * 公式
 * v[i][0] = v[0][j] = 0
 * 当w[i] > j，v[i][j] = v[i-1][j]
 * 当w[i] <= j，v[i][j] = max(v[i]+v[i-1][j-w[i]],v[i-1][j])
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1,4,3};//物品的重量
        int[] val = {1500,3000,2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的个数

        //创建一个二维数组，表示前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];

        //定义一个二维数组保存放入的策略
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行，第一列为0，默认第一行，第一列为0
        for(int i = 0;i < n + 1;i++){//遍历行
            v[i][0] = 0;//将第0列置为0
        }

        for(int j = 0;j < m + 1;j++){//遍历列
            v[0][j] = 0;//将第0行置为0
        }

        //根据推导出来的公式进行动态规划处理，因为从第1行，第1列开始循环，所以公式中所有的i都需要减1
        for(int i = 1;i < v.length;i++){//不处理第1行，行循环
            for(int j = 1;j < v[i].length;j++){//不处理第1列，列循环
                if(w[i-1] > j){//如果第i件商品的重量大于背包的容量，则采用i-1件商品的放置策略
                    v[i][j] = v[i-1][j];
                }else{//j > = w[i-1]
                    //为了记录商品存放到背包的情况，我们不能直接的使用上面的公式，需要使用if,else
                    if(v[i-1][j] > val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = v[i-1][j];
                    }else{
                        v[i][j] =  val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;//标记此时放入了商品i，在容量为j的背包中
                    }
                }
            }
        }


        for(int i = 1;i < v.length;i++){
            for(int j = 1;j < v[i].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

        //输出最优的解集，最后一列从后往前找 v[3][4] + v[1][1]
        int i = path.length - 1;//行的最大下标
        int j = path[0].length - 1;//列的最大下标
        while(i > 0 && j > 0){
            if(path[i][j] == 1){
                System.out.printf("第%d个商品放入到背包 ",i);
                j -= w[i-1];
            }
            i--;
        }

    }

    /**
     * 返回两个数中的较大者
     * @param a
     * @param b
     * @return
     */
    public static int getMax(int a,int b){
        return a > b ? a : b;
    }
}
