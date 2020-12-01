package com.neo.designPatterns.bridge;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public abstract class Bridge {
    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
