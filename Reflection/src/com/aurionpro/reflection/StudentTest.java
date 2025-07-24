package com.aurionpro.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StudentTest {
    private static final Object student = null;
	private static final Object Student = null;

	public static void main(String[] args) {

        // Get the Class object of Student class
        Class<?> c = Student.class;

        System.out.println("Class Name: " + c.getName());

        // Fields
        System.out.println("\nFields are: ");
        Field[] fields = c.getDeclaredFields(); // ❌ FIX: getDeclaredField() → ✅ getDeclaredFields()
        for (Field field : fields) {
            System.out.println("Field: " + field.getName() +
                               ", Type: " + field.getType().getSimpleName() +
                               ", Modifier: " + Modifier.toString(field.getModifiers()));
        }

        // Methods
        System.out.println("\nMethods are: ");
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            System.out.println("  Return Type: " + method.getReturnType().getSimpleName());
            System.out.println("  Modifiers: " + Modifier.toString(method.getModifiers()));
        }

        // Constructors
        System.out.println("\nConstructors are: ");
        Constructor<?>[] constructors = c.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName().substring(constructor.getName().lastIndexOf(".") + 1));
        }
        
        
        Field fields1= c.getDeclaredField("cgpa");
        
        fields1.setAccessible(true);
        System.out.println("cgpa is " + fields1.get(Student));
        
        
        Method method= c.getDeclaredMethods("greet");
        method.setAccessible(true);
        method.invoke(student);
        
        field.set(student, 8.9);
        System.out.println("Updated cgpa: " + field.get(student));
        
        
        
        
        
        
    }
}
