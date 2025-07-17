package com.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @DisplayName(value = "test Enqueue and Dequeue work correctly and changeSize")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        assertEquals(3, arrayQueue.size());

        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("C", arrayQueue.dequeue());
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName(value = "test Enqueue over initial Capacity and Dequeue " +
            "work correctly and change Size")
    @Test
    public void testEnqueueOverInitialCapacityAndDequeueWorkCorrectlyAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        assertEquals(3, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals("C", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName(value = "test Contains returns True for null value")
    @Test
    public void testContainsReturnsTrueForNullValue () {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue(null);
        arrayQueue.enqueue("C");
        assertEquals(4, arrayQueue.size());
        assertTrue(arrayQueue.contains(null));

    }

    @DisplayName(value = "test Enqueue and Peek")
    @Test
    public void testEnqueueAndPeek() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertEquals(2, arrayQueue.size());
        assertEquals("A", arrayQueue.peek());
        assertEquals("A", arrayQueue.peek());
        assertEquals(2, arrayQueue.size());
    }

    @DisplayName(value = "test isEmpty return True on new queue")
    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName(value = "test isEmpty False on queue with data")
    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        assertFalse(arrayQueue.isEmpty());
    }

    @DisplayName(value = "test isEmpty return True on queue" +
            "after clear")
    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertEquals(2, arrayQueue.size());

        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }

    @DisplayName(value = "test Contains return True")
    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("D");

        assertTrue(arrayQueue.contains("B"));
    }

    @DisplayName(value = "test Contains return False")
    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertFalse(arrayQueue.contains("C"));
    }

    @DisplayName(value = "test Contains return False on empty queue")
    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertFalse(arrayQueue.contains("C"));
    }

    @DisplayName(value = "test trow IllegalStateException when" +
            "dequeue on empty queue")
    @Test
    public void testTrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }

    @DisplayName(value = "test toString returns formatted queue contents")
    @Test
    public void testToStringReturnsFormattedQueueContents() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        assertEquals(3, arrayQueue.size());

        assertEquals("[A, B, C]", arrayQueue.toString());
    }
}
