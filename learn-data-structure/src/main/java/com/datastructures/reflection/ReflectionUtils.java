package com.datastructures.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.StringJoiner;

import static java.lang.reflect.AccessibleObject.setAccessible;

public class ReflectionUtils {
    // Метод принимает класс и возвращает созданный объект этого класса
    static Object create(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor constructor = clazz.getConstructor();
        Object result = constructor.newInstance();
        return result;
    }
    //Метод принимает object и вызывает у него все методы без параметров

    static void methodCallsMethodsWithoutParameters(Object object) throws InvocationTargetException, IllegalAccessException, IllegalMonitorStateException {
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.getParameterCount() == 0 && method.getDeclaringClass() == clazz) {
                method.invoke(object);
            }
        }
    }

    //Метод принимает object и выводит на экран все сигнатуры методов
    // в который есть final
    static void methodPrintMethodSignatures(Object object) {
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isFinal(method.getModifiers())) {

                StringJoiner stringJoinerParameter = new StringJoiner(", ", "(", ")");

                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    stringJoinerParameter.add(parameter.getType().getSimpleName() + " " + parameter.getName());
                }
                System.out.println(method.getName() + stringJoinerParameter.toString());
            }
        }
    }
    //Метод принимает Class и выводит все не публичные методы этого класса

    static void methodPrintNonPublicMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method.getName());
            }
        }
    }

    //Метод принимает Class и выводит всех предков класса и все интерфейсы
    // которое класс имплементирует

    static void printsAllClassAncestorsAndAllInterfaces(Class clazz) {

        Class superClass = clazz;
        while (superClass != null) {
            System.out.println("Class: " + superClass.getSimpleName());
            Class[] interfacesSuperClass = superClass.getInterfaces();
            for (Class interfaceItem : interfacesSuperClass) {
                System.out.println("Interface " + superClass.getSimpleName() + ": " + interfaceItem.getSimpleName());
            }
            superClass = superClass.getSuperclass();
        }
    }

    //Метод принимает объект и меняет всего его приватные поля
    // на их нулевые значение (null, 0, false etc)+

    public static void changingPrivateFieldValues(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers()) && field.getType() == int.class) {
                field.setAccessible(true);
                field.set(object, 0);
            } else if (Modifier.isPrivate(field.getModifiers()) && field.getType() == String.class) {
                field.setAccessible(true);
                field.set(object, null);
            } else if (Modifier.isPrivate(field.getModifiers()) && field.getType() == boolean.class) {
                field.setAccessible(true);
                field.set(object, false);
            } else if (Modifier.isPrivate(field.getModifiers()) && field.getType() == long.class) {
                field.setAccessible(true);
                field.set(object, 0L);
            }
        }
    }

}
