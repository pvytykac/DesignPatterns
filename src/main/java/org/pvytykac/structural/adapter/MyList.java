package org.pvytykac.structural.adapter;

public interface MyList<ELEMENT> {

    public ELEMENT getRandomElement();
    public void addElement(ELEMENT element);
    public void clear();
    public int size();
    public boolean isEmpty();
    public boolean isFull();

}
