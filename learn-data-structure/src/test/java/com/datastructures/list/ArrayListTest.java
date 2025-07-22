package com.datastructures.list;

import com.datastructures.queue.ArrayQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @DisplayName(value = "test add and remove work correctly and update size")
    @Test
    public void testAddAndRemoveWorkCorrectlyAndChangeSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(3, arrayList.size());

        arrayList.remove(0);
        assertEquals("B", arrayList.get(0));
        assertEquals("C", arrayList.get(1));
        arrayList.remove(0);
        assertEquals("C", arrayList.get(0));
        assertEquals("C", arrayList.remove(0));
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @DisplayName(value = "test add at index updates size " +
            "and throws exception for invalid index")
    @Test
    public void testAddAtIndexUpdatesSizeAndThrowsExceptionForInvalidIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertEquals(3, arrayList.size());

        arrayList.add("D", 1);
        assertEquals(4, arrayList.size());
        assertEquals("D", arrayList.get(1));
        assertEquals("C", arrayList.get(3));

        assertThrows(IndexOutOfBoundsException.class, () ->{
            arrayList.add("E", 5);
        });
    }

    @DisplayName(value = "test add at index and Get value by index")
    @Test
    public void testAddAtIndexAndGetValueByIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertEquals(3, arrayList.size());

        assertEquals("C", arrayList.get(2));
        assertEquals("A", arrayList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () ->{
           arrayList.get(3);
        });
    }

    @DisplayName(value = "test add at index and Set new value by index")
    @Test
    public void testAddAtIndexAndSetNewValueByIndex(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertEquals(3, arrayList.size());

        arrayList.set("F", 1);
        assertEquals(3, arrayList.size());
        assertEquals("F", arrayList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () ->{
            arrayList.set("G", 3);
        });
    }

    @DisplayName(value = "test isEmpty returns true for new list")
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());
    }

    @DisplayName(value = "test isEmpty False on list with data")
    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        assertFalse(arrayList.isEmpty());
    }

    @DisplayName(value = "test isEmpty returns true on list after clear")
    @Test
    public void testIsEmptyReturnTrueOnListAfterClear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertEquals(3, arrayList.size());
        arrayList.clear();

        assertTrue(arrayList.isEmpty());
    }

    @DisplayName(value = "test contains returns True")
    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertTrue(arrayList.contains("B"));
    }

    @DisplayName(value = "test contains returns False")
    @Test
    public void testContainsReturnFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertFalse(arrayList.contains("D"));
    }

    @DisplayName(value = "test IndexOf returns correct index for existing element")
    @Test
    public void testIndexOfReturnsCorrectIndexForExistingElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        assertEquals(0, arrayList.indexOf("A"));
        assertEquals(-1, arrayList.indexOf("C"));
    }

    @DisplayName(value = "test LastIndexOf returns last occurrence index")
    @Test
    public void testLastIndexOfReturnsLastOccurrenceIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("A", 2);
        arrayList.add("D", 3);
        assertEquals(2, arrayList.lastIndexOf("A"));

    }

    @DisplayName(value = "test toString returns formatted list contents")
    @Test
    public void testToStringReturnsFormattedListContents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(3, arrayList.size());

        assertEquals("[A, B, C]", arrayList.toString());
    }

}
