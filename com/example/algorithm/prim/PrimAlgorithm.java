package com.example.algorithm.prim;

/**
 * @author YangLiuQing
 * @date 2020/5/28 21:37
 * 普利姆算法
 * 解决最短路径问题
 */
public class PrimAlgorithm {

    public static void main(String[] args) {
        System.out.println("输出图初始化的结果");
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int vertexes = data.length;
        //边之间的关系，使用二维数组表示
        int [][]weight=new int[][]{//10000:表示两个顶点不连通
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建图对象
        MGraph graph = new MGraph(vertexes);
        //创建MinTree对象
        MinTree minTree = new MinTree();
        //使用MGraph对象创建图
        minTree.createGraph(graph,vertexes,data,weight);
        //打印图
        minTree.printGraph(graph);
        //测试普利姆算法
        minTree.prim(graph,0);
        System.out.println("最短路径长度为:"+minTree.minPath);
    }
}
