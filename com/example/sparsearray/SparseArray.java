package com.example.sparsearray;

/*
	稀疏数组：数组中的元素绝大部分数据都为0
	稀疏数组可以采用压缩存储
原始数组
0	0	0	0	0	0	0	0	0	0	0
0	0	1	0	0	0	0	0	0	0	0
0	0	0	2	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0	0	0	0
稀疏数组
11	11	2
1	2	1
2	3	2
*/

import java.io.*;

public class SparseArray {

    //用于打印二维数组的函数
    public static void printArray(int[][] array){
        for (int row[]:array){
            for(int data:row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        //1.先创建一个原始的二维数据11*11,0：表示没有棋子，1：表示黑子，2：表示蓝子
        int chessArr1[][] = new int[11][11];//用于保存棋盘的原始数组
        int sum = 0;//用于保存非零元素的个数


        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始数组为:");
        //输出原始的二维数组
        printArray(chessArr1);

        //2.二维数组转换成稀疏数组
        //1.遍历原始二维数组得到非零元素的个数，从而确定稀疏数组的大小，创建出稀疏数组:spareArray[sum+1][3]
        //2.遍历二维数组，得到非零元素所在的行数和列数以及值存放在稀疏数组中
        for (int row[]:chessArr1){
            for(int data:row){
                if(data!=0){
                    sum++;
                }
            }
        }

        int[][] spareArray = new int[sum+1][3];
        spareArray[0][0] = 11;
        spareArray[0][1] = 11;
        spareArray[0][2] = sum;
        int count = 0;//用于记录第几个非0数据

        for(int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1[i].length;j++){
                if (chessArr1[i][j]!=0){
                        count++;
                        spareArray[count][0] = i;
                        spareArray[count][1] = j;
                        spareArray[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("\n稀疏数组为:");
        printArray(spareArray);
        writeArrayIntoDisk(spareArray);
        System.out.println("\n稀疏数组写入磁盘成功.......");
        int[][] spareArray2= readArrayFromDisk(sum);
        System.out.println("\n磁盘中成功读取稀疏数组.......");
        printArray(spareArray2);
        //3.将稀疏数组还原成二维数组
        //原始数组的行数和列数来自于稀疏数组的spareArray1[0][0]，spareArray1[0][1]，创建出原始二维数组chessArray2
        //从第一行开始遍历稀疏数组，遍历spareArray1[0][2]次，取出每次遍历得到的i,j及spareArray[i][j]，开始还原原始数组
        int row,col;//定义变量保存原始数组的行数和列数
        row = spareArray2[0][0];
        col = spareArray2[0][1];

        int[][] chessArray2 = new int[row][col];
        for(int i=1;i<=spareArray2[0][2];i++){
            chessArray2[spareArray2[i][0]][spareArray2[i][1]] = spareArray2[i][2];
        }

        System.out.println("\n还原后的二维数组:");
        printArray(chessArray2);
    }

    public static void writeArrayIntoDisk(int arr[][]) throws IOException {
        //1.创建文件
        File map = new File("map.data");
        //2.创建流
        FileWriter fw = new FileWriter(map);
        BufferedWriter bw = new BufferedWriter(fw);
        //3.操作流
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                bw.write(arr[i][j]+"\t");
            }
            bw.newLine();
        }
       //4.关闭资源
        bw.close();
    }

    public static int [][] readArrayFromDisk(int sum) throws IOException {
        int arr[][] = new int[sum+1][3];
        int row = 0;//用于记录稀疏数组的行数
        //1.创建文件
        File map = new File("map.data");
        //2.创建流
        FileReader fr = new FileReader(map);
        BufferedReader br = new BufferedReader(fr);
        //3.操作流
        String line = null;
        while((line=br.readLine())!=null){
            String[] temp = line.split("\t");
            for(int j=0;j<temp.length;j++){
                arr[row][j] = Integer.parseInt(temp[j]);
            }
            row++;
        }
        //4.关闭资源
        return arr;
    }
}
