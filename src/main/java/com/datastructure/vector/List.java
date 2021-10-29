package com.datastructure.vector;

public class List<T> {

    private T[] elements;
    private int size;

    public List(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    //add element in a vector keeping in mind the true size of itself
    public void addElementGoodWay(T element) {
        increaseVectorCapacity();

        if (size < elements.length) {
            elements[size] = element;
            size++;
        }
    }

    //increase the capacity of a vector
    private void increaseVectorCapacity() {
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }
    }

    //add new elements in any vector position
    public void addNewElement(int position, T element) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("This position can not be accessed.");
        }

        increaseVectorCapacity();

        for (int i = size - 1; i >= position; i--) {
            elements[i + 1] = elements[i];
        }
        elements[position] = element;
        size++;
    }

    //verifies the real size of a vector
    public int getSize() {
        return this.size;
    }

    //find element in a specific position
    public T searchElement(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("This position can not be accessed.");
        }
        return elements[position];
    }

    //find the element inside a vector
    public int searchElement(T element) {
        //sequencial search
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsToList(T element) {
        return searchElement(element) > -1;
    }

    public int lastElement(T element) {

        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //how to remove an element from a vector
    public void remove(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("This position can not be accessed.");
        }

        for (int i = position; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void remove(T element) {
       int position = searchElement(element);
       if (position > -1) {
           remove(position);
       }
    }

    public void cleanList() {
        for (int i = 0; i < size + 1; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }


    //I think this is really ugly
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(elements[i]);
            stringBuilder.append(", ");
        }

        if (size > 0) {
            stringBuilder.append(elements[size - 1]);
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
