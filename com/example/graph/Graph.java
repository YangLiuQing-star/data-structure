package com.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author YangLiuQing
 * @date 2020/5/27 9:36
 * 图
 */
public class Graph {

    private ArrayList<String> vertexList;//存储结点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的条数
    private boolean[] isVisited;//记录某个结点是否被访问

    public static void main(String[] args) {
        //测试图是否创建成功
        int n = 8;//结点的个数
        String vertexes[] = {"A","B","C","D","E"};
//        String vertexes[] = {"1","2","3","4","5","6","7","8"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环插入结点
        for(String vertexesValue : vertexes){
            graph.insertVertex(vertexesValue);
        }
        //添加边 ab,ac,bc,bd,be
        graph.addEdge(0,1,1);//ab
        graph.addEdge(0,2,1);//ac
        graph.addEdge(1,3,1);//bc
        graph.addEdge(1,3,1);//bd
        graph.addEdge(1,4,1);//be

        //更新边
//        graph.addEdge(0,1,1);
//        graph.addEdge(0,2,1);
//        graph.addEdge(1,3,1);
//        graph.addEdge(1,4,1);
//        graph.addEdge(3,7,1);
//        graph.addEdge(4,7,1);
//        graph.addEdge(2,5,1);
//        graph.addEdge(2,6,1);
//        graph.addEdge(5,6,1);

        //显示邻接矩阵
        graph.displayGraph();

        //深度优先遍历
        System.out.println("深度优先遍历");
        graph.dfs();

        System.out.println();

        //广度优先遍历
        System.out.println("广度优先遍历");
        graph.bfs();
    }

    /**
     * 构造器
     * @param n 定点的个数
     */
    public Graph(int n){
        //初始化矩阵
        edges = new int[n][n];
        //初始化顶点的集合
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    /**
     * 插入结点
     * @param vertex
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 第一个顶点的下标 "A" --- "B"  A--->0  B--->1
     * @param v2 第二个顶点的下标
     * @param weight 表示顶点关联使用的值
     */
    public void addEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 返回结点的个数
     * @return
     */
    public int getNumVertex(){
        return vertexList.size();
    }

    /**
     * 返回边的条数
     * @return
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 返回结点对应的字符串
     * @param i 结点的下标
     * @return 结点对应的字符串
     */
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }


    /**
     * 返回两个结点之间的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    /**
     * 显示图对应的矩阵
     */
    public void displayGraph(){
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 返回当前结点的邻接结点的下标
     * @param index 当前结点的下标
     * @return 如果邻接结点存在，返回邻接结点的下标，否则，返回-1
     */
    public int getFirstNeighbor(int index){
        for(int i = 0;i < vertexList.size();i++){
            if (edges[index][i] > 0){//说明下标为index,i的结点之间存在边
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据当前结点的第一个邻接结点的下标，获取第二个邻接结点的下标
     * @param v1 当前结点
     * @param v2 当前结点的第一个邻接结点的下标
     * @return 第二个邻接结点的下标，如果存在，返回下标，不存在返回-1
     */
    public int getNextNeighborByPre(int v1,int v2){
        for(int i = v2 + 1; i < vertexList.size();i++){//v2的后面继续寻找
            if(edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 遍历所有的结点，进行dfs
     */
    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for(int i = 0;i < getNumVertex();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    /**
     * 对一个结点进行深度优先遍历
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited,int i){
        //我们访问该结点
        System.out.print(getValueByIndex(i)+"--->");
        //将该结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点的下标
        int w = getFirstNeighbor(i);
        while(w != -1){//邻接结点存在
            if(!isVisited[w]){//w没有被访问过
                dfs(isVisited,w);//把邻接当成初始结点继续深度优先遍历
            }
            //w被访问过
            w =  getNextNeighborByPre(i, w);//继续遍历当前结点的第二个邻接结点
        }
    }

    /**
     * 对一个结点进行广度优先遍历
     * @param isVisited
     * @param i
     */
    private void bfs(boolean[] isVisited,int i){
        int u;//表示队列头结点对应的下标
        int w;//邻接结点w
        //队列，记录结点的访问顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点的信息
        System.out.printf(getValueByIndex(i)+"--->");
        //标记为已访问
        isVisited[i] = true;
        //入队尾
        queue.addLast(i);
        while(!queue.isEmpty()){//队列非空
            //取出队列头结点的下标，自动拆箱 Integer ---> int
            u = (Integer) queue.removeFirst();
            //以队列头为初始结点，得到第一个邻接结点的下标
            w = getFirstNeighbor(u);
            while(w != -1){//邻接结点存在
                if(!isVisited[w]){//w没有访问过
                    //访问w结点
                    System.out.printf(getValueByIndex(w)+"--->");
                    isVisited[w] = true;//标记为已访问
                    //入队列
                    queue.addLast(w);
                }
                //如果访问过，以u为前驱点，寻找w后面的下一个邻接结点
                w = getNextNeighborByPre(u, w);
            }
        }
    }

    /**
     * 重载广度优先遍历的方法，遍历所有的结点，进行广度优先遍历
     * 因为对一个结点进行深度遍历可能不能将所有的顶点都遍历到
     */
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for(int i = 0;i < getNumVertex();i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
}
