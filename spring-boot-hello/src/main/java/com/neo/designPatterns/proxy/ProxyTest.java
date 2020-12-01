package com.neo.designPatterns.proxy;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }

}
