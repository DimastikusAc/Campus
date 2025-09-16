package com.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList implements List{
    private static final int DEFAULT_INITIAL_CAPACITY = 6;

    private Object[] array;
    private int size;

    public ArrayList() {

        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int capacity){
        this.array = new Object[capacity];
    }

    @Override
    public void add(Object value) {
        ensureGrow();
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
        }

        ensureGrow();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        Object removeObject = array[index];

        System.arraycopy(array, index + 1, array, index, size - index - 1);

        array[size - 1] = null;
        size--;
        return removeObject;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        Object oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
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
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if ((value == null && array[i] == null) || (value != null && value.equals(array[i]))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if ((value == null && array[i] == null) || (value != null && value.equals(array[i]))) {
                return i;
            }
        }
        return - 1;
    }

    // [A, B, C]
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        for (int i = 0; i < size; i++) {
          stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }

    private void ensureGrow() {
        if (size == array.length) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }


    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Object nextObject = array[index];
            index ++;
            return nextObject;
        }
    }
}
