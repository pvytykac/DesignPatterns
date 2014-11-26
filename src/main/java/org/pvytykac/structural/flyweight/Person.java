package org.pvytykac.structural.flyweight;

public class Person {

    private String firstname;
    private String lastname;
    private Country country;

    public Person(String firstname, String lastname, Country country) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Country getCountry() {
        return country;
    }
}
