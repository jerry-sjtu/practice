package com.dcharm.loader;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by wangqiang on 2015/8/12.
 */
public class MyLoader  {
    public static void main(String[] args) throws Exception {
        IProvider provider = loadDefaultProvider();
        System.out.println(provider.toString());
    }

    @SuppressWarnings("unchecked")
    private static IProvider loadDefaultProvider() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = "com.dcharm.loader.MyProvider";
        Class<IProvider> providerClass = (Class<IProvider>)Thread.currentThread().getContextClassLoader().loadClass(className);
        IProvider provider = providerClass.getDeclaredConstructor().newInstance();
        provider.setName("hello");
        return provider;
    }
}
