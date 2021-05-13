package com.practice.impl;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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

    @Test
    void getFirstOnEmptyList() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> list.getFirst());
    }

    @Test
    void getLastOnEmptyList() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> list.getLast());
    }

    @Test
    void getElements() {
        list = MyLinkedList.of(1, 2, 3);
        int firstElement = list.get(0);
        int secondElement = list.get(1);
        int thirdElement = list.get(2);

        assertThat(firstElement).isEqualTo(1);
        assertThat(secondElement).isEqualTo(2);
        assertThat(thirdElement).isEqualTo(3);
    }

    @Test
    void addElementByZeroIndexIntoEmptyList() {
        list.add(0, 23);
        int element = list.getFirst();
        assertThat(element).isEqualTo(23);
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void addElementByIndexToTheEndOfList() {
        list = MyLinkedList.of(23, 321, 432, 54);
        int indexForNewElement = list.size();
        list.add(indexForNewElement, 123);
        assertThat(list.get(indexForNewElement)).isEqualTo(123);
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    void addElementToTheHeadOfNonEmptyList() {
        list = MyLinkedList.of(23, 321, 432, 54);
        list.add(0, 99);
        assertThat(list.get(0)).isEqualTo(99);
        assertThat(list.get(1)).isEqualTo(23);
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    void addElementByIndex() {
        list = MyLinkedList.of(23, 321, 432, 54);
        int index = 2;
        list.add(index, 555);
        assertThat(list.get(index)).isEqualTo(555);
        assertThat(list.get(0)).isEqualTo(23);
        assertThat(list.get(1)).isEqualTo(321);
        assertThat(list.get(3)).isEqualTo(432);
        assertThat(list.get(4)).isEqualTo(54);
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    void addElementByNegativeIndex() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.add(-1, 23));
    }

    @Test
    void addElementByIndexLargerThanListSize() {
        list = MyLinkedList.of(23, 321, 432, 54);
        int index = 5;
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.add(index, 1));
    }

    @Test
    void addElementByIndexEqualsToSize() {
        list = MyLinkedList.of(1, 2, 3, 4, 5);
        list.add(list.size(), 6);
        int lastElement = list.get(5);
        assertThat(lastElement).isEqualTo(6);
        assertThat(list.size()).isEqualTo(6);
    }

    @Test
    void setFirstElementOnEmptyTree() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.set(0, 23));
    }

    @Test
    void setElementByIndexEqualsToSize() {
        list = MyLinkedList.of(4, 5, 6, 7);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.set(list.size(), 8));
    }

    @Test
    void setElementByIndex() {
        list = MyLinkedList.of(23, 44, 55, 234, 124);
        int index = 3;
        list.set(index, 2);
        assertThat(list.get(index)).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo(23);
        assertThat(list.get(1)).isEqualTo(44);
        assertThat(list.get(2)).isEqualTo(55);
        assertThat(list.get(4)).isEqualTo(124);
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    void getFirstElementFromEmptyList() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.get(0));
    }

    @Test
    void getElementByNegativeIndex() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.get(-1));
    }

    @Test
    void getElementByIndexEqualsToSize() {
        list = MyLinkedList.of(1, 2, 3, 4);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.get(list.size()));
    }

    @Test
    void removeElementFromEmptyList() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.remove(33));
    }

    @Test
    void removeFirstElement() {
        list = MyLinkedList.of(1, 2, 3, 4);
        int removedElement = list.remove(0);
        assertThat(list.get(0)).isEqualTo(2);
        assertThat(removedElement).isEqualTo(1);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void removeLastElement() {
        list = MyLinkedList.of(1, 2, 3, 4);
        int deletedElement = list.remove(list.size() - 1);
        assertThat(list.get(list.size() - 1)).isEqualTo(3);
        assertThat(deletedElement).isEqualTo(4);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void removeElement() {
        list = MyLinkedList.of(1, 2, 3, 4);
        int removedElement = list.remove(2);
        assertThat(list.get(2)).isEqualTo(4);
        assertThat(removedElement).isEqualTo(3);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void containsOnEmptyList() {
        boolean isContains = list.contains(33);
        assertThat(isContains).isFalse();
    }

    @Test
    void contains() {
        list = MyLinkedList.of(1, 2, 3, 4);
        boolean existingElement = list.contains(3);
        boolean notExistingElement = list.contains(33);
        assertThat(existingElement).isTrue();
        assertThat(notExistingElement).isFalse();
    }

    @Test
    void isEmptyOnEmptyList() {
        boolean isEmpty = list.isEmpty();
        assertThat(isEmpty).isTrue();
    }

    @Test
    void isEmpty() {
        list = MyLinkedList.of(1, 2, 3, 4);
        boolean isEmpty = list.isEmpty();
        assertThat(isEmpty).isFalse();
    }

    @Test
    void clearOnEmptyList() {
        list.clear();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void clearOnNonEmptyList() {
        list = MyLinkedList.of(1, 2, 3, 4);
        list.clear();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void clearRemoveElements() {
        list = MyLinkedList.of(1, 2, 3, 4);
        list.clear();
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.get(0));
    }
}
