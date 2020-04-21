package com.DateUtil;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {



    public static void main(String[] args) {

        String nowDateStr = LocalDate.now().toString();
        System.out.println(nowDateStr);//2018-03-27

        LocalDate nowDate = LocalDate.parse("2018-03-25");
        System.out.println(nowDate.toString());//2018-03-25


        String nowTimeStr = LocalTime.now().toString();
        System.out.println(nowTimeStr);//13:45:07.105

        LocalTime nowTime = LocalTime.parse("12:10:13");
        System.out.println(nowTime.toString());//12:10:13

        System.out.println(LocalDateTime.now().toString());//2018-03-27T13:55:34.047
        System.out.println(LocalDateTime.now().toLocalDate().toString());//2018-03-27
        System.out.println(LocalDateTime.now().toLocalTime().toString());//13:55:34.047

        System.out.println(LocalDateTime.MAX.toString());//+999999999-12-31T23:59:59.999999999
        System.out.println(LocalDateTime.MIN.toString());//-999999999-01-01T00:00

        new DateTest().date2LocalDateTime(new Date());
        new DateTest().localDateTime2Date(LocalDateTime.now());
    }


    /**
     * Date转换为LocalDateTime
     * @param date
     */
    public void date2LocalDateTime(Date date){
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        System.out.println(localDateTime.toString());//2018-03-27T14:07:32.668
        System.out.println(localDateTime.toLocalDate() + " " +localDateTime.toLocalTime());//2018-03-27 14:48:57.453

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//This class is immutable and thread-safe.@since 1.8
        System.out.println(dateTimeFormatter.format(localDateTime));//2018-03-27 14:52:57
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     */
    public void localDateTime2Date( LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        Date date = Date.from(zdt.toInstant());
        System.out.println(date.toString());//Tue Mar 27 14:17:17 CST 2018
    }


}
