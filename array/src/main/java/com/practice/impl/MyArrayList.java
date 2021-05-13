package com.practice.impl;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class MyArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementData;
    private int size;

    public MyArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elementData = new Object[initCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public static <T> MyArrayList<T> of(T... elements) {
        MyArrayList<T> arrayList = new MyArrayList<>();
        Stream.of(elements).forEach(arrayList::add);
        return arrayList;
    }

    @Override
    public void add(T element) {
        Objects.requireNonNull(element);
        increaseIfFull();
        elementData[size] = element;
        size++;
    }

    private void increaseIfFull() {
        if (elementData.length == size) {
            elementData = Arrays.copyOf(elementData, size * 2);
        }
    }

    @Override
    public void add(int index, T element) {
        increaseIfFull();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) elementData[0];
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) elementData[size - 1];
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }
}
