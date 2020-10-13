package com.example.algorithm.kruskal;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/29 6:47
 * 克鲁斯卡尔算法
 * 解决最短路径问题
 * 1.边排序
 * 2.记录顶点在最小生成树中的终点，加入的边的两个顶点不能指向同一个终点，判断该边的两个顶点的终点是否重合，如果重合，则会构成回路
 */
public class KruskalAlgorithm {

    private int edgesNum;//记录边的数量（不同顶点构成的边）
    private char[] vertexes;//顶点的数组
    private int[][] matrix;//邻接矩阵，保存图结构

    //使用INF表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] matrix =  {//0表示顶点与顶点自身连通
	      /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
	/*A*/ {   0,  12, INF, INF, INF,  16,  14},
	/*B*/ {  12,   0,  10, INF, INF,   7, INF},
	/*C*/ { INF,  10,   0,   3,   5,   6, INF},
	/*D*/ { INF, INF,   3,   0,   4, INF, INF},
	/*E*/ { INF, INF,   5,   4,   0,   2,   8},
	/*F*/ {  16,   7,   6, INF,   2,   0,   9},
	/*G*/ {  14, INF, INF, INF,   8,   9,   0}};

        KruskalAlgorithm kruskal = new KruskalAlgorithm(vertexs,matrix);
        kruskal.printMatrix();
        Edge[] edges = kruskal.getEdges();
        System.out.println("边排序前:");
        System.out.println(Arrays.toString(edges));
        kruskal.sortEdge(edges);
        System.out.println("边排序后:");
        System.out.println(Arrays.toString(edges));
        System.out.println("一共有"+edges.length+"条边");
        System.out.println("最终的最小生成树:");
        kruskal.kruskal();
    }

    /**
     * 构造器，初始化顶点，边的数量，邻接矩阵（成员变量）
     * @param vertexes 顶点数组
     * @param matrix 图对应的邻接矩阵
     */
    public KruskalAlgorithm(char[] vertexes,int[][] matrix){
        this.vertexes = new char[vertexes.length];
//        this.vertexes = vertexes;
        //为了不让原始数据发生修改，使用复制拷贝的方式进行初始化
        for(int i = 0;i < vertexes.length;i++){
            this.vertexes[i] = vertexes[i];
        }

        this.matrix = new int[vertexes.length][vertexes.length];
//        this.matrix = new int[vertexes.length][vertexes.length];
        //为了不让原始数据发生修改，使用复制拷贝的方式进行初始化
        for(int i = 0;i < vertexes.length;i++){
            for(int j = 0;j < vertexes.length;j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边的数量
        for(int i = 0;i < vertexes.length;i++){//行循环
            for(int j = i + 1;j < vertexes.length;j++){//列循环
                if(this.matrix[i][j] != INF && this.matrix[i][j] != 0){
                    this.edgesNum++;
                }
            }
        }
    }

    //打印图对应的邻接矩阵
    public void printMatrix(){
        System.out.println("邻接矩阵为:");
        for(int i = 0;i < vertexes.length;i++) {
            for (int j = 0; j < vertexes.length; j++) {
                System.out.printf("%10d\t", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 对边进行排序
     * @param edges 存放边的集合
     */
    private void sortEdge(Edge[] edges){
        for(int i = 0;i < edges.length - 1;i++) {
            for (int j = 0; j < edges.length -1 -i; j++) {
                if(edges[j].weight > edges[j+1].weight){//交换
                    Edge temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    /**
     * 返回顶点对应的下标
     * @param ch 顶点
     * @return 返回顶点对应的下标，如果找不到返回-1，找到返回对应顶点的下标
     */
    private int getPosition(char ch){
        for(int i = 0;i < vertexes.length;i++){
            if(vertexes[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，创建Edge对象，并且加入到Edge[]数组中
     * @return
     */
    public Edge[] getEdges(){
        int index = 0;
        //创建存放边的数组
        Edge[] edges = new Edge[edgesNum];
        //根据邻接矩阵创建边，并将边加入到数组中
        for(int i = 0;i < vertexes.length;i++){
            for(int j = i + 1;j < vertexes.length;j++){
                if(this.matrix[i][j] != INF){
                    edges[index] = new Edge(vertexes[i],vertexes[j],this.matrix[i][j]);
                    index++;
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i为顶点的终点（逐步形成的的），用于后面判断2个顶点的终点是否是否相同
     * @param ends 记录各个顶点对应的终点是哪个
     * @param i 顶点对应的下标
     * @return 下标为i的顶点对应的终点的下标，如果end[i] == 0，则返回顶点的下标
     */
    private int getEnd(int[] ends,int i){
        while(ends[i] != 0){
            i = ends[i];//终点作为起点继续寻找最长的终点
        }
        return i;//返回最长的终点
    }

    /**
     * 克鲁斯卡尔算法核心
     */
    public void kruskal(){
        //表示最后结果数据的索引
        int index = 0;
        //用于保存每个顶点在已有最小生成树中的终点，默认为0
        int[] ends = new int[edgesNum];
        //创建结果数组保存，保存最后的最小生成树，边的集合
        Edge[] res = new Edge[edgesNum];
        //获取图中所有的边的集合，一共有12条边
        Edge[] edges = getEdges();
        //对边进行从小到大排序
        sortEdge(edges);
        //遍历保存边的数组，添加边到最小生成树，判断准备加入的边是否构成回路，如果没有，就加入，否则，不能加入
        for(int i = 0;i < edgesNum;i++){
            //获取第i条边的第一个顶点
            int a = getPosition(edges[i].start);//4
            //获取第i条边的终点
            int b = getPosition(edges[i].end);//5

            //获取顶点a，在已有的最小生成树中的终点
            int m = getEnd(ends,a);//4
            //获取顶点b，在已有的最小生成树中的终点
            int n =getEnd(ends,b);//5

            //判断是否构成回路
            if(m != n){//没有构成回路
                ends[m] = n;//修改m在已有生成树中的终点为n
                //加入第i条边，到最终的结果数组
                res[index] = edges[i];
                //索引后移，为添加下一条边做准备
                index++;
            }
        }

        //打印最终的最小生成树
        for(int i = 0;i < vertexes.length - 1;i++){
            System.out.print(res[i]+" ");
        }

        System.out.println();

        //打印各个顶点的终点，即ends数组
        for(int i = 0;i < vertexes.length - 1;i++){
            System.out.print(ends[i]+" ");
        }
    }
}
