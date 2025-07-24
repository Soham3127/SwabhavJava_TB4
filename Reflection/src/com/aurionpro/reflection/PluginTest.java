package com.aurionpro.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PluginTest {
    public static void main(String[] args) throws Exception {
       
        Class<?> cls = Plugin.class;

        Constructor<?> constructor = cls.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object pluginInstance = constructor.newInstance();

        Field versionField = cls.getDeclaredField("version");
        versionField.setAccessible(true);
        versionField.set(pluginInstance, 3.1);

        Method executeMethod = cls.getMethod("execute");
        executeMethod.invoke(pluginInstance);

        System.out.println("Version: " + versionField.get(pluginInstance));
    }
}
