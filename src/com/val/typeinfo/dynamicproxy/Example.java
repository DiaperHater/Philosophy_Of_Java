package com.val.typeinfo.dynamicproxy;

import java.lang.reflect.Proxy;

public class Example {
    public static void main(String[] args) {
        Name name = new Name("Elmo mc Elroy");
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Name.class.getClassLoader(),
                Name.class.getInterfaces(),
                new MyInvocationHandler(name)
        );

        System.out.println(proxy.getName());
        proxy.setName("Donald", "Trump");
        System.out.println(name.getName());

    }
}
