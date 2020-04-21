package com.rabbit.rabbit.ACK;


public class MessageObj {

    private Boolean ACK;
    private int id;
    private String name;
    private String value;


    public MessageObj() {
    }

    public MessageObj(Boolean ACK, int id, String name, String value) {
        this.ACK = ACK;
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Boolean getACK() {
        return ACK;
    }

    public void setACK(Boolean ACK) {
        this.ACK = ACK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MessageObj{" +
                "ACK=" + ACK +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
