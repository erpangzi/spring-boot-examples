package com.equelsAndhashcode;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

    }


    @org.junit.Test
    void testEqualsObj(){
        User user1 = new User("1", "xiaohua", "14");
        User user2 = new User("2", "xiaohua", "14");
        System.out.println((user1.equals(user2)));//打印为 true
        String s = "1";
        s.hashCode();
    }

    @org.junit.Test
      void testHashCodeObj(){
        User user1 = new User("1", "xiaohua", "14");
        User user2 = new User("2", "xiaohua", "14");
        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode() == user2.hashCode());
        System.out.println(userSet);
    }

}
