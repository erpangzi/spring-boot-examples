package com.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 4);
        List<String> strings = Arrays.asList("1, 3, 4", "1, 3, 4", "1, 3, 4");
        List<Student> lists = new ArrayList<>();
        Student student = new Student();
        student.setName("laoli");
        student.setNumber(1);
        lists.add(student);
        Student student1 = new Student();
        student1.setName("erzi");
        student1.setNumber(2);
        lists.add(student1);
        Student student3 = new Student();
        student3.setName("three");
        student3.setNumber(1);
        lists.add(student3);

        List<Student> students = new ArrayList<>();
        for (Student s : lists){
            if (s.getName()=="laoli" || s.getNumber()==1){
                Student clone = null;
                try {
                      clone = (Student)s.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                students.add(clone);
            }
        }
        for (Student ss : students){
            if (ss.getName()=="laoli" || ss.getNumber()==1){
                ss.setName("赖大哥");
            }
        }
        System.out.println("students:"+students.toString());
        System.out.println("-------------------------------");
        System.out.println("lists:"+lists.toString());



    }


}
