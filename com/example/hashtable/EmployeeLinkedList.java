package com.example.hashtable;

/**
 * @author YangLiuQing
 * @date 2020/5/23 7:49
 * 雇员链表
 */
public class EmployeeLinkedList {

    Employee head;//头指针，指向第一个雇员，意味着链表没有头节点

    /**
     * 添加雇员到链表的最后，假定id是自增长的，即从小到大
     * @param emp
     */
    public void add(Employee emp){
        //如果是添加第一个雇员，因为头指针是指向第一个雇员，所以第一个雇员需要单独添加
        if(head == null){
            head = emp;
            return;
        }

        Employee cur = head;
        //如果不是第一个雇员，则使用一个辅助指针，帮助定位到链表最后
        while(cur.next!=null){
            cur = cur.next;
        }
        //退出时，直接将emp加入到链表
        cur.next = emp;
    }

    public void list(int i){
        if(head==null){//链表为空
            System.out.println("第"+(i+1)+"条链表为空");
            return;
        }
        Employee cur = head;

        while(cur!=null){
            System.out.println("第"+(i+1)+"条链表的信息为:"+cur);
            cur = cur.next;//后移
        }
    }

    /**
     * 查询
     * @param id
     * @return
     */
    public Employee findEmployeeById(int id){
        if(head==null){
            System.out.println("链表为空，无法查询");
            return null;
        }

        Employee cur = head;
        while(cur!=null){
            if(cur.id == id){
                return cur;
            }
            cur = cur.next;//后移
        }
        return null;
    }

    /**
     * 根据编号删除指定的雇员
     * @param id
     */
    public void delete(int id){
        if(head==null){
            System.out.println("链表为空，无法删除");
            return;
        }
        if(head.id == id){//删除头节点
            head = head.next;
        }

        Employee cur = head;
        while(cur!=null){
            if(cur.next.id == id){
                cur.next = cur.next.next;
                System.out.println("节点删除成功");
                return;
            }
            cur = cur.next;//后移
        }
        System.out.println("节点不存在，删除失败.");
    }


}
