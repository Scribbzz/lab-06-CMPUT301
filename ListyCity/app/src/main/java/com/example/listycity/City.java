package com.example.listycity;

/**
 * This is a class that defines a City.
 * Each city has a name and a province.
 */
public class City implements Comparable<City> {
    /**
     * The name of the city.
     */
    private String city;

    /**
     * The province where the city is located.
     */
    private String province;

    /**
     * Constructor for City class.
     * @param city The name of the city
     * @param province The province where the city is located
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of the city.
     * @return The city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Gets the province where the city is located.
     * @return The province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares two cities by their city name in lexicographical order.
     * @param o The City object to compare with
     * @return A negative integer if this city's name comes before the other city's name,
     *         zero if they are equal, or a positive integer if this city's name comes after
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Checks if two City objects are equal by comparing their city name and province.
     * @param o The object to compare with
     * @return true if both the city name and province are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && province.equals(city1.province);
    }

    /**
     * Returns the hash code for this City object.
     * @return The hash code based on city name and province
     */
    @Override
    public int hashCode() {
        return (city + province).hashCode();
    }
}