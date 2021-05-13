package com.practice.impl;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class MyLinkedList<T> implements List<T> {

    static final class Node<T> {
        T element;
        Node<T> next;

        private Node(T element) {
            this.element = element;
        }

        public static <T> Node<T> valueOf(T element) {
            return new Node<>(element);
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public static <T> List<T> of(T... elements) {
        List<T> list = new MyLinkedList<>();
        Stream.of(elements).forEach(list::add);
        return list;
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        Objects.requireNonNull(element);
        Node<T> newNode = Node.valueOf(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (head.next == null) {
                tail = head;
            }
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<T> previousNode = findNodeByIndex(index - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return findNodeByIndex(index).element;
    }

    private Node<T> findNodeByIndex(int index) {
        Objects.checkIndex(index, size);
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        isExist();
        return head.element;
    }

    @Override
    public T getLast() {
        isExist();
        return tail.element;
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            head.element = element;
        } else if (index == size - 1) {
            tail.element = element;
        } else {
            findNodeByIndex(index).element = element;
        }
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            T removedElement = head.element;
            if (head.next == null) {
                head = tail = null;
            }
            head = head.next;
            size--;
            return removedElement;
        } else {
            Node<T> previousNode = findNodeByIndex(index - 1);
            T removedElement = previousNode.next.element;
            previousNode.next = previousNode.next.next;
            size--;
            return removedElement;
        }
    }

    @Override
    public boolean contains(T element) {
        Objects.requireNonNull(element);
        if (head != null) {
            if (element.equals(head.element)) {
                return true;
            } else if (element.equals(tail.element)) {
                return true;
            } else {
                Node<T> currentNode = head;
                for (int i = 0; i < size; i++) {
                    if (element.equals(currentNode.element)) {
                        return true;
                    }
                    currentNode = currentNode.next;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    private void isExist() {
        if (head == null) {
            throw new NoSuchElementException();
        }
    }
}
