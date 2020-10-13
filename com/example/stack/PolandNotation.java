package com.example.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author YangLiuQing
 * @version 1.0
 * @date 2020/5/18 7:33
 * 逆波兰计算器
 * 前缀表达式（波兰式）：-*+3456       运算符位于操作数之前
 * 从右到左扫描表达式，遇到数字直接入栈，遇到运算符，从数栈中弹出2个数，进行运算（前面减后面）
 * 中缀表达式：(3+5)*5-6
 * 后缀表达式（逆波兰式）：34+5*6-     运算符位于操作数之后
 */
public class PolandNotation {

    public static void main(String[] args) {
        //将中缀表达式转化成后缀表达式 1+((2+3)*4)-5 ====> 1 2 3 + 4 * + 5 -  ls=[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        //为了便于扫描，先将中缀表达式放到ArrayList中
        //中缀表达式转换成逆波兰式表达式
        String infixExpression  = "1+((2+3)*4)-5";//16
        List<String> ls = toInfixExpressionList(infixExpression);
        System.out.println("ls="+ls);
        List<String> res = parseSuffixExpressionList(ls);
        System.out.println("后缀表达式对应的List"+res);

        int result2 = calculate(res);
        System.out.printf("%s=%d",res,result2);

        //先定义一个逆波兰表达式，为了处理方便，数字和符号用空格隔开
        //String suffixExpression = "3 4 + 5 * 6 -"; //29
        //中缀:4 * 5 - 8 + 60 + 8 / 2   后缀:4 5 *  8 - 60 +8 2 / +
        //String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";//76
        //1.先将表达式放到ArrayList中
        //List<String> ls = getListString(suffixExpression);
        //System.out.println("ls="+ls);
        //2.将ArrayList传递给一个方法，遍历ArrayList，配合栈完成计算
        //int res = calculate(ls);
        //System.out.println("计算的结果="+res);
    }

    //先将表达式中数字和运算符放到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将表达式分割
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList();
        for(String str:strings){
            list.add(str);
        }
        return list;
    }

    //计算逆波兰表达式的值
    public static int calculate(List<String> ls){
        //创建一个栈，只需要一个栈
        Stack<String> stack = new Stack<>();
        //遍历list代替原来的扫描每个字符
        for(String str:ls){
            //使用正则表达式来取出数
            if(str.matches("\\d+")){//匹配的是多位数
                //入栈
                stack.push(str);
            }else{
                //pop出两个数，并运算，结果再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;//存放运算的结果

                switch (str){//先入栈的操作数在前
                    case "+":
                        res = num2+num1;
                        break;
                    case "-":
                        res = num2-num1;
                        break;
                    case "*":
                        res = num2*num1;
                        break;
                    case "/":
                        res = num2/num1;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }

    //存放中缀表达式的内容到List
    public static List<String> toInfixExpressionList(String s){
        //先定义一个List
        List<String> ls = new ArrayList<>();
        int i = 0;//用于遍历中缀表达式对应的字符串
        String str;//用来完成对多位数的拼接操作
        char c;//每遍历到一个字符，保存到c中

        do {
            //如果c不是数字，需要加入到ls
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){//48-57 0-9
                ls.add(c+"");
                i++;//i后移
            }else{//如果是一个数字，需要考虑多位数
                str = "";
                while(i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){//数字
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i<s.length());
        return ls;
    }

    //中缀表达式转换成逆波兰式表达式
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        //由于s2栈没有pop操作，而且还需逆序输出，直接使用ArrayList代替s2
        //Stack<String> s2 = new Stack<>();存储中间结果的栈s2
        List<String> s2 = new ArrayList<>();

        //遍历ls
        for(String str:ls){
            if(str.matches("\\d+")){//如果是一个数，加入s2
                s2.add(str);
            }else if("(".equals(str)){//如果是'('直接入符号栈
                s1.push(str);
            }else if(")".equals(str)){
                //如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while(!"(".equals(s1.peek())){
                    s2.add(s1.pop());
                }
                //弹出左括号，此时消除一对小括号
                s1.pop();
            }else{//如果是运算符，则比较优先级
                //当str的优先级小于等于是栈顶的优先级，将s1栈顶的运算符加入s2中，再次重复该操作
                //缺少一个比较优先级高低的方法
                while(s1.size()!=0 && (Operation.getValue(s1.peek())) >= (Operation.getValue(str))){
                    s2.add(s1.pop());
                }
                //将低优先级的item压入栈中
                s1.push(str);
            }
        }

        //将s1中剩余的运算符弹出并加入到s2中
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        //因为存放到List中，按顺序输出就是后缀表达式对应的字符串
        return s2;
    }
}
