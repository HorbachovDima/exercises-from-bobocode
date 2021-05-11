package com.practice.impl;

public interface List<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    int size();

}
