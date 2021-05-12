import model.City;
import service.CityParser;

import java.io.File;
import java.util.List;
import java.util.Map;

import static util.Util.*;

public class Main {
    private static String FILE_PATH = "files/cities.txt";

    public static void main(String[] args) {
        // Module 1
        List<City> cities = CityParser.parse(new File(FILE_PATH));
        cities.forEach(System.out::println);

        // Module 2
        sortCitiesByNameIgnoreCase(cities);
        System.out.println("\n1st sort");
        cities.forEach(System.out::println);

        sortCitiesByDistrictThenByName(cities);
        System.out.println("\n2nd sort:");
        cities.forEach(System.out::println);

        // Module 3
        int[] maxPopulation = findCityWithHighestPopulation(cities);
        System.out.printf("\n[%d] = %d", maxPopulation[0], maxPopulation[1]);

        // Module 4
        Map<String, Integer> citiesNumberByRegions = getCitiesNumberByRegions(cities);
        System.out.println("\n");
        citiesNumberByRegions.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        });
        }
    }

