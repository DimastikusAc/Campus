package com.datastructures.stack;

public interface Stack {

    void push(Object value);

    Object pop();

    Object peek(); // Заглянуть. Возвращает значение, но не достает из Stack

    boolean contains(Object value); // Содержит

    int size();

    boolean isEmpty(); // Пустой

    void clear();
}
