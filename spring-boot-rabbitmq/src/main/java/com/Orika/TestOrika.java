package com.Orika;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TestOrika {

    /**
     *      * 获取默认字段工厂 
     *      
     */
    private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();


    @Test
    public void givenSrcAndDest_whenMaps_thenCorrect() {
        //MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Source.class, Dest.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Source src = new Source("Baeldung", 10);
        Dest dest = mapper.map(src, Dest.class);

        Assert.assertEquals(dest.getAge(), src.getAge());
        Assert.assertEquals(dest.getName(), src.getName());
    }


    @Test
    public void givenSrcAndDest_whenMapsUsingBoundMapper_thenCorrect() {
        BoundMapperFacade<Source, Dest>
                boundMapper = mapperFactory.getMapperFacade(Source.class, Dest.class);
        Source src = new Source("baeldung", 10);
        Dest dest = boundMapper.map(src);

        Assert.assertEquals(dest.getAge(), src.getAge());
        Assert.assertEquals(dest.getName(), src.getName());
    }


    @Test
    public void givenSrcAndDest_whenMapsUsingBoundMapperInReverse_thenCorrect() {
        BoundMapperFacade<Source, Dest>
                boundMapper = mapperFactory.getMapperFacade(Source.class, Dest.class);
        Dest src = new Dest("baeldung", 10);
        Source dest = boundMapper.mapReverse(src);

        Assert.assertEquals(dest.getAge(), src.getAge());
        Assert.assertEquals(dest.getName(), src.getName());
    }






}

class Source {
    private String name;
    private int age;

    public Source(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // standard getters and setters
}


class Dest {
    private String name;
    private int age;

    public Dest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // standard getters and setters
}

class Person {
    private String name;
    private String nickname;
    private int age;

    public Person(String name, String nickname, int age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // standard getters and setters
}

class Personne {
    private String nom;
    private String surnom;
    private int age;

    public Personne(String nom, String surnom, int age) {
        this.nom = nom;
        this.surnom = surnom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
// standard getters and setters
}

