package com.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
    ArrayStack arrayStack;
    
    @BeforeEach
    public void before(){
        arrayStack = new ArrayStack();
    }
    @Test
    public void testPushAndPopWorkCorrectlyAndChangeSize() {
        arrayStack.push("A");
        arrayStack.push("B");

        assertEquals(2, arrayStack.size()); //утверждение о равенстве
        assertEquals("B", arrayStack.pop());
        assertEquals("A", arrayStack.pop());
        assertEquals(0, arrayStack.size());

        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testPushOverInitialCapacityAndPopWorkCorrectlyAndChangeSize() {
        arrayStack = new ArrayStack(2);
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");

        assertEquals(3, arrayStack.size());
        assertEquals("C", arrayStack.pop());
        assertEquals("B", arrayStack.pop());
        assertEquals("A", arrayStack.pop());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testPushAndPeek() {
        
        arrayStack.push("A");
        arrayStack.push("B");

        assertEquals(2, arrayStack.size());
        assertEquals("B", arrayStack.peek());
        assertEquals("B", arrayStack.peek());
        assertEquals(2, arrayStack.size());
    }

    @Test
    public void testIsEmptyReturnTrueOnNewStack() {
        
        assertTrue(arrayStack.isEmpty());
    }
    @Test
    public void testIsEmptyReturnFalseOnStackWithData() {
        
        arrayStack.push("A");
        arrayStack.push("B");
        assertFalse(arrayStack.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.clear();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        
        arrayStack.push("A");
        arrayStack.push("B");
        assertTrue(arrayStack.contains(new String("A")));

    }

    @Test
    public void testContainsReturnFalse() {
        
        arrayStack.push("A");
        arrayStack.push("B");
        assertFalse(arrayStack.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyStack() {
        
        assertFalse(arrayStack.contains("C"));
    }

    @Test
    public void testThrowIllegalStateExceptionPopOnEmptyStack() {
        
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayStack.pop();
        });
    }

    @Test
    public void testStackIteratorImplementation(){
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");
        assertEquals(3, arrayStack.size());

        Iterator iterator = arrayStack.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());

        assertFalse(iterator.hasNext());

        while (iterator.hasNext()){
            Object nextValue = iterator.next();
            System.out.println(nextValue);
        }

    }
}
