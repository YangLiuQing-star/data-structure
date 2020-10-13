package com.example.algorithm.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author YangLiuQing
 * @date 2020/5/30 8:14
 * 骑士周游问题
 * 使用贪心算法对原来的算法优化
 * 1.我们获取当前位置，可以走的下一个位置的集合
 * 2.我们对ps中每一个point的下一步位置的集合，进行非递减排序
 *  8,7,6,5,4,3,2,1递减
 * 1,2,2,2,3,3,3,4,5,6 非递减
 * 1,2,3,4,5,6,7,8   递增
 * 8,7,7,6,5,4,4,3,2,1 非递增
 */
public class HorseChessBoard {

    private static int X;//棋盘的列数
    private static int Y;//棋盘的行数

    //创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean[] visited;

    //标记最终是否完成成功
    private static boolean isFinished;


    public static void main(String[] args) {
        X = 6;
        Y = 6;
        int row = 2;//马儿初始位置的行
        int col = 3;//马儿初始位置的列
        //创建棋盘
        int[][] chessBoard = new int[X][Y];
        visited = new boolean[X * Y];
        //记录开始时间
        long start = System.currentTimeMillis();

        System.out.println("骑士周游开始......");
        travelChessBoard(chessBoard,row-1,col-1,1);
        System.out.println("骑士周游结束......");
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.printf("骑士周游%d * %d的棋盘，耗时:%d 毫秒\n",X,Y,(end - start));

        //输出棋盘的最后情况
        for(int[] rows : chessBoard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }


    }

    /**
     * 根据当前位置，计算马儿还能走哪些位置
     * @param curPoint 当前顶点的位置
     * @return 马儿下一步可以走的位置的集合
     */
    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个Point
        Point p1 = new Point();
        //表示马儿可以走5这个位置
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走6这个位置
        if((p1.x = curPoint.x - 1) >=0 && (p1.y=curPoint.y-2)>=0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走7这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走0这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    /**
     * 完成骑士周游问题的算法
     * @param chessBoard 棋盘
     * @param row 马儿当前位置的行号
     * @param col 马儿当前位置的列号
     * @param step 马儿走的是第几步，初始位置是第一步
     */
    public static void travelChessBoard(int[][] chessBoard,int row,int col,int step){
        chessBoard[row][col] = step;
        //起始位置:第36个位置 =  4 * row + 4，标记该位置已访问
        visited[row * X + col ] = true;
        //获取当前位置下一步可以选择的位置
        ArrayList<Point> points = next(new Point(col, row));

        //为了减少回溯的次数，先进行非递减排序，再遍历
        sort(points);

        //遍历points
        while(!points.isEmpty()){
            //取出下一个可以走的位置
            Point p = points.remove(0);
            //判断该点是否已经访问过
            if(!visited[p.y * X + p.x]){//未访问
                travelChessBoard(chessBoard,p.y,p.x,step + 1);
            }
        }
        //while循环结束后，判断任务是否完成
        //step < x * y的情况有2种
        //1.棋盘处于当前位置任然没有走完
        //2.棋盘处于一个回溯过程中
        if(step < X * Y && !isFinished){
            //起始点置为0
            chessBoard[row][col] = 0;
            //该位置从true，置为false，即未访问
            visited[row * X + col ] = false;
        }else{//step == X * Y && isFinished
            isFinished = true;
        }
    }

    /**
     * 根据当前这一步的所有下一步的选择位置，进行非递减排序，减少回溯的次数（优化）
     * @param ps 这一步的所有下一步的选择位置
     * @return
     */
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //1.获取到o1的下一步位置集合的大小
                int size1 = next(o1).size();
                //2.获取到o2的下一步位置集合的大小
                int size2 = next(o2).size();
                if(size1 < size2){
                    return -1;
                }else if(size1 == size2){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
    }
}
