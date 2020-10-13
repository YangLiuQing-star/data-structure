package com.example.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @author YangLiuQing
 * @date 2020/5/29 10:16
 * 图类
 */
public class Graph {

    private char[] vertex;//顶点数组，用来保存顶点
    private int[][] matrix;//邻接矩阵，用来保存图结构
    private  VisitedVertex visitedVertex;//已访问过顶点的集合

    //构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //打印图对应的邻接矩阵
    public void printGraph(){
        for(int[] link : matrix){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 迪杰特斯拉算法
     * @param index
     */
    public void dijkstra(int index){
        //设置出发顶点
        this.visitedVertex = new VisitedVertex(vertex.length, index);
        //更新index顶点到周围顶点的距离和它们的前驱结点
        update(index);
        //继续选择并返回新的访问顶点， 比如这里的G完后，就是 A点作为新的访问顶点(注意不是出发顶点)
        for(int j = 1;j < vertex.length;j++){
            //返回新的访问顶点
            index = visitedVertex.updateArr();
            //更新index顶点到周围顶点的距离和它们的前驱结点
            update(index);
        }
    }


    /**
     * 更新index下标对应的顶点到周围顶点的距离和周围顶点的前驱结点
     * @param index
     */
    private void update(int index){
        int len = 0;
        //遍历邻接矩阵index行的所有元素
        for(int j = 0;j < matrix[index].length;j++){
            //出发顶点到index顶点的距离 + 从index顶点到j顶点的距离和 = 出发顶点到顶点j的距离
            len = visitedVertex.getDis(index) + matrix[index][j];
            //如果顶点j没有被访问过，而且len小于出发顶点到j顶点的距离，此时需要更新
            if(!visitedVertex.in(j) && len < visitedVertex.getDis(j)){
                //更新顶点j的前驱为index顶点
                visitedVertex.updatePre(j,index);
                //更新顶点j到出发顶点的距离
                visitedVertex.updateDis(j,len);
            }
        }
    }

    /**
     * 输出最终3个数组的情况
     */
    public void showDjs(){
        visitedVertex.printArrays();
    }
}
