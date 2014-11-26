package org.pvytykac.structural.flyweight;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlyweightTest {

    @Test
    public void flyWeightTest(){
        String[] countries = new String[]{"USA", "Czech Republic", "Slovak republic"};
        PersonRepository personRepository = new PersonRepository();

        // add 1000 persons for all countries
        for(String country: countries){
            for(int i = 0; i < 50; i++){
                String firstname = "firstname" + i;
                String lastname = "lastname" + i;
                personRepository.addPerson(firstname, lastname, country);
            }
        }

        // verify only 1 object got created for all countries
        Iterator<Person> itPerson = personRepository.iterator();
        Set<Country> setCountry = new HashSet<>();
        while(itPerson.hasNext()){
            Person person = itPerson.next();
            System.out.println(person.getFirstname() + " " + person.getLastname() + " " + person.getCountry().getName());
            setCountry.add(person.getCountry());
        }

        assertEquals(countries.length, setCountry.size());
    }

}
