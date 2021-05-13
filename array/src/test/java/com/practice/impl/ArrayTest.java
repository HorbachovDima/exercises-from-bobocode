package com.practice.impl;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class ArrayTest {

    private List<Integer> array = new MyArrayList<>();

    @Test
    void addIntoEmptyArray() {
        array.add(22);
        int element = array.get(0);
        assertThat(element).isEqualTo(22);
        assertThat(array.size()).isEqualTo(1);
    }

    @Test
    void addElements() {
        array = MyArrayList.of(1, 2, 3, 4, 5);
        assertThat(array.get(0)).isEqualTo(1);
        assertThat(array.get(1)).isEqualTo(2);
        assertThat(array.get(2)).isEqualTo(3);
        assertThat(array.get(3)).isEqualTo(4);
        assertThat(array.get(4)).isEqualTo(5);

        assertThat(array.size()).isEqualTo(5);
    }

    @Test
    void size() {
        array = MyArrayList.of(1, 2, 3, 4, 5);
        int size = array.size();
        assertThat(size).isEqualTo(5);
    }

    @Test
    void getFirstElement() {
        array = MyArrayList.of(1, 2, 3, 4, 5);
        int firstElement = array.getFirst();
        assertThat(firstElement).isEqualTo(1);
    }

    @Test
    void getLastElement() {
        array = MyArrayList.of(1, 2, 3, 4);
        int lastElement = array.getLast();
        assertThat(lastElement).isEqualTo(4);
    }

    @Test
    void getFirstOnEmptyArray() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> array.getFirst());
    }

    @Test
    void getLastOnEmptyArray() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> array.getLast());
    }

    @Test
    void getElements() {
        array = MyArrayList.of(1, 2, 3);
        int firstElement = array.get(0);
        int secondElement = array.get(1);
        int thirdElement = array.get(2);
        assertThat(firstElement).isEqualTo(1);
        assertThat(secondElement).isEqualTo(2);
        assertThat(thirdElement).isEqualTo(3);
    }

    @Test
    void addElementByZeroIntoEmptyArray() {
        array.add(0, 123);
        int element = array.get(0);
        assertThat(element).isEqualTo(123);
        assertThat(array.size()).isEqualTo(1);
    }

    @Test
    void addElementByIndexToTheEndOfTheArray() {
        array = MyArrayList.of(1, 2, 3);
        int indexForNewElement = array.size();
        array.add(indexForNewElement, 123);

        assertThat(array.get(indexForNewElement)).isEqualTo(123);
        assertThat(array.size()).isEqualTo(4);
    }

    @Test
    void addFirstElementToTheNonEmptyArray() {
        array = MyArrayList.of(1, 2, 3);
        array.add(0, 123);
        assertThat(array.getFirst()).isEqualTo(123);
        assertThat(array.get(1)).isEqualTo(1);
        assertThat(array.size()).isEqualTo(4);
    }

    @Test
    void addElementByIndex() {
        array = MyArrayList.of(1, 2, 3, 4);
        int indexForNewElement = 2;
        array.add(indexForNewElement, 1234);
        assertThat(array.get(indexForNewElement)).isEqualTo(1234);
        assertThat(array.get(0)).isEqualTo(1);
        assertThat(array.get(1)).isEqualTo(2);
        assertThat(array.get(3)).isEqualTo(3);
        assertThat(array.get(4)).isEqualTo(4);

        assertThat(array.size()).isEqualTo(5);
    }

    @Test
    void addElementByNegativeIndex() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> array.add(-1, 12314));
    }
}
