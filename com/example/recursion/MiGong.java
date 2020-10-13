package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangLiuQing
 * @date 2020/5/18 15:47
 * 递归
 */
public class MiGong {

    List ls = new ArrayList();//用来保存每种策略的路径长度

    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫(地图)
        int[][] map = new int[8][7];
        //使用1代表墙
        for(int i=0;i<7;i++){//上下置为1
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for(int i=0;i<8;i++){//左右置为1
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        //map[1][2] = 1;
        //map[2][2] = 1;进行了回溯

        System.out.println("原始地图");
        //输出地图
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.printf("%d ",map[i][j]);
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map,1,1);

        System.out.println("小球走过的地图");

        //输出小球走过，并标识过的新地图
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.printf("%d ",map[i][j]);
            }
            System.out.println();
        }

        //计算走出迷宫的最短路径
        // 定义一个数组来保存回溯的策略，遍历数组，对数组中的每种策略进行回溯，然后统计2的个数加入List中，然后找出List中最小的元素（即最短路径）
    }


    /**
     * 使用递归回溯来给小球找路
     * 如果小球能到达map[6][5]，则说明通路找到
     * 约定:当map[i][j]为0,，表示该点没有走过，1，表示墙，2表示路可以走，3表示该点已经走过了，但是走不通
     * 在走迷宫时，需要确定一个策略（策略与路径长度密切相关），下--->右--->上--->左，如果走不通，再回溯
     * @param map 表示地图
     * @param i 从地图的哪个位置开始出发的行号
     * @param j 从地图的哪个位置开始出发的列号
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){//到达终点，小球找到路
            return true;
        }else{
            if(map[i][j] == 0){//如果当前这个点还没有走过
                //假定该点可以走通
                map[i][j] = 2;
                //按策略走
                if(setWay(map,i+1,j)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map,i-1,j)){//向上走
                    return true;
                }else if(setWay(map,i,j-1)){//向左走，能走通
                    return true;
                }else{//说明该点走不通，是死路，递归结束的条件
                    map[i][j] = 3;
                    return false;
                }
            }else{//如果map[i][j] != 0，可能是1：墙,2：走过 3：走过，但是走不通     1,2,3--->没有找到路
                return false;
            }
        }
    }


    //修改找路的策略，改成:上--->右--->下--->左
    public static boolean setWay2(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j]==0){//如果当前这个点还没有走过
                //按策略走
                map[i][j] = 2;//假定该点可以走通
                if(setWay2(map,i-1,j)){//向上走
                    return true;
                }else if(setWay2(map,i,j+1)){//向右走
                    return true;
                }else if(setWay2(map,i+1,j)){//向下走
                    return true;
                }else if(setWay2(map,i,j-1)){//向左走
                    return true;
                }else{//说明该点走不通，是思路
                    map[i][j] = 3;
                    return false;
                }
            }else{//如果map[i][j] != 0，可能是1,2,3
                return false;
            }
        }
    }

    //求迷宫问题的最小路径

    /**
     * 将各种走迷宫的策略保存到数组
     * 对数组中每种策略进行求解，统计2的数量（即为路径长度）
     * @param map
     * @param i
     * @param j
     * @param s 策略
     * @return
     */
    public boolean calMinPath(int[][] map,int i,int j,String s){
        return true;
    }


}
