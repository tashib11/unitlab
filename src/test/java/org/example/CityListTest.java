package org.example;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    @Test

    public void testDelete() {
        CityList cityList = new CityList();
        City city1 = new City("City1", "Province1");
        City city2 = new City("City2", "Province2");
        cityList.add(city1);
        cityList.add(city2);

        assertEquals(2, cityList.count());
        cityList.delete(city1);
        assertEquals(1, cityList.count());

    }
    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city1 = new City("City1", "Province1");

        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city1));
    }
    @Test
    public void testCount() {
        CityList cityList = new CityList();
        City city1 = new City("City1", "Province1");
        City city2 = new City("City2", "Province2");

        assertEquals(0, cityList.count());
        cityList.add(city1);
        assertEquals(1, cityList.count());
        cityList.add(city2);
        assertEquals(2, cityList.count());
    }


    @Test
    void testSortByCityName() {
        CityList cityList = new CityList();
        City city1 = new City("CityB", "ProvinceB");
        City city2 = new City("CityA", "ProvinceA");
        City city3 = new City("CityC", "ProvinceA");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        List<City> sortedCities = cityList.getCities(true);

        assertEquals("CityA", sortedCities.get(0).getCityName());
        assertEquals("CityB", sortedCities.get(1).getCityName());
        assertEquals("CityC", sortedCities.get(2).getCityName());
    }

    @Test
    void testSortByProvinceName() {
        CityList cityList = new CityList();
        City city1 = new City("CityB", "ProvinceB");
        City city2 = new City("CityA", "ProvinceA");
        City city3 = new City("CityC", "ProvinceC");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        List<City> sortedCities = cityList.getCities(false);

        assertEquals("CityA", sortedCities.get(0).getCityName());
        assertEquals("CityB", sortedCities.get(1).getCityName());
        assertEquals("CityC", sortedCities.get(2).getCityName());
    }

}