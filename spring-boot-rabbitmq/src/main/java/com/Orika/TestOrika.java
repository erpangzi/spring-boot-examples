package com.Orika;

import com.Orika.Entity.*;
import com.student.Student;
import com.student.Teacher;
import ma.glasnost.orika.*;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestOrika {

    /**
     *      * 获取默认字段工厂 
     *      
     */
    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private  PersonCustomMapper customMapper = new PersonCustomMapper();

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








    @Test
    public void givenSrcAndDestWithDifferentFieldNames_whenMaps_thenCorrect() {
        mapperFactory.classMap(Personne.class, Person.class)
                .field("nom", "name").field("surnom", "nickname")
                .field("age", "age").register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Personne frenchPerson = new Personne("Claire", "cla", 25);
        Person englishPerson = mapper.map(frenchPerson, Person.class);

        Assert.assertEquals(englishPerson.getName(), frenchPerson.getNom());
        Assert.assertEquals(englishPerson.getNickname(), frenchPerson.getSurnom());
        Assert.assertEquals(englishPerson.getAge(), frenchPerson.getAge());
    }

    @Test
    public void PersonToPersonOne(){
        Person person = new Person("zhangsan", "zs", 18);
        MapperFactory mapperFactory1 = new DefaultMapperFactory.Builder().build();
        mapperFactory1.classMap(Person.class, Personne.class)
                .field("name", "nom")
                .field("nickname", "surnom")
                .field( "age","age").register();
        MapperFacade mapperFacade = mapperFactory1.getMapperFacade();
        Personne personne = mapperFacade.map(person, Personne.class);
        System.out.println(personne.toString());
    }

    @Test
    public void PersonToPersonOne2(){
        Person person = new Person("zhangsan", "zs", 18,"test");
        MapperFactory mapperFactory1 = new DefaultMapperFactory.Builder().build();
        mapperFactory1.classMap(Person.class, Personne.class)
                .field("name", "nom")
                .field("nickname", "surnom")
                .field( "age","age").register();
        MapperFacade mapperFacade = mapperFactory1.getMapperFacade();
        Personne personne = mapperFacade.map(person, Personne.class);
        System.out.println(personne.toString());
    }

    @Test
    public void PersonToPersonOne1(){
        Person person = new Person("zhangsan", "zs", 18);
        Student student = new Student("zhangsan", 18);
        System.out.println(person.getClass());
        MapperFactory mapperFactory1 = new DefaultMapperFactory.Builder().build();
        mapperFactory1.classMap(Student.class, Teacher.class)
                .byDefault().register();
        MapperFacade mapperFacade = mapperFactory1.getMapperFacade();
        Teacher teacher = mapperFacade.map(student, Teacher.class);
        System.out.println(teacher.toString());

    }

    @Test
    public void givenSrcAndDest_whenCustomMapperWorks_thenCorrect() {
        mapperFactory.classMap(Personne3.class, Person3.class)
                .customize(customMapper).register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        String dateTime = "2007-06-26T21:22:39Z";
        long timestamp = new Long("1182882159000");
        Personne3 personne3 = new Personne3("Leornardo", timestamp);
        Person3 person3 = mapper.map(personne3, Person3.class);

        Assert.assertEquals(person3.getDtob(), dateTime);
    }

    @Test
    public void givenSrcAndDest_whenCustomMapperWorksBidirectionally_thenCorrect() {
        mapperFactory.classMap(Personne3.class, Person3.class)
                .customize(customMapper).register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        String dateTime = "2007-06-26T21:22:39Z";
        long timestamp = new Long("1182882159000");
        Person3 person3 = new Person3("Leornardo", dateTime);
        Personne3 personne3 = mapper.map(person3, Personne3.class);

        Assert.assertEquals(person3.getDtob(), timestamp);
    }

}





class PersonCustomMapper extends CustomMapper<Personne3, Person3> {

    @Override
    public void mapAtoB(Personne3 a, Person3 b, MappingContext context) {
        Date date = new Date(a.getDtob());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String isoDate = format.format(date);
        b.setDtob(isoDate);
    }

    @Override
    public void mapBtoA(Person3 b, Personne3 a, MappingContext context) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = format.parse(b.getDtob());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long timestamp = date.getTime();
        a.setDtob(timestamp);
    }
}



