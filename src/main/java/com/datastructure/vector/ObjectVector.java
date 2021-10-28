package com.datastructure.vector;

public class ObjectVector {

    private Object[] elements;
    private int size;

    public ObjectVector(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
    }

    //add element in a vector in a bad way.
    public void addElementBadWay(Object element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                this.elements[i] = element;
                break;
            }
        }
    }

    //add element in a vector keeping in mind the true size
    public void addElementGoodWay(Object element) {
        increaseVectorCapacity();

        if (size < elements.length) {
            elements[size] = element;
            size++;
        }
    }

    //increase the capacity of a vector
    private void increaseVectorCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }
    }

    //add new elements in any vector position
    public void addNewElement(int position, Object element) {
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
    public Object searchElement(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("This position can not be accessed.");
        }
        return elements[position];
    }

    //find the element inside a vector
    public int findElement(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    //how to remove an element from a vector
    public void removeElement(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("This position can not be accessed.");
        }

        for (int i = position; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
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
