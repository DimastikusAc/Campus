package com.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {
    private LinkedQueue queue;

    @BeforeEach
    protected void setUp() {
        queue = new LinkedQueue();
    }

    @DisplayName(value = "test Enqueue and Dequeue work correctly and change Size")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals(3, queue.size());

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @DisplayName(value = "test Enqueue over initial Capacity and Dequeue " +
            "work correctly and change Size")
    @Test
    public void testEnqueueOverInitialCapacityAndDequeueWorkCorrectlyAndChangeSize() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals(3, queue.size());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @DisplayName(value = "test Contains returns True for null value")
    @Test
    public void testContainsReturnsTrueForNullValue () {
        
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue(null);
        queue.enqueue("C");
        assertEquals(4, queue.size());
        assertTrue(queue.contains(null));

    }

    @DisplayName(value = "test Enqueue and Peek")
    @Test
    public void testEnqueueAndPeek() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.size());
        assertEquals("A", queue.peek());
    }

    @DisplayName(value = "test isEmpty return True on new queue")
    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        assertTrue(queue.isEmpty());
    }

    @DisplayName(value = "test isEmpty False on queue with data")
    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        queue.enqueue("A");
        assertFalse(queue.isEmpty());
    }

    @DisplayName(value = "test isEmpty return True on queue" +
            "after clear")
    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.size());

        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @DisplayName(value = "test Contains return True")
    @Test
    public void testContainsReturnTrue() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("D");

        assertTrue(queue.contains("B"));
    }

    @DisplayName(value = "test Contains return False")
    @Test
    public void testContainsReturnFalse() {
        queue.enqueue("A");
        queue.enqueue("B");

        assertFalse(queue.contains("C"));
    }

    @DisplayName(value = "test Contains return False on empty queue")
    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        assertFalse(queue.contains("C"));
    }

    @DisplayName(value = "test trow IllegalStateException when" +
            "dequeue on empty queue")
    @Test
    public void testTrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });
    }

    @DisplayName(value = "test toString returns formatted queue contents")
    @Test
    public void testToStringReturnsFormattedQueueContents() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals(3, queue.size());

        assertEquals("[A, B, C]", queue.toString());
    }
}
