package com.BigDecimal;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

public class UtilBigDecimal {

    /**
     * 中信银行 软件开发中心 @2017
     * 单位转换工具类<p/>
     * 作者: wzk
     * 创建时间: 2017-09-02 23:43
     */
    @Component
    public class UnitTransitionUtils {


        //将科学计数法的数字转换成普通计数法
        public String scienceToSimple(String number) {
            BigDecimal bd=new BigDecimal(number);
            return bd.toPlainString();
        }

        /**
         * 中信银行 软件开发中心
         * 作者: wzk
         * 创建时间: 2017/10/17  9:22
         * 对字符串类型的数字进行处理,保留两位小数
         */
        public String getNumber(String number){
            DecimalFormat df=null;
            if("".equals(number)||number==null){
                return "0.00";
            }else if(Double.parseDouble(number)==0){
                return "0.00";
            }else if(Double.parseDouble(number)>=1){
                df = new DecimalFormat("#.00");
                return df.format(new BigDecimal(number)).toString();
            }else if(Double.parseDouble(number)<1){
                df = new DecimalFormat("0.00");
            }
            return df.format(new BigDecimal(number)).toString();
        }

        /**
         * 中信银行 软件开发中心
         * 作者: wzk
         * 创建时间: 2017/9/2  23:44
         * 将小数转换成百分数
         */
        public String stringToPct(String number){
            if(null==number||"".equals(number)||Double.parseDouble(number)==0){
                return "0.00%";
            }
            DecimalFormat df=new DecimalFormat("0.00%");
            BigDecimal d=new BigDecimal(number);
            return df.format(d);
        }

        /**
         * 中信银行 软件开发中心
         * 作者: wzk
         * 创建时间: 2017/9/2  23:44
         * 对数据处理，保留两位小数,不做其他处理
         */
        public String stringToPctTwo(String number){
            if(null==number||"".equals(number)||Double.parseDouble(number)==0){
                return "0.00";
            }
            DecimalFormat df=new DecimalFormat("0.00");
            BigDecimal d=new BigDecimal(number);
            return df.format(d);
        }

        /**
         * 中信银行 软件开发中心
         * 作者: wzk
         * 创建时间: 2017/9/21  11:22
         * 小数乘以100,并保留两位小数
         */
        public String pctDispose(String number){
            DecimalFormat df=new DecimalFormat("0.00");
            BigDecimal d=new BigDecimal(number);
            d=d.multiply(new BigDecimal(100));
            return df.format(d);
        }

        /**
         * 金额单位转换的方法，根据输入的单位来转换单位变换之后的数字
         * @param amount  金额
         * @param originalUnits   原始单位
         * @param futureUnits     转换后单位
         * @param scale     保留几位小数取舍
         * @return
         */
        public String changeMoneyUnit (String amount,String originalUnits,String futureUnits,int scale,RoundingMode roundingMode) {
            if (null==amount||"".equals(amount)||Double.parseDouble(amount)==0) {
                return "0.00";
            }
            BigDecimal indexVal = new BigDecimal(amount);
            BigDecimal amountout = changeMoneyUnit(indexVal,originalUnits,futureUnits,scale,roundingMode);
            return amountout.toString();
        }

        /**
         * 金额单位转换的方法，根据输入的单位来转换单位变换之后的数字(入参出参都是String)
         * @param amount  金额
         * @param originalUnits   原始单位
         * @param futureUnits     转换后单位
         * @param scale     保留几位小数取舍
         * @return
         */
        public String changeMoneyUnit (String amount,String originalUnits,String futureUnits,int scale) {
            if (null==amount||"".equals(amount)||Double.parseDouble(amount)==0) {
                return "0.00";
            }
            BigDecimal indexVal = new BigDecimal(amount);
            BigDecimal amountout = changeMoneyUnit(indexVal,originalUnits,futureUnits,scale,RoundingMode.HALF_UP);
            return amountout.toString();
        }

        /**
         * 金额单位转换的方法，根据输入的单位来转换单位变换之后的数字(入参出参都是Integer)
         * @param amount  金额
         * @param originalUnits   原始单位
         * @param futureUnits     转换后单位
         * @param scale     保留几位小数取舍
         * @return
         */
        public Integer changeMoneyUnit (Integer amount,String originalUnits,String futureUnits,int scale) {
            if (null==amount||0==amount) {
                return 0;
            }
            BigDecimal indexVal = new BigDecimal(amount);
            BigDecimal amountout = changeMoneyUnit(indexVal,originalUnits,futureUnits,scale,RoundingMode.HALF_UP);
            return amountout.intValue();
        }

        /**
         * 金额单位转换的方法，根据输入的单位来转换单位变换之后的数字(入参出参都是Integer)
         * @param amount  金额
         * @param originalUnits   原始单位
         * @param futureUnits     转换后单位
         * @param scale     保留几位小数取舍
         * @return
         */
        public Double changeMoneyUnit (Object amount,String originalUnits,String futureUnits,int scale) {
            if (null==amount||0==(int)amount) {
                return 0.00;
            }
            BigDecimal indexVal = new BigDecimal(amount.toString());
            BigDecimal amountout = changeMoneyUnit(indexVal,originalUnits,futureUnits,scale,RoundingMode.HALF_UP);
            return amountout.doubleValue();
        }

        /**
         * 金额单位转换的方法，根据输入的单位来转换单位变换之后的数字
         * @param amount  金额
         * @param originalUnits   原始单位
         * @param futureUnits     转换后单位
         * @param scale     保留几位小数取舍
         * @return
         */
        public BigDecimal changeMoneyUnit (BigDecimal amount, String originalUnits, String futureUnits, int scale, RoundingMode roundingMode) {
            if (null==amount||0==amount.intValue()) {
                return new BigDecimal(0);
            }
            HashMap<String,Integer> unitsMap = new HashMap();
            unitsMap.put("元",1);
            unitsMap.put("十元",10);
            unitsMap.put("百元",100);
            unitsMap.put("千元",1000);
            unitsMap.put("万元",10000);
            unitsMap.put("百万元",1000000);
            unitsMap.put("亿元",100000000);
            BigDecimal steps = new BigDecimal(unitsMap.get(futureUnits)/unitsMap.get(originalUnits));
            BigDecimal amountout = amount.divide(steps,scale,roundingMode);
            return amountout;
        }
    }
}
