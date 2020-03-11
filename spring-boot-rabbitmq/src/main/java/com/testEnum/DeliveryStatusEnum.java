package com.testEnum;

import java.util.HashMap;

/**
 * 发货状态枚举
 *
 * @author u
 * @version 1.0
 */
public enum DeliveryStatusEnum {
//	NOTDELIVER("未发货", (short)0,"unaudit"),
//	DELIVERING("已发货", (short)1,"audit"),
//	DELIVERED("已收货", (short)2,"");

    DELIVERUNAUDITED("发货待审", (short)0,"unaudit"),
    DELIVERING("发货已审", (short)1,"audit"),
    OUTSTOCKED("已出库", (short)2,"outStock"),
    DELIVERED("已收货", (short)3,""),
    OUTSTOCKEDROLLBACK("出库回退", (short)4,"");

    private String caption;
    private short value;
    private String action;

    private DeliveryStatusEnum(String caption, short value, String action) {
        this.caption = caption;
        this.value = value;
        this.action=action;
    }

    public String getName() {
        return name();
    }

    public String getCaption() {
        return caption;
    }

    public short getValue() {
        return value;
    }

    public String getAction() {
        return action;
    }

    private static HashMap<String, DeliveryStatusEnum> map = null;

    private synchronized static void initMap() {
        if (map != null) {
            return;
        }
        map = new HashMap<String, DeliveryStatusEnum>();
        DeliveryStatusEnum[] items = DeliveryStatusEnum.values();
        for (DeliveryStatusEnum item : items) {
            map.put(item.getAction(), item);
        }
    }

    public static DeliveryStatusEnum find(String action) {
        if (action == null) {
            return null;
        }
        if (map == null) {
            initMap();
        }
        return map.get(action);
    }


    public static void main(String[] args) {
        String action = DeliveryStatusEnum.DELIVERUNAUDITED.getAction();
        System.out.println(action);
        String name = DeliveryStatusEnum.DELIVERING.name();
        System.out.println(name);
        DeliveryStatusEnum deliverunaudited = DeliveryStatusEnum.find("audit");
        DeliveryStatusEnum[] values = DeliveryStatusEnum.values();

    }


}
