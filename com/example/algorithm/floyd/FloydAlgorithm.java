package com.example.algorithm.floyd;

/**
 * @author YangLiuQing
 * @date 2020/5/29 18:38
 * 弗洛伊德算法
 * 计算各个顶点之间的最短路径
 */
public class FloydAlgorithm {

    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        final int N = 65535;
        int[][] matrix= new int[][]{//10000:表示两个顶点不连通
                {0,5,7,N,N,N,2},
                {5,0,N,9,N,N,3},
                {7,N,0,N,8,N,N},
                {N,9,N,0,N,4,N},
                {N,N,8,N,0,5,4},
                {N,N,N,4,5,0,6},
                {2,3,N,N,4,6,0}
        };
        //创建图对象
        Graph graph = new Graph(vertex.length,vertex,matrix);
        graph.printArrays();
        System.out.println("------------------------------------------------------------");
        graph.floyd();
        graph.printArrays();
    }
}
