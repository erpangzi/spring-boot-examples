package com.JDK8.CollectorsToMap;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToMap {

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
                new User("A","张三"),
                new User("B","李四"),
                new User("C","王五"));

        Map<String, String> map = new HashMap<>();
        for (User user : userList) {
            map.put(user.getId(), user.getName());
        }

        Map<String, User> collect = userList.stream().collect(Collectors.toMap(User::getId, t -> t));
        System.out.println(collect.toString());
        Map<String, User> collect1 = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(collect1.toString());

        List<User> userList01 = Arrays.asList(
                new User("A","张三"),
                new User("A","李四"),
                new User("C","王五"));

        Map<String, User> collect2 = userList01.stream().collect(Collectors.toMap(User::getId, user -> user, (n1, n2) -> n1 ));
        System.out.println(collect2);


        List<User> userList02 = Arrays.asList(
                new User("A","张三"),
                new User("A","李四"),
                new User("C","王五"));
        TreeMap<String, String> collect3 = userList02.stream().collect(
                Collectors.toMap(User::getId, User::getName, (n1, n2) -> n1, TreeMap::new)
        );
        System.out.println(collect3);

    }


    @Test
    public void testCollectToList(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 要求：将list中每个数值扩大10倍 结果为： [10, 20, 30]

        //先将list转化为stream类型，map内 等于遍历map方法使所有数据乘以10
        List<Integer> collectTwo = list.stream().map(i -> i * 10).collect(Collectors.toList());
        System.out.println(collectTwo.toString());


        Set<Integer> collect2 = list.stream().map(i -> i * 10).collect(Collectors.toSet());
        System.out.println(collect2.toString());



    }

    @Test
    public void testCollectToMap(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        // {key1=value:10, key2=value:20, key3=value:30}  {key1=value:1 , key2=value:2 , key3=value:3 }
        // toMap 可用于将List转为Map，便于通过key快速查找到某个value
        Map<String, String> collect1 = list.stream().map(i -> i * 10).collect(Collectors.toMap(key -> "key" + key/10, value -> "value:" + value));
        Map<String, String> collect2 = list.stream().map(i -> i).collect(Collectors.toMap(key -> "key" + key, value -> "value:" + value));

        //实体list转化map id作为主键，对象作为value
        List<DatabusTask> databusTaskArrayList=new ArrayList<DatabusTask>();
        DatabusTask databusTask=new DatabusTask();
        databusTask.setId("1");
        databusTask.setFile_name("测试");
        databusTaskArrayList.add(databusTask);

        Map<String,DatabusTask> taskMap = databusTaskArrayList.stream().collect(Collectors.toMap(DatabusTask::getId, entity -> entity));
        System.out.println(collect1.toString());
        System.out.println(collect2.toString());
        System.out.println(taskMap.toString());
    }

}

class DatabusTask{
    private String id;
    private String file_name;

    public DatabusTask() {
    }

    public DatabusTask(String id, String file_name) {
        this.id = id;
        this.file_name = file_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}

class User {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
