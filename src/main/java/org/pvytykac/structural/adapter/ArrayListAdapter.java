package org.pvytykac.structural.adapter;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListAdapter<ELEMENT> implements MyList<ELEMENT>{

    private ArrayList<ELEMENT> list;
    private Random random = new Random();

    public ArrayListAdapter(ArrayList<ELEMENT> list) {
        this.list = list;
    }

    @Override
    public ELEMENT getRandomElement() {
        if(list != null && !list.isEmpty()){
            int randomIx = random.nextInt(list.size());
            return list.get(randomIx);
        }

        return null;
    }

    @Override
    public void addElement(ELEMENT element) {
        list.add(element);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
