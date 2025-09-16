package com.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;


    @Override
    public void add(Object value) {
        add(value, size); // вставка в конец
    }

    @Override
    public void add(Object value, int index) {
        Node newNode = new Node(value);

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must be in the range from 0 to " + size);
        }

        if (size == 0) {
            head = tail = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = findNode(index);

            Node prevCurrent = current.prev;
            prevCurrent.next = newNode;
            newNode.prev = prevCurrent;
            current.prev = newNode;
            newNode.next = current;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("LinkedList is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index must be in the range from 0 to " + (size - 1));
        }

        Object removeValue;

        if (size == 1) {
            removeValue = head.value;
            head = tail = null;
        } else if (index == size - 1) {
            removeValue = tail.value;
            Node prev = tail.prev;
            tail.prev = null;
            prev.next = null;
            tail = prev;
        } else if (index == 0) {
            removeValue = head.value;
            Node next = head.next;
            head.next = null;
            next.prev = null;
            head = next;
        } else {
            Node current = findNode(index);

            removeValue = current.value;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return removeValue;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }

        return findNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        Object setValue;
        Node current = findNode(index);
        setValue = current.value;
        current.value = value;

        return setValue;
    }

    @Override
    public void clear() {
        head = tail = null;
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
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(current.value, value)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        for (int i = 0; i < size; i++) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        return stringJoiner.toString();
    }

    private Node findNode(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public Iterator iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator{
        Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Node thisCurrent = current;
            current = current.next;
            return thisCurrent.value;
        }
    }
}
