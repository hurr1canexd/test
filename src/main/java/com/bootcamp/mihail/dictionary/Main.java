package com.bootcamp.mihail.dictionary;

import com.bootcamp.mihail.dictionary.model.City;
import com.bootcamp.mihail.dictionary.service.CityParser;
import com.bootcamp.mihail.dictionary.service.Sorter;
import com.bootcamp.mihail.dictionary.util.Algorithms;
import com.bootcamp.mihail.dictionary.util.Comparators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    private static String FILE_PATH = "src/main/resources/cities.txt";

    public static void main(String[] args) {
        // Module 1
        List<City> cities = new ArrayList<>();
        CityParser.parse(new File(FILE_PATH), cities);
        cities.forEach(System.out::println);

        // Module 2
        Sorter sorter = new Sorter();
        sorter.setComparator(Comparators.cityByNameComparator);
        sorter.sort(cities);
        System.out.println("\n1st sort");
        cities.forEach(System.out::println);

        sorter.setComparator(Comparators.cityByDistrictThenByNameComparator);
        sorter.sort(cities);
        System.out.println("\n2nd sort:");
        cities.forEach(System.out::println);

        // Module 3
        int[] maxPopulation = Algorithms.findCityWithHighestPopulation(cities);
        System.out.printf("\nГород с максимальным населением:\n[%d] = %d\n", maxPopulation[0], maxPopulation[1]);

        // Module 4
        Map<String, Integer> citiesNumberByRegions = Algorithms.getCitiesNumberByRegions(cities);
        System.out.println("\nКоличество городов по регионам:");
        citiesNumberByRegions.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
