package test.java;

import model.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.CityParser;
import service.Sorter;
import util.Comparators;

import java.io.File;
import java.util.*;

import static util.Algorithms.findCityWithHighestPopulation;
import static util.Algorithms.getCitiesNumberByRegions;

public class Tests {
    private List<City> cities;
    private final Sorter sorter = new Sorter();
    private final String FILE_PATH = "files/cities.txt";

    @Before
    public void init() {
        cities = new ArrayList<>(
                Arrays.asList(
                        new City(new String[]{"1", "Адыгейск", "Адыгея", "Южный", "12248", "1973"}),
                        new City(new String[]{"2", "Майкоп", "Адыгея", "Южный", "144246", "1857"}),
                        new City(new String[]{"3", "Горно-Алтайск", "Алтай", "Сибирский", "56928", "1830"}),
                        new City(new String[]{"4", "Абаза", "Хакасия", "Сибирский", "17111", "1867"}),
                        new City(new String[]{"5", "Абакан", "Хакасия", "Сибирский", "165183", "1931"}),
                        new City(new String[]{"6", "Абдулино", "Оренбургская область", "Приволжский", "20663", "1795"}),
                        new City(new String[]{"7", "Алдан", "Якутия", "Дальневосточный", "21277", "1924"}),
                        new City(new String[]{"8", "Александровск-Сахалинский", "Сахалинская область", "Дальневосточный", "10613", "1869"}),
                        new City(new String[]{"9", "Амурск", "Хабаровский край", "Дальневосточный", "42977", "1958"}),
                        new City(new String[]{"10", "Агидель", "Башкортостан", "Приволжский", "16365", "1980"}),
                        new City(new String[]{"11", "Агрыз", "Татарстан", "Приволжский", "19299", "1646"})
                )
        );
    }

    @Test
    public void shouldParseTest() {
        List<City> expected = new ArrayList<>();
        CityParser.parse(new File(FILE_PATH), expected);
        Assert.assertEquals(cities, expected);
    }

    @Test
    public void sortByNameTest() {
        List<City> expected = new ArrayList<>(
                Arrays.asList(
                        new City(new String[]{"4", "Абаза", "Хакасия", "Сибирский", "17111", "1867"}),
                        new City(new String[]{"5", "Абакан", "Хакасия", "Сибирский", "165183", "1931"}),
                        new City(new String[]{"6", "Абдулино", "Оренбургская область", "Приволжский", "20663", "1795"}),
                        new City(new String[]{"10", "Агидель", "Башкортостан", "Приволжский", "16365", "1980"}),
                        new City(new String[]{"11", "Агрыз", "Татарстан", "Приволжский", "19299", "1646"}),
                        new City(new String[]{"1", "Адыгейск", "Адыгея", "Южный", "12248", "1973"}),
                        new City(new String[]{"7", "Алдан", "Якутия", "Дальневосточный", "21277", "1924"}),
                        new City(new String[]{"8", "Александровск-Сахалинский", "Сахалинская область", "Дальневосточный", "10613", "1869"}),
                        new City(new String[]{"9", "Амурск", "Хабаровский край", "Дальневосточный", "42977", "1958"}),
                        new City(new String[]{"3", "Горно-Алтайск", "Алтай", "Сибирский", "56928", "1830"}),
                        new City(new String[]{"2", "Майкоп", "Адыгея", "Южный", "144246", "1857"})
                )
        );
        sorter.setComparator(Comparators.cityByNameComparator);
        sorter.sort(cities);
        Assert.assertEquals(expected, cities);
    }

    @Test
    public void sortByDistrictThenByNameTest() {
        List<City> expected = new ArrayList<>(
                Arrays.asList(
                        new City(new String[]{"7", "Алдан", "Якутия", "Дальневосточный", "21277", "1924"}),
                        new City(new String[]{"8", "Александровск-Сахалинский", "Сахалинская область", "Дальневосточный", "10613", "1869"}),
                        new City(new String[]{"9", "Амурск", "Хабаровский край", "Дальневосточный", "42977", "1958"}),
                        new City(new String[]{"6", "Абдулино", "Оренбургская область", "Приволжский", "20663", "1795"}),
                        new City(new String[]{"10", "Агидель", "Башкортостан", "Приволжский", "16365", "1980"}),
                        new City(new String[]{"11", "Агрыз", "Татарстан", "Приволжский", "19299", "1646"}),
                        new City(new String[]{"4", "Абаза", "Хакасия", "Сибирский", "17111", "1867"}),
                        new City(new String[]{"5", "Абакан", "Хакасия", "Сибирский", "165183", "1931"}),
                        new City(new String[]{"3", "Горно-Алтайск", "Алтай", "Сибирский", "56928", "1830"}),
                        new City(new String[]{"1", "Адыгейск", "Адыгея", "Южный", "12248", "1973"}),
                        new City(new String[]{"2", "Майкоп", "Адыгея", "Южный", "144246", "1857"})
                )
        );
        sorter.setComparator(Comparators.cityByDistrictThenByNameComparator);
        sorter.sort(cities);
        Assert.assertEquals(expected, cities);
    }

    @Test
    public void findCityWithHighestPopulationTest() {
        int expected = findCityWithHighestPopulation(cities)[1];
        for (City city: cities) {
            Assert.assertTrue(city.getPopulation() <= expected);
        }
    }

    @Test
    public void getCitiesNumberByRegionsTest() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Хакасия", 2);
        expected.put("Оренбургская область", 1);
        expected.put("Башкортостан", 1);
        expected.put("Сахалинская область", 1);
        expected.put("Якутия", 1);
        expected.put("Хабаровский край", 1);
        expected.put("Татарстан", 1);
        expected.put("Адыгея", 2);
        expected.put("Алтай", 1);
        Assert.assertEquals(expected, getCitiesNumberByRegions(cities));
    }
}
