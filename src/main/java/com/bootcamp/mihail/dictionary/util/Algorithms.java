package com.bootcamp.mihail.dictionary.util;

import com.bootcamp.mihail.dictionary.model.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithms {
    private Algorithms() {}

    /**
     * Находит индекс элемента и значение с наибольшим количеством жителей города
     */
    public static int[] findCityWithHighestPopulation(List<City> cities) {
        if (cities.isEmpty()) {
            return new int[]{0, 0};
        }

        City[] citiesArr = cities.toArray(new City[0]);
        int maxIndex = 0;
        for (int i = 0; i < citiesArr.length; i++) {
            if (citiesArr[i].getPopulation() > citiesArr[maxIndex].getPopulation()) {
                maxIndex = i;
            }
        }

        return new int[]{maxIndex, citiesArr[maxIndex].getPopulation()};
    }

    /**
     * Определяет количество городов в разрезе регионов
     */
    public static Map<String, Integer> getCitiesNumberByRegions(List<City> cities) {
        Map<String, Integer> map = new HashMap<>();
        for (City city : cities) {
            String curRegion = city.getRegion();
            if (map.containsKey(curRegion)) {
                map.put(curRegion, map.get(curRegion) + 1);
            } else {
                map.put(curRegion, 1);
            }
        }

        return map;
    }
}
