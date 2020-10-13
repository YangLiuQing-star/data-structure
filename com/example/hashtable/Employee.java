package com.example.hashtable;

/**
 * @author YangLiuQing
 * @date 2020/5/23 7:48
 * 雇员类
 */
public class Employee {

    public int id;
    public String name;
    public Employee next;//指向当前雇员的下一个雇员

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
