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
}
