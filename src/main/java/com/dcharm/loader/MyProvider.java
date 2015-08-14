package com.dcharm.loader;

/**
 * Created by wangqiang on 2015/8/12.
 */
public class MyProvider implements IProvider {
    private String name;

    public MyProvider() {}

    public MyProvider(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProvider{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
