package com.neo.designPatterns.adapter.objectAdapter;

import com.neo.designPatterns.adapter.Source;
import com.neo.designPatterns.adapter.Targetable;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class AdapterTest {

    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}
