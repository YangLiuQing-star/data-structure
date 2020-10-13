package com.example.algorithm.kruskal;

/**
 * @author YangLiuQing
 * @date 2020/5/29 7:16
 * 此类表示边（由两个顶点以及两个顶点之间的权值组成）
 */
public class Edge {

    char start;//边的起点
    char end;//边的终点
    int weight;//边的权值

    //构造器
    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "<" + start +
                "," + end +
                ">=" + weight +
                '}';
    }
}
