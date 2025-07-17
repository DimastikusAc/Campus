package com.datastructures.queue;

public class ArrayQueue implements Queue{
    private int size;
    private int front;
    private int end;
    private Object[] array;

    public ArrayQueue() {
        array = new Object[2];
    }

    @Override
    public void enqueue(Object value) {
        ensureCapacity();
        array[end] = value;
        size++;
        end++;
    }

    private void ensureCapacity() {
        // Поскольку size может меняться из-за удаления и добавления, а end остается последним
        // значением, поэтом end:
        if (end == array.length){
            Object[] newArrayQueue = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArrayQueue[i] = array[i];
            }
            array = newArrayQueue;
        }
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        Object dequeue = array[front];
        array[front] = null; // Затираем ссылку на удаляемый объект в общем массиве...
        front++;
        size--;
        return dequeue;
    }

    @Override
    public Object peek() {
        return array[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = front; i < end; i++) {
            if(array[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[i] = null;
            }
        }
        size = 0;
        front = 0;
        end = 0;
    }

    @Override
    public String toString(){
        return "[" + array[0] + ", " + array[1] + ", " + array[2] + "]";
    }
}
