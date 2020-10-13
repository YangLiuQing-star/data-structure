package com.example.algorithm.prim;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/28 21:42
 * 创建最小生成树（满足N个顶点，N-1条边）
 *
 */
public class MinTree {

    //用来累计最短路径的总和
    public int minPath = 0;

    /**
     * 创建图的邻接矩阵
     * @param graph 图对象
     * @param vertexes 顶点的数量
     * @param data 顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph,int vertexes,char[] data,int[][] weight){
        //初始化图中的属性
        for(int i = 0;i < vertexes;i++){//把顶点的值，赋值给图中data[i]
                graph.data[i] = data[i];
                for(int j = 0;j < vertexes;j++){//把邻接矩阵，赋值给图中的weight[i][j]
                    graph.weight[i][j] = weight[i][j];
                }
        }
    }

    /**
     * prim算法
     * @param graph 图对象
     * @param v 从图的第几个顶点开始生成最小生成树，例如：'A'->0，'B'->1....
     */
    public void prim(MGraph graph,int v){
        //标记顶点是否被访问过，1代表已访问，0代表未访问（默认元素的值都是0，表示没有访问过）
        int[] visited = new int[graph.vertexes];

        //把当前结点标记为已访问
        visited[v] = 1;
        //h1，h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;

        //最短的路径长度minWeight初始化为一个大数，后面在遍历的过程中，会被修改
        int minWeight = 10000;

        //n个顶点产生n-1条边
        for(int k = 1;k < graph.vertexes;k++){
            //每一个生成的子图和哪个顶点的距离最近
            for(int i = 0;i < graph.vertexes;i++){//i顶点表示被访问过的顶点
                for(int j = 0;j < graph.vertexes;j++){//j顶点表示没有被访问过的顶点
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        //更新minWeight
                        minWeight = graph.weight[i][j];
                        //记录找到的顶点
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            //退出for循环时，找到了一条边是最小的，即<h1,h2>
            System.out.println("边:<"+graph.data[h1]+","+graph.data[h2]+">,权值:"+minWeight);
            //累计路径
            minPath += minWeight;
            //将当前没有被访问过的结点标记为已访问，即j标记为已访问
            visited[h2] = 1;
            //重置minWeight为下一次寻找两个顶点之间的最短距离做准备
            minWeight = 10000;
        }
    }

    /**
     * 输出图对应的邻接矩阵
     * @param graph
     */
    public void printGraph(MGraph graph){
        for(int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
}
