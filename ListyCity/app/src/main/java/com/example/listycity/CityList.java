package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects.
 * It provides functionality to add, delete, and retrieve cities.
 */
public class CityList {
    /**
     * A list that holds City objects.
     */
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not already exist.
     * @param city This is a candidate city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list");
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities sorted by city name in alphabetical order.
     * @return The sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a city exists in the list.
     * @param city The city to check for
     * @return true if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list if it exists.
     * @param city The city to delete from the list
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City does not exist in the list");
        }
        cities.remove(city);
    }

    /**
     * Returns the total count of cities in the list.
     * @return The number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}