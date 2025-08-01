package com.datastructures.reflection;

public class TestVo {
    boolean isCreated = true;
    boolean method = false;
    private String string = "Hello!";
    private int size = 5;
    private boolean isBoolean = true;
    private long value = 256L;

    public String getString() {
        return string;
    }

    public int getSize() {
        return size;
    }

    public boolean getIsBoolean() {
        return isBoolean;
    }

    public long getValue() {
        return value;
    }

    public TestVo() {
        System.out.println("Object is created");
    }

    public void methodInvoke1() {
        method = true;
        System.out.println("This is the first method without parameters.");
    }

    public void methodInvoke2() {
        method = true;
        System.out.println("This is the second method without parameters.");
    }

    public void methodWithParameters(int value) {
        System.out.println("This is method with parameters/");
    }

    public final void methodWithFinalModifier1(int count, String string) {

        System.out.println("This is the first method with final modifier.");
    }

    public final void methodWithFinalModifier2(boolean True, double value) {

        System.out.println("This is the first method with final modifier.");
    }

    void methodNonPublic(int count) {

        System.out.println("This is not a public method.");
    }

    static void staticMethod() {
        System.out.println("This is not a public method. This is static method.");
    }
}
