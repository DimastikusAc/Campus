package com.datastructures.list;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {
    private LinkedList list;

    @BeforeEach
    protected void setUp() {
        list = new LinkedList();
    }

    @DisplayName("test add and remove work correctly and update size")
    @Test
    public void testAddAndRemoveWorkCorrectlyAndChangeSize() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(3, list.size());

        list.remove(0);
        assertEquals("B", list.get(0));
        assertEquals("C", list.get(1));
        list.remove(0);
        assertEquals("C", list.get(0));
        assertEquals("C", list.remove(0));
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @DisplayName("test add at index updates size")
    @Test
    public void testAddAtIndexUpdatesSize() {
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        assertEquals(3, list.size());

        list.add("D", 1);
        assertEquals(4, list.size());
        assertEquals("D", list.get(1));
        assertEquals("C", list.get(3));
    }

    @DisplayName("test throw IndexOutOfBoundsException when index is less than zero")
    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenIndexIsLessThanZero() {
        list.add("A", 0);
        list.add("B", 1);
        assertEquals(2, list.size());
        assertThrows(IndexOutOfBoundsException.class, () ->{
            list.add("C", -1);
        });
    }

    @DisplayName("test throw IndexOutOfBoundsException when index is greater than size")
    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenIndexIsGreaterThanSize() {
        list.add("A", 0000000000);
        list.add("B", 1);
        assertEquals(2, list.size());

        assertThrows(IndexOutOfBoundsException.class, () ->{
            list.add("E", 4);
        });
    }

    @DisplayName("test grow expands array when full")
    @Test
    public void testGrowExpandsArrayWhenFull() {
        for (int i = 0; i < 6; i++) {
            list.add(i, i);
        }
        assertEquals(6, list.size());

        list.add(43, list.size());
        assertEquals(7, list.size());
    }


    @DisplayName("test add at index and Get value by index")
    @Test
    public void testAddAtIndexAndGetValueByIndex() {
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        assertEquals(3, list.size());

        assertEquals("C", list.get(2));
        assertEquals("A", list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () ->{
            list.get(3);
        });
    }

    @DisplayName("test add at index and Set new value by index")
    @Test
    public void testAddAtIndexAndSetNewValueByIndex(){
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        assertEquals(3, list.size());

        list.set("F", 1);
        assertEquals(3, list.size());
        assertEquals("F", list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () ->{
            list.set("G", 3);
        });
    }

    @DisplayName("test isEmpty returns true for new list")
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        assertTrue(list.isEmpty());
    }

    @DisplayName("test isEmpty False on list with data")
    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        list.add("A", 0);
        assertFalse(list.isEmpty());
    }

    @DisplayName("test isEmpty returns true on list after clear")
    @Test
    public void testIsEmptyReturnTrueOnListAfterClear() {
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        assertEquals(3, list.size());
        list.clear();

        assertTrue(list.isEmpty());
    }

    @DisplayName("test contains returns True")
    @Test
    public void testContainsReturnTrue() {
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        assertTrue(list.contains("B"));
    }

    @DisplayName("test contains returns False")
    @Test
    public void testContainsReturnFalse() {
        list.add("A", 0);
        list.add("B", 1);
        list.add("C", 2);
        assertFalse(list.contains("D"));
    }

    @DisplayName("test IndexOf returns correct index for existing element")
    @Test
    public void testIndexOfReturnsCorrectIndexForExistingElement() {
        list.add("A", 0);
        list.add("B", 1);
        list.add(null, 2);
        assertEquals(0, list.indexOf("A"));
        assertEquals(null, list.get(2));
        assertEquals(-1, list.indexOf("C"));
    }

    @DisplayName("test LastIndexOf returns last occurrence index")
    @Test
    public void testLastIndexOfReturnsLastOccurrenceIndex() {
        list.add("A", 0);
        list.add("B", 1);
        list.add("A", 2);
        list.add("D", 3);
        assertEquals(2, list.lastIndexOf("A"));

    }

    @DisplayName("test toString returns formatted list contents")
    @Test
    public void testToStringReturnsFormattedListContents() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(3, list.size());

        assertEquals("[A, B, C]", list.toString());
    }
}
