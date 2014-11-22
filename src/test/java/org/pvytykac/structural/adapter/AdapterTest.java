package org.pvytykac.structural.adapter;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class AdapterTest {

    @Test
    public void adapterTest(){
        MyList <Integer> arrayListAdapter = new ArrayListAdapter<>(new ArrayList<Integer>());
        MyList<Integer> myList = new MyListImpl<>();
        Exception ex = null;

        for(int i = 0; i < 10; i++){
            myList.addElement(i);
            arrayListAdapter.addElement(i);
        }

        try{
            myList.addElement(11);
        }catch(RuntimeException e){
            ex = e;
            System.err.println(e.getMessage());
        }

        if(ex == null){
            fail("Expected runtimeException was not thrown.");
        }

        assertEquals(10, myList.size());
        assertEquals(10, arrayListAdapter.size());
        assertTrue("myList is not full", myList.isFull());
        assertFalse("arrayListAdapter is full", arrayListAdapter.isFull());

        for(int i = 0; i < 10; i++){
            System.out.println("myList.randomElement = " + myList.getRandomElement());
            System.out.println("arrayListAdapter.randomElement = " + arrayListAdapter.getRandomElement());
        }

        myList.clear();
        arrayListAdapter.clear();
        assertNull(myList.getRandomElement());
        assertNull(arrayListAdapter.getRandomElement());
        assertEquals(0, myList.size());
        assertEquals(0, arrayListAdapter.size());
        assertTrue("arrayListAdapter is not empty", myList.isEmpty());
        assertTrue("arrayListAdapter is not empty", arrayListAdapter.isEmpty());

    }

}
