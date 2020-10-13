package com.example.algorithm.greedy;

import java.util.*;

/**
 * @author YangLiuQing
 * @date 2020/5/28 16:34
 * 贪心算法
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        //创建保存广播电台的Map
        Map<String,HashSet<String>> broadcasts = new HashMap<>();

        //将各个电台加入到Map中
        HashSet<String> k1 = new HashSet<String>();
        HashSet<String> k2 = new HashSet<String>();
        HashSet<String> k3 = new HashSet<String>();
        HashSet<String> k4 = new HashSet<String>();
        HashSet<String> k5 = new HashSet<String>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");

        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");

        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");

        k4.add("上海");
        k4.add("天津");

        k5.add("杭州");
        k5.add("大连");

        broadcasts.put("k1",k1);
        broadcasts.put("k2",k2);
        broadcasts.put("k3",k3);
        broadcasts.put("k4",k4);
        broadcasts.put("k5",k5);

        //保存未覆盖的地区
        HashSet areas = new HashSet<String>();

        //获取所有未覆盖的地区
        for(Collection col:broadcasts.values()){
            Iterator iterator = col.iterator();
            while (iterator.hasNext()){
                areas.add(iterator.next());
            }
        }

        //创建一个ArrayList，存放选择的电台
        ArrayList<String> selects = new ArrayList<>();

        //在一次遍历过程中，用来保存覆盖未覆盖地区最多的广播电台，形式:k1,k2,k3,k4,k5
        String maxKey = null;

        //临时的Set集合，用来存放未覆盖地区areas和广播台的交集
        HashSet tempSet = new HashSet<String>();

        System.out.println(areas);

        while(areas.size() != 0){//表示没有覆盖到所有的地区
            //遍历Map，找到未覆盖地区最多的电台，取出对应的key（用来保存遍历到的当前广播，形式:k1,k2,k3,k4,k5）
            for (String key:broadcasts.keySet()) {//获取Map中的key
                //当前key能覆盖的地区
                HashSet area = broadcasts.get(key);
                //添加到tempSet
                tempSet.addAll(area);
                //求tempSet和areas的交集
                tempSet.retainAll(areas);//交集会赋给tempSet
                //如果当前集合包含的未覆盖地区的数量，比maxKey指向集合未覆盖的地区多，则对maxKey重新赋值
                //tempSet.size() > broadcasts.get(maxKey).size()，每次都选择最优的，体现贪婪算法的思想
                if(tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    //如果maxKey没有值或者当前key未覆盖的地区比maxKey的地区还多，修改maxKey的值
                    maxKey = key;
                }
                //清空临时的Set集合
                tempSet.clear();
            }
            if(maxKey != null){//将maxKey加入到选择的电台中
                selects.add(maxKey);
                //从未覆盖的地区中移除maxKey指向集合中未覆盖的地区
                areas.removeAll(broadcasts.get(maxKey));
            }
            //清空，为下一次寻找未覆盖地区最多的广播做准备
            maxKey = null;
        }

        System.out.println("最终的选择结果是:"+selects.toString());
    }
}
