package com.aurionpro.reflection;

import java.lang.reflect.Method;

public class HiddenOpsTest {
	public static void main(String[] args) throws Exception {

		HiddenOps ops = new HiddenOps();

		Class<?> cls = ops.getClass();

		//  private method
		Method method = cls.getDeclaredMethod("secretCode", String.class);
		method.setAccessible(true);

		Object result = method.invoke(ops, "hello");

		System.out.println("Reversed Output: " + result); 
	}
}
