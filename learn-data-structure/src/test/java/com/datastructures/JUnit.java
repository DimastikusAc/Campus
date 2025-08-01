package com.datastructures;

import com.datastructures.list.ArrayList;
import com.datastructures.list.ArrayListTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class JUnit {
    public static void main(String[] args) throws Exception {
        runTests(ArrayListTest.class);              // Вызов метода runTests с классом ArrayListTest как аргумент
    }

    static void runTests(Class clazz) throws Exception {             // Метод runTests принимает объект типа Class (любой класс Java)
        Constructor constructor = clazz.getConstructor();
        Object testInstance = constructor.newInstance();

        ArrayList testMethods = getTests(clazz);
        for (int i = 0; i < testMethods.size(); i++) {
            Method testMethod = (Method) testMethods.get(i);
            System.out.println("Runing test" + testMethod.getName());
            try {
                testMethod.invoke(testInstance);
                System.out.println("Test: " + testMethod.getName() + " success");
            } catch (Throwable error) {
                System.err.println("Test: " + testMethod.getName() + " faild!");
                //error.printStackTrace();
            }

        }
    }

    private static ArrayList getTests(Class clazz) {
        ArrayList methodsList = new ArrayList();
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                methodsList.add(method);
            }
            
        }
        return methodsList;
    }
}
