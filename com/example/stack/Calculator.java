package com.example.stack;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/17 14:02
 * 中缀表达式
 * 使用栈计算一个表达式的结果
 * 7*2*2-5+3-4=?
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "700+2*6-2";//70+2*6-2?如何处理多位数的问题
        //创建两个栈，数栈，符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;//用于扫描字符
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到ch
        String keepNum = "";//用于拼接多位数

        //使用while循环扫描expression
        while(true){
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if(operStack.isOper(ch)){//如果是运算符
                //判断当前的符号栈是否为空
                if(!operStack.isEmpty()){//不为空，判断优先级
                    //如果当前操作符的优先级小于或等于符号栈栈顶符号的优先级
                    if(operStack.priority(ch)<=operStack.peek()){
                        //从数栈pop出两个数字，从符号栈pop出一个符号，进行运算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(oper);
                    }else{//符号的优先级大于符号栈栈顶符号的优先级，直接入符号栈
                        operStack.push(ch);
                    }
                }else{//如果符号栈为空，直接添加即可
                    operStack.push(ch);
                }
            }else{//如果ch是数字，直接入数栈
                //1.当处理多位数，不能发现一个数就立即入数栈，因为多位数不能拆开
                //2.在处理多位数时，需要向expression的表达式的index后再扫描一位，如果是数字继续进行扫描，如果是符号，则直接入栈
                //3.因此我们需要一个变量进行字符的拼接
                keepNum += ch;
                //1判断下一个字符是不是数字
                //1.1如果是数字，继续扫描
                //1.2如果是运算符，则入数栈

                //如果ch已经是expression的最后一位直接入数栈
                if(index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){//后一位是运算符
                        //keepNum += expression.substring(index+1,index+2).charAt(0);
                        numStack.push(Integer.parseInt(keepNum));//将'8'---->8
                        //将前面累计的数字清空
                        keepNum = "";
                    }
                }
            }
            //让index+1，并判断是否扫描到expression最后
            index++;
            if(index>=expression.length()){//扫描到最后了
                break;
            }
        }

        //整个表达式遍历结束后
        while(true){
            //如果符号栈为空，表示计算到最后的结果，此时数栈只有一个数（最终计算的结果）
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        //将数栈的最后一个数，pop出来，就是最终表达式的结果
        System.out.printf("表达式:%s = %d",expression,numStack.pop());
    }
}
