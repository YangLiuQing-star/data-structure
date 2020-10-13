package com.example.algorithm.prim;

/**
 * @author YangLiuQing
 * @date 2020/5/28 21:37
 * 此类用来描述图结构
 */
public class MGraph {
    int vertexes;//表示图顶点的个数
    char[] data;//用来保存顶点的数据
    int[][] weight;//用来存放边的邻接矩阵

    public MGraph(int vertexes){
        this.vertexes = vertexes;
        data = new char[vertexes];
        weight = new int[vertexes][vertexes];
    }

}
