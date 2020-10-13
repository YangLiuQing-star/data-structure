package com.example.algorithm.dijkstra;

/**
 * @author YangLiuQing
 * @date 2020/5/29 9:51
 * 迪杰斯拉特（Dijkstra）算法
 * 解决最短路径问题
 * 顶点的集合
 * dis
 */
public class DijkstraAlgorithm {

    public static final int N = 65535;

    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        int[][] matrix= new int[][]{//10000:表示两个顶点不连通
                {N,5,7,N,N,N,2},
                {5,N,N,9,N,N,3},
                {7,N,N,N,8,N,N},
                {N,9,N,N,N,4,N},
                {N,N,8,N,N,5,4},
                {N,N,N,4,5,N,6},
                {2,3,N,N,4,6,N}};
        //创建图
        Graph graph = new Graph(vertex,matrix);
        graph.printGraph();
        graph.dijkstra(0);
        //输出最后的结果
        graph.showDjs();
    }

}
