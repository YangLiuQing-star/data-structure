package com.example.hashtable;

/**
 * @author YangLiuQing
 * @date 2020/5/23 8:21
 * 哈希表
 */
public class HashTab {

    private EmployeeLinkedList employeeLinkedList[];
    private int size;//代表哈希表中链表的条数

    /**
     * 构造器
     * 初始化哈希表
     * @param size
     */
    public HashTab(int size){
        this.size = size;
        employeeLinkedList = new EmployeeLinkedList[size];
        //分别初始化每一条链表，否则会出现空指针异常
        for(int i = 0;i < size;i++){
            employeeLinkedList[i] = new EmployeeLinkedList();
        }
    }

    //添加雇员
    public void add(Employee emp){
        //根据员工的id，确定该员工添加到哪一条链表
        int index = hashFun(emp.id);
        //添加雇员到对应的链表中
        employeeLinkedList[index].add(emp);
    }

    //遍历Hash表
    public void list(){
        for(int i = 0;i < size;i++){
            employeeLinkedList[i].list(i);
        }
    }

    /**
     * 按照编号，查找指定的雇员
     * @param id
     * @return
     */
    public Employee findEmployeeById(int id){
        int index = hashFun(id);
        Employee emp = employeeLinkedList[index].findEmployeeById(id);
        return emp;
    }

    /**
     * 编写一个散列函数
     * 采用取模法，确定该id所在的链表
     * @param id
     * @return
     */
    public int hashFun(int id){
        return id % size;
    }

    /**
     * 根据编号，删除指定雇员
     * @param id
     */
    public void delete(int id){
        int index = hashFun(id);
        employeeLinkedList[index].delete(id);
    }

}
