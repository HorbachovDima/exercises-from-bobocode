package com.practice.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LinkedListTest {

    private List<Integer> list = new MyLinkedList<>();

    @Test
    void addIntoEmptyList() {
        list.add(41);
        int element = list.get(0);
        assertThat(element).isEqualTo(41);
    }

    @Test
    void getFirstElementFromSingleElementList() {
        list.add(23);
        int element = list.get(0);
        assertThat(element).isEqualTo(23);
    }

    @Test
    void addElements() {
        list = MyLinkedList.of(33, 23, 44);
        assertThat(list.get(0)).isEqualTo(33);
        assertThat(list.get(1)).isEqualTo(23);
        assertThat(list.get(2)).isEqualTo(44);

        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void size() {
        list = MyLinkedList.of(1, 2, 3, 4, 5, 6);
        int size = list.size();
        assertThat(size).isEqualTo(6);
    }

    @Test
    void getFirstElement() {
        list = MyLinkedList.of(22, 100);
        int firstElement = list.getFirst();
        assertThat(firstElement).isEqualTo(22);
    }

    @Test
    void getLastElement() {
        list = MyLinkedList.of(123, 222);
        int lastElement = list.getLast();
        assertThat(lastElement).isEqualTo(222);
    }
}
