package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangLiuQing
 * @date 2020/5/23 15:21
 * 数组扩容
 * 1.每次在底层都需要创建新的数组
 * 2.然后将原来的数据拷贝到数组
 * 3.并插入新的数据
 * 顺序存储
 * 检索效率较高，但是插入和删除效率较低
 * 链式存储
 * 插入和删除时，性能不错，但是检索时，效率过低
 */
public class Test {

    public static void main(String[] args) {
        //以ArrayList为例，底层是如何进行数据扩容
        List ls = new ArrayList();
    }
}
