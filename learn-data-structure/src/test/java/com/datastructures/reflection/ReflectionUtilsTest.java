package com.datastructures.reflection;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class ReflectionUtilsTest {

    @Test
    public void testCreateObjectBasedOnDefaultConstructor() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object obj = ReflectionUtils.create(TestVo.class);
        assertNotNull(obj);

        assertEquals(TestVo.class, obj.getClass());
        TestVo testVo = (TestVo) obj;
        assertTrue(testVo.isCreated);
    }

    @Test
    public void testCallsMethodsWithoutParameters() throws IllegalAccessException, InvocationTargetException, IllegalMonitorStateException {

        TestVo testVo = new TestVo();
        assertFalse(testVo.method);
        ReflectionUtils.methodCallsMethodsWithoutParameters(testVo);
        assertTrue(testVo.method);

    }

    @Test
    public void testPrintAllMethodSignaturesThatContainFinal() {
        TestVo testVo = new TestVo();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            ReflectionUtils.methodPrintMethodSignatures(testVo);
            System.setOut(originalOut);
            String output = outContent.toString().trim();
            System.out.println(output);

            assertTrue(output.contains("methodWithFinalModifier1(int count, String string"),
                    "Must contain: methodWithFinalModifier1(int count, String string, not: " + output);
            assertTrue(output.contains("methodWithFinalModifier2(boolean True, double value"),
                    "Must contain: methodWithFinalModifier2(boolean True, double value, not:" + output);
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testPrintAllMethodsNonStaticModifier() {
        Class clazz = TestVo.class;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            ReflectionUtils.methodPrintNonPublicMethods(clazz);

            System.setOut(originalOut);
            String output = outContent.toString().trim();
            System.out.println("Non public methods:\n" + output);

            assertTrue(output.contains("methodNonPublic"), " Must contain methodNonPublic");
            assertTrue(output.contains("staticMethod"), "Must contain staticMethod");
            assertFalse(output.contains("publicMethod"), "Must contain publicMethod");
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testPrintsAllClassAncestorsAndAllInterfaces() {
        Class clazz = Chihuahua.class;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            ReflectionUtils.printsAllClassAncestorsAndAllInterfaces(clazz);
            System.setOut(originalOut);
            String output = outContent.toString().trim();
            System.out.println(" " + output);

            assertTrue(output.contains("Class: Chihuahua"));
            assertTrue(output.contains("Interface Chihuahua: Trained"));
            assertTrue(output.contains("Interface Chihuahua: Play"));
            assertTrue(output.contains("Class: Dog"));
            assertTrue(output.contains("Class: Animal"));
            assertTrue(output.contains("Class: Object"));

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testChangingPrivateFieldValuesInObject() throws IllegalAccessException {
        TestVo testVo = new TestVo();
        ReflectionUtils.changingPrivateFieldValues(testVo);
        assertEquals(null, testVo.getString());
        assertEquals(0, testVo.getSize());
        assertEquals(false, testVo.getIsBoolean());
        assertEquals(0L, testVo.getValue());
    }
}
