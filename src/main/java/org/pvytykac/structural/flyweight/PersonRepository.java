package org.pvytykac.structural.flyweight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonRepository implements Iterable<Person>{

    private List<Person> liPerson = new ArrayList<>();

    public void addPerson(String firstname, String lastname, String coutnry){
        Country c = CountryFlyweight.getInstance().lookUp(coutnry);
        liPerson.add(new Person(firstname, lastname, c));
    }

    @Override
    public Iterator<Person> iterator() {
        return liPerson.iterator();
    }
}
