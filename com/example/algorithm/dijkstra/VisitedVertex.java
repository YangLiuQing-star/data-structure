package com.example.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/29 10:29
 * 此类封装已访问的顶点
 */
public class VisitedVertex {

    //记录各个顶点是否访问过，1表示访问过，0表示未访问
    public int[] already_arr;
    //被访问顶点的前一个顶点的下标
    public int[] pre_visited;
    //记录出发点到其它所有顶点的距离，比如G为出发点，就会记录G到其它顶点的距离，求出最短距离放入dis
    public int[] dis;


    /**
     * 构造器，完成成员变量的初始化
     * @param size 顶点的个数
     * @param index 出发顶点对应的下标
     */
    public VisitedVertex(int size,int index) {
        this.already_arr = new int[size];
        //设置出发顶点被访问过
        this.already_arr[index] = 1;
        this.pre_visited = new int[size];
        this.dis = new int[size];
        //初始化dis
        Arrays.fill(dis,65535);
        //设置出发顶点到本身的访问距离为0
        dis[index] = 0;
    }

    /**
     * 判断index下标对应的顶点是否被访问过
     * @param index index下标对应的顶点
     * @return 访问过，返回true，未访问，返回false
     */
    public boolean in(int index){
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     * @param index 要更新顶点的下标
     * @param len 更新的值
     */
    public void updateDis(int index,int len){
        dis[index] = len;
    }

    /**
     * 更新pre这个顶点的前驱顶点为index
     * @param pre 要更新的顶点
     * @param index 更新后前驱
     */
    public void updatePre(int pre,int index){
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     * @param index 下标为index的顶点
     * @return 距离
     */
    public int getDis(int index){
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问顶点
     * @return 新的访问顶点对应的下标
     */
    public int updateArr(){
        int min = 65535;
        //用来记录新的访问顶点对应的下标
        int index = 0;
        for(int i = 0;i < already_arr.length;i++){
            if(already_arr[i] == 0 && dis[i] < min){
                //更新最小值
                min = dis[i];
                index = i;
            }
        }
        //更新顶点index被访问过
        already_arr[index] = 1;
        return index;
    }

    /**
     * 输出最终3个数组的情况
     */
    public void printArrays(){
        System.out.println("已访问的顶点如下:");
        for(int item : already_arr){
            System.out.print(item+" ");
        }
        System.out.println();

        System.out.println("各个顶点的前驱顶点如下:");
        for(int item : pre_visited){
            System.out.print(item+" ");
        }
        System.out.println();

        char[] vertex = {'A','B','C','D','E','F','G'};
        int count = 0;
        System.out.println("初始顶点到各个顶点的最短距离如下:");
        for(int i : dis){
            if(i != 65535){
                System.out.print(vertex[count]+"("+i+") ");
            }else{
                System.out.print(vertex[i]+"N ");
            }
            count++;
        }
    }

}
