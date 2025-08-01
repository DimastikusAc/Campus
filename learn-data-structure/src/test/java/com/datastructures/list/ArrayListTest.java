package com.datastructures.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @DisplayName("test add and remove work correctly and update size")
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

    @DisplayName("test add at index updates size")
    @Test
    public void testAddAtIndexUpdatesSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertEquals(3, arrayList.size());

        arrayList.add("D", 1);
        assertEquals(4, arrayList.size());
        assertEquals("D", arrayList.get(1));
        assertEquals("C", arrayList.get(3));
    }

    @DisplayName("test throw IndexOutOfBoundsException when index is less than zero")
    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenIndexIsLessThanZero() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        assertEquals(2, arrayList.size());
        assertThrows(IndexOutOfBoundsException.class, () ->{
            arrayList.add("C", -1);
        });
    }

    @DisplayName("test throw IndexOutOfBoundsException when index is greater than size")
    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenIndexIsGreaterThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0000000000);
        arrayList.add("B", 1);
        assertEquals(2, arrayList.size());

        assertThrows(IndexOutOfBoundsException.class, () ->{
            arrayList.add("E", 4);
        });
    }

    @DisplayName("test grow expands array when full")
    @Test
    public void testGrowExpandsArrayWhenFull() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            arrayList.add(i, i);
        }
        assertEquals(6, arrayList.size());

        arrayList.add(43, arrayList.size());
        assertEquals(7, arrayList.size());
    }


    @DisplayName("test add at index and Get value by index")
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

    @DisplayName("test add at index and Set new value by index")
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

    @DisplayName("test isEmpty returns true for new list")
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("test isEmpty False on list with data")
    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        assertFalse(arrayList.isEmpty());
    }

    @DisplayName("test isEmpty returns true on list after clear")
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

    @DisplayName("test contains returns True")
    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertTrue(arrayList.contains("B"));
    }

    @DisplayName("test contains returns False")
    @Test
    public void testContainsReturnFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("C", 2);
        assertFalse(arrayList.contains("D"));
    }

    @DisplayName("test IndexOf returns correct index for existing element")
    @Test
    public void testIndexOfReturnsCorrectIndexForExistingElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add(null, 2);
        assertEquals(0, arrayList.indexOf("A"));
        assertEquals(null, arrayList.get(2));
        assertEquals(-1, arrayList.indexOf("C"));
    }

    @DisplayName("test LastIndexOf returns last occurrence index")
    @Test
    public void testLastIndexOfReturnsLastOccurrenceIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A", 0);
        arrayList.add("B", 1);
        arrayList.add("A", 2);
        arrayList.add("D", 3);
        assertEquals(2, arrayList.lastIndexOf("A"));

    }

    @DisplayName("test toString returns formatted list contents")
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
