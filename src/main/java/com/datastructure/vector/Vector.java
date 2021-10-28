package com.datastructure.vector;

public class Vector {

    private String[] elements;
    private int size;

    public Vector(int capacity) {
        this.elements = new String[capacity];
        this.size = 0;
    }

    //add element in a vector in a bad way, you gonna have to go through
    //all the elements till you find an open position in the vector
    public void addElementBadWay(String element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                this.elements[i] = element;
                break;
            }
        }
    }

    //add element in a vector keeping in mind the true size
    //so you don't have to go through all the vector to find the open position
    public void addElementGoodWay(String element) throws Exception {
        increaseVectorCapacity();

        if (size < elements.length) {
            elements[size] = element;
            size++;
        } else {
            throw new Exception("Vector is full.");
        }
    }

    //increase the capacity of a vector
    private void increaseVectorCapacity() {
        if (size == elements.length) {
            String[] newElements = new String[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] =  elements[i];
            }

            elements = newElements;
        }
    }

    //add new elements in any vector position
    public void addNewElement(int position, String element) {
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
    public String searchElement(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("This position can not be accessed.");
        }
        return elements[position];
    }

    //find the element inside a vector
    public int findElement(String element) {
        //sequencial search
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
