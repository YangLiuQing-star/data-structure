package com.example.algorithm.floyd;

/**
 * @author YangLiuQing
 * @date 2020/5/29 19:23
 * 图
 */
public class Graph {

    //存放顶点的数组
    private char[] vertex;
    //保存从各个顶点出发，到其它顶点的距离，最后的结果也是保留在此数组（距离表）
    private int[][] dis;
    //保存到达目标顶点的前驱顶点（前驱关系表）
    private int[][] pre;


    /**
     * 构造器，初始化成员变量
     * @param size  顶点的数量
     * @param vertex 顶点的集合
     * @param matrix 邻接矩阵
     */
    public Graph(int size,char[] vertex,int[][] matrix){
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[size][size];
        //初始化pre，存放的是前驱结点的下标
        for(int i = 0;i < size;i++){
            for(int j = 0;j < size;j++){
                pre[i][j] = i;
            }
        }
    }

    /**
     * 输出dis，pre数组
     */
    public void printArrays(){
        char[] vertex = {'A','B','C','D','E','F','G'};
        //输出距离表
        for (int k = 0;k < dis.length;k++){
            //输出dis
            for (int i = 0;i < dis[k].length;i++){
                System.out.printf("<%c,%c>=%d ",vertex[k],vertex[i],dis[k][i]);
            }

            System.out.println();

            //输出pre
            for (int j = 0;j < pre[k].length;j++){
                System.out.print(vertex[pre[k][j]]+" ");
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * 弗洛伊德算法
     */
    public void floyd(){
        int len = 0;//临时变量，用于保存距离
        for(int k = 0;k < dis.length;k++){//中间顶点
            for(int i = 0;i < dis.length;i++){//出发顶点
                for(int j = 0;j < dis.length;j++){//终点
                    len = dis[i][k] + dis[k][j];//ij = ik + kj
                    //如果借助中间顶点从i到j的距离，小于直连的距离，更新ij之间的距离，更新顶点j的前驱为i
                    if(len < dis[i][j]){
                        //更新最短距离
                        dis[i][j] = len;
                        //更新前驱顶点为中间顶点
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
