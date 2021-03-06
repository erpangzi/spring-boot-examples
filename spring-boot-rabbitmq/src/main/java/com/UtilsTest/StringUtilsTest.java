package com.UtilsTest;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {


    public static void main(String[] args) {
        String srt = " ";
        String srt1 = null;
        String srt2 = "";

        System.out.println(StringUtils.isEmpty(srt));
        System.out.println(StringUtils.isEmpty(srt1));
        System.out.println(StringUtils.isEmpty(srt2));

        System.out.println(StringUtils.isBlank(srt));
        System.out.println(StringUtils.isBlank(srt1));
        System.out.println(StringUtils.isBlank(srt2));

        System.out.println(StringUtils.strip("000000134_76539000","0"));
        String error = String.format("推送单据到财务云异常，type=%s, err=%s", "type.getName()", "error");
        System.out.println(error);
    }


}
