package com.datastructures.list;


import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;


    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if(size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
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
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
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
            throw new IndexOutOfBoundsException("index must be in the range from 0 to " + size);
        }

        Object removeValue;

        if(size == 1) {
            removeValue = head.value;
            head = tail = null;
        } else if (index == size - 1) {
            removeValue = tail.value;
            Node prev = tail.prev;
            tail.prev = null;
            prev.next = null;
            tail = prev;
        } else if (index == 0 ) {
            removeValue = head.value;
            Node next = head.next;
            head.next = null;
            next.prev = null;
            head = next;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            removeValue = current.value;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size --;
        return removeValue;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public Object set(Object value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        Object setValue;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
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
            if(Objects.equals(current.value, value)){
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
            if(Objects.equals(current.value, value)){
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
            if(Objects.equals(current.value, value)){
                return i;
            }
            current = current.prev;
        }
        return -1;
    }
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        for (int i = 0; i < size; i++) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        return stringJoiner.toString();
    }
}
