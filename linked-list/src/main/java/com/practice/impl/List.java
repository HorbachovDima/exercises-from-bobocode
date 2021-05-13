package com.practice.impl;

public interface List<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    int size();

    T getFirst();

    T getLast();

    void set(int index, T element);

    T remove(int index);

    boolean contains(T element);

    boolean isEmpty();

    void clear();
}
