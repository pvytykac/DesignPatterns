package org.pvytykac.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CountryFlyweight {

    private static CountryFlyweight instance = new CountryFlyweight();

    private Map<String, Country> mapCountry = new HashMap<>();

    public static CountryFlyweight getInstance() {
        return instance;
    }

    public Country lookUp(String country){
        if(mapCountry.containsKey(country)){
            return mapCountry.get(country);
        }

        Country c = new Country(country);
        mapCountry.put(country, c);

        return c;
    }

}
