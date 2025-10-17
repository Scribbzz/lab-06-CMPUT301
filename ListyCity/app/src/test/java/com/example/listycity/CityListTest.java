package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    /**
     * Creates a mock CityList with one city already added.
     * @return A CityList containing one city (Edmonton, Alberta)
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates a mock City object (Edmonton, Alberta).
     * @return A City object representing Edmonton, Alberta
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Test for the add() method to verify that cities are successfully added.
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Test for the add() method to verify that an exception is thrown
     * when attempting to add a duplicate city.
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Test for the getCities() method to verify that cities are returned
     * in sorted order by city name.
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Test for the hasCity() method to verify that it correctly identifies
     * whether a city exists in the list.
     */
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City edmonton = new City("Edmonton", "Alberta");
        City vancouver = new City("Vancouver", "British Columbia");
        assertTrue(cityList.hasCity(edmonton));
        assertFalse(cityList.hasCity(vancouver));
    }

    /**
     * Test for the delete() method to verify that a city is successfully
     * removed from the list.
     */
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City edmonton = new City("Edmonton", "Alberta");
        assertEquals(1, cityList.countCities());
        cityList.delete(edmonton);
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(edmonton));
    }

    /**
     * Test for the delete() method to verify that an exception is thrown
     * when attempting to delete a city that does not exist in the list.
     */
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City vancouver = new City("Vancouver", "British Columbia");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(vancouver);
        });
    }

    /**
     * Test for the countCities() method to verify that it correctly returns
     * the number of cities in the list.
     */
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(3, cityList.countCities());
    }
}