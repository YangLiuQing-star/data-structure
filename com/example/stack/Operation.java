package com.example.stack;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/18 10:31
 * 可以返回运算符对应的优先级
 */
public class Operation {

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //返回优先级对应的数字
    public static int getValue(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                res = -1;
                break;
        }
        return res;
    }
}
