package com.aurionpro.reflection;

import java.lang.reflect.Method;

public class MathUtilTest {
	public static void main(String[] args) throws Exception {

		MathUtil mathUtil = new MathUtil();

		Class<?> cls = mathUtil.getClass();

		Method method = cls.getMethod("square", int.class);

		Object result = method.invoke(mathUtil, 5);

		System.out.println("Result: " + result); 
	}
}
