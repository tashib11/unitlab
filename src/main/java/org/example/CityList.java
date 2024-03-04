package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    /**
     *  constructor
     */
    public CityList(){}
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     *
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     *  Removes the specified city from the list.
     *
     * @param city The city to be removed.
     */
    public void delete(City city){
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * sortByCityName and province name
     *
     * @param sortByCityName for sorting
     *
     * @return sorted
     */

    public List<City> getCities(boolean sortByCityName)  {

        List<City> cityList = cities;
        if (sortByCityName) {
            Collections.sort(cityList);
        } else {
            cityList.sort(Comparator.comparing(City::getProvinceName));
        }

        return cityList;
    }

    /**
     * Returns the number of cities in the list.
     * @return  The size of the city list.
     */
    public  int count(){
       return cities.size();
    }
}