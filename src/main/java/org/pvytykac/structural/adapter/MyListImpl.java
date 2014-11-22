package org.pvytykac.structural.adapter;

import java.util.Random;

public class MyListImpl<ELEMENT> implements MyList<ELEMENT> {

    private ELEMENT[] array;
    private int size;
    private Random random = new Random();

    @SuppressWarnings("unchecked")
    public MyListImpl() {
        this.array = (ELEMENT[]) new Object[10];
        this.size = 0;
    }

    @Override
    public ELEMENT getRandomElement() {
        if(!isEmpty()){
            int randomIx = random.nextInt(size);
            return array[randomIx];
        }

        return null;
    }

    @Override
    public void addElement(ELEMENT element) {
        if(!isFull()){
            array[size++] = element;
        }else
            throw new RuntimeException("The list is full.");
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean isFull() {
        return size >= array.length;
    }
}
