package com.example.hashtable;

import java.util.Scanner;

/**
 * @author YangLiuQing
 * @date 2020/5/23 7:47
 * 哈希表
 */
public class HashTableTest {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        //写一个菜单
        String key = "";
        int id = 0;
        String name = "";
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while(loop){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:按照编号查找雇员");
            System.out.println("delete:按照编号删除雇员");
            System.out.println("exit:退出系统");
            key = scanner.next();

            switch (key){
                case "add":
                    System.out.println("请输入雇员的编号:");
                    id = scanner.nextInt();
                    System.out.println("请输入雇员的姓名:");
                    name = scanner.next();
                    Employee emp = new Employee(id,name);
                    hashTab.add(emp);
                    System.out.println("添加成功...");
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入雇员的编号:");
                    id = scanner.nextInt();
                    Employee employee = hashTab.findEmployeeById(id);
                    if(employee!=null){
                        System.out.println("查询成功，雇员的信息为"+employee);
                    }else{
                        System.out.println("查询失败，编号不存在");
                    }
                    break;
                case "delete":
                    System.out.println("请输入雇员的编号:");
                    id = scanner.nextInt();
                    hashTab.delete(id);
                    break;
                case "exit":
                    loop = false;
                    scanner.close();
                    System.out.println("成功退出系统...");
                    break;
                default:
                    break;
            }
        }
    }
}
